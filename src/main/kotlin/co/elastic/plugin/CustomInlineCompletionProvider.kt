/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package co.elastic.plugin

import co.elastic.plugin.JavaExamples.Companion.listOfExamples
import com.intellij.codeInsight.inline.completion.InlineCompletionEvent
import com.intellij.codeInsight.inline.completion.InlineCompletionProvider
import com.intellij.codeInsight.inline.completion.InlineCompletionProviderID
import com.intellij.codeInsight.inline.completion.InlineCompletionRequest
import com.intellij.codeInsight.inline.completion.elements.InlineCompletionGrayTextElement
import com.intellij.codeInsight.inline.completion.suggestion.InlineCompletionSingleSuggestion
import com.intellij.codeInsight.inline.completion.suggestion.InlineCompletionSuggestion
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.util.UserDataHolderBase
import com.intellij.psi.*
import com.intellij.psi.codeStyle.CodeStyleManager
import com.intellij.psi.util.PsiTreeUtil
import kotlinx.coroutines.flow.flowOf

class CustomInlineCompletionProvider : InlineCompletionProvider {
    override val id: InlineCompletionProviderID
        get() = InlineCompletionProviderID("Java client examples")

    override suspend fun getSuggestion(request: InlineCompletionRequest): InlineCompletionSuggestion {
        val file = request.file
        val offset = request.endOffset

        // find the element at cursor position
        val element = file.findElementAt(offset - 1) ?: return InlineCompletionSuggestion.Empty

        // check if the first element is an instance of the java client
        val isClientOfCorrectType = ReadAction.compute<Boolean, Throwable> {
            isClientOfCorrectType(element)
        }
        if (isClientOfCorrectType) {
            // get the full text
            val text = ReadAction.compute<String, Throwable> {
                getFullLineText(element)
            } ?: return InlineCompletionSuggestion.Empty

            // removing the custom client name
            val textNoClient = text.substring(text.indexOf('.') + 1)
            // calculating indentation to apply to autocompletion
            val spaces = ReadAction.compute<String, Throwable> {
                getIndentation(element)
            }

            val result = listOfExamples.stream()
                // removing "client." from the examples
                .map { it.substring(it.indexOf('.') + 1) }
                .filter { it.startsWith(textNoClient) }
                .findFirst().orElse("")

            if (result.isEmpty()) return InlineCompletionSuggestion.Empty

            // suggestion must precisely complete line without repetitions
            val resultWithoutExistingText = result.replaceFirst(textNoClient, "")
            // applying indentation
            val resultWithIndentation = resultWithoutExistingText.replace("\n", "\n" + spaces)

            return InlineCompletionSingleSuggestion.build(
                UserDataHolderBase(),
                flowOf(
                    InlineCompletionGrayTextElement(
                        resultWithIndentation
                    )
                )
            )
        }

        return InlineCompletionSuggestion.Empty
    }

    private fun getFullLineText(element: PsiElement): String? {
        val fullLine: PsiExpression =
            PsiTreeUtil.getParentOfType(element, PsiExpression::class.java) ?: return null
        return fullLine.text
    }

    override fun isEnabled(event: InlineCompletionEvent): Boolean {
        return event.toRequest()?.file?.language?.id == "JAVA"
    }

    private fun isClientOfCorrectType(element: PsiElement): Boolean {
        // get the root variable of the method chain
        val rootVariable = getRootVariableOfChain(element) ?: return false

        // resolve to the actual class
        val type = rootVariable.type as? PsiClassType ?: return false
        val psiClass = type.resolve() ?: return false

        val qualifiedName = psiClass.qualifiedName

        // check if it's either a sync or async client instance
        return qualifiedName == "co.elastic.clients.elasticsearch.ElasticsearchClient" ||
                qualifiedName == "co.elastic.clients.elasticsearch.ElasticsearchAsyncClient"
    }

    private fun getIndentation(element: PsiElement): String {
        val file = element.containingFile
        val document = PsiDocumentManager.getInstance(element.project).getDocument(file) ?: return ""

        val startOffset = element.textRange.startOffset
        val lineNumber = document.getLineNumber(startOffset)
        val lineStartOffset = document.getLineStartOffset(lineNumber)

        // get the indentation in number of spaces
        val codeStyleManager = CodeStyleManager.getInstance(element.project)
        val indent = codeStyleManager.getLineIndent(file, lineStartOffset) ?: return ""

        // TODO get project indentation style from se
        return " ".repeat(indent.length)
    }

    /**
    Example Psi structure:
    PsiMethodCallExpression: client.method().anotherMethod()
    ├── PsiReferenceExpression (methodExpression): client.method().anotherMethod
    │   └── PsiMethodCallExpression (qualifier): client.method()
    │       ├── PsiReferenceExpression (methodExpression): client.method
    │       │   └── PsiReferenceExpression (qualifier): client
    │       └── PsiExpressionList: () // where method arguments would be
    └── PsiExpressionList: ()
     */
    private fun getRootVariableOfChain(element: PsiElement): PsiVariable? {

        var current: PsiExpression? = PsiTreeUtil.getParentOfType(element, PsiExpression::class.java)

        // going up the method chain to find the root
        while (current != null) {
            when (current) {

                // method call is "methodName()"
                is PsiMethodCallExpression -> {
                    val qualifier = current.methodExpression.qualifierExpression
                    if (qualifier != null) {
                        current = qualifier
                    } else {
                        break
                    }
                }

                // reference is just "methodName"
                is PsiReferenceExpression -> {
                    val qualifier = current.qualifierExpression
                    if (qualifier != null) {
                        current = qualifier
                    } else {
                        // root found, the client variable
                        val resolved = current.resolve()
                        return resolved as? PsiVariable
                    }
                }
                else -> break
            }
        }
        return null
    }
}
