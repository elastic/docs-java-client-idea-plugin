import groovy.json.JsonSlurper
import java.net.URL
import java.util.stream.Collectors

plugins {
    idea
    java
    id("org.jetbrains.intellij.platform") version "2.6.0"
    id("org.jetbrains.kotlin.jvm") version "2.2.0"
}

group = "co.elastic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2025.1.2")
        bundledPlugins("com.intellij.java", "com.intellij.properties", "org.jetbrains.kotlin")
        testFramework(org.jetbrains.intellij.platform.gradle.TestFrameworkType.Platform)
    }
}

intellijPlatform {
    publishing {
        token = providers.gradleProperty("intellijPlatformPublishingToken")
    }
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "242"
        }

        changeNotes = """
          First upload
        """
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
kotlin {
    jvmToolchain {
        this.languageVersion.set(JavaLanguageVersion.of(21))
    }
}



tasks.register("extractExampleMap") {
    doLast {
        // Use the raw GitHub URL
        val url =
            "https://raw.githubusercontent.com/elastic/elasticsearch-specification/9a1090de4498a6fcbff76b7168cb7ea20fa0f640/docs/examples/languageExamples.json"

        // Download and parse JSON
        val jsonContent = URL(url).readText()
        val jsonSlurper = JsonSlurper()
        val data = jsonSlurper.parseText(jsonContent) as Map<*, *>

        // Extract all Java code snippets
        val javaCodes = mutableListOf<String>() // Pair of (example name, code)

        data.forEach { (exampleKey, examplesArray) ->
            if (examplesArray is List<*>) {
                examplesArray.forEach { item ->
                    if (item is Map<*, *>) {
                        if (item["language"] == "Java") {
                            val code = item["code"] as? String
                            if (code != null) {
                                javaCodes.add(code)
                            }
                        }
                    }
                }
            }
        }

        val listentries = javaCodes.stream()
            .sorted(Comparator.naturalOrder())
            .map { x -> x.replace("\${","{") }
            .map { x -> x.replace("    ","\t") }
            .collect(Collectors.joining("\"\"\",\"\"\"","\"\"\"","\"\"\""))

        val fileContent = """
package co.elastic.plugin

class JavaExamples {

    companion object {
        @JvmStatic
        val listOfExamples = listOf($listentries)
    }
}
        """.trimIndent()

        val path = "src/main/kotlin/co/elastic/plugin/JavaExamples.kt"

        File(path).printWriter().use { out ->
            out.println(fileContent)
        }

    }
}
