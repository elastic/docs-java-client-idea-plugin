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

class JavaExamples {

    companion object {
        @JvmStatic
        val listOfExamples = listOf("""client.asyncSearch().delete(d -> d
	.id("FmRldE8zREVEUzA2ZVpUeGs2ejJFUFEaMkZ5QTVrSTZSaVN3WlNFVmtlWHJsdzoxMDc=")
);
""","""client.asyncSearch().get(g -> g
	.id("FmRldE8zREVEUzA2ZVpUeGs2ejJFUFEaMkZ5QTVrSTZSaVN3WlNFVmtlWHJsdzoxMDc=")
);
""","""client.asyncSearch().status(s -> s
	.id("FmRldE8zREVEUzA2ZVpUeGs2ejJFUFEaMkZ5QTVrSTZSaVN3WlNFVmtlWHJsdzoxMDc=")
);
""","""client.asyncSearch().submit(s -> s
	.aggregations("sale_date", a -> a
		.dateHistogram(d -> d
			.calendarInterval(CalendarInterval.Day)
			.field("date")
		)
	)
	.index("sales*")
	.size(0)
	.sort(so -> so
		.field(f -> f
			.field("date")
			.order(SortOrder.Asc)
		)
	)
,Void.class);
""","""client.autoscaling().deleteAutoscalingPolicy(d -> d
	.name("*")
);
""","""client.autoscaling().getAutoscalingCapacity(g -> g);
""","""client.autoscaling().getAutoscalingPolicy(g -> g
	.name("my_autoscaling_policy")
);
""","""client.autoscaling().putAutoscalingPolicy(p -> p
	.name("<name>")
	.policy(po -> po
		.deciders("fixed", JsonData.fromJson("{}"))
	)
);
""","""client.autoscaling().putAutoscalingPolicy(p -> p
	.name("my_autoscaling_policy")
	.policy(po -> po
		.roles("data_hot")
		.deciders("fixed", JsonData.fromJson("{}"))
	)
);
""","""client.cat().aliases();
""","""client.cat().allocation();
""","""client.cat().componentTemplates();
""","""client.cat().count();
""","""client.cat().fielddata();
""","""client.cat().health();
""","""client.cat().indices();
""","""client.cat().master();
""","""client.cat().mlDataFrameAnalytics();
""","""client.cat().mlDatafeeds();
""","""client.cat().mlJobs();
""","""client.cat().mlTrainedModels();
""","""client.cat().nodeattrs();
""","""client.cat().nodes();
""","""client.cat().pendingTasks();
""","""client.cat().plugins();
""","""client.cat().recovery();
""","""client.cat().repositories();
""","""client.cat().segments();
""","""client.cat().shards();
""","""client.cat().snapshots();
""","""client.cat().tasks();
""","""client.cat().templates();
""","""client.cat().threadPool();
""","""client.cat().transforms();
""","""client.ccr().deleteAutoFollowPattern(d -> d
	.name("my_auto_follow_pattern")
);
""","""client.ccr().follow(f -> f
	.index("follower_index")
	.leaderIndex("leader_index")
	.maxOutstandingReadRequests(16L)
	.maxOutstandingWriteRequests(8)
	.maxReadRequestOperationCount(1024)
	.maxReadRequestSize("1024k")
	.maxRetryDelay(m -> m
		.time("10s")
	)
	.maxWriteBufferCount(512)
	.maxWriteBufferSize("512k")
	.maxWriteRequestOperationCount(32768)
	.maxWriteRequestSize("16k")
	.readPollTimeout(r -> r
		.time("30s")
	)
	.remoteCluster("remote_cluster")
	.settings(s -> s
		.otherSettings("index.number_of_replicas", JsonData.fromJson("0"))
	)
	.waitForActiveShards(w -> w
		.count(1)
	)
);
""","""client.ccr().followInfo(f -> f
	.index("follower_index")
);
""","""client.ccr().followStats(f -> f
	.index("follower_index")
);
""","""client.ccr().forgetFollower(f -> f
	.followerCluster("<follower_cluster>")
	.followerIndex("<follower_index>")
	.followerIndexUuid("<follower_index_uuid>")
	.index("<leader_index>")
	.leaderRemoteCluster("<leader_remote_cluster>")
);
""","""client.ccr().getAutoFollowPattern(g -> g
	.name("my_auto_follow_pattern")
);
""","""client.ccr().pauseAutoFollowPattern(p -> p
	.name("my_auto_follow_pattern")
);
""","""client.ccr().pauseFollow(p -> p
	.index("follower_index")
);
""","""client.ccr().putAutoFollowPattern(p -> p
	.followIndexPattern("{{leader_index}}-follower")
	.leaderIndexPatterns("leader_index*")
	.maxOutstandingReadRequests(16)
	.maxOutstandingWriteRequests(8)
	.maxReadRequestOperationCount(1024)
	.maxReadRequestSize("1024k")
	.maxRetryDelay(m -> m
		.time("10s")
	)
	.maxWriteBufferCount(512)
	.maxWriteBufferSize("512k")
	.maxWriteRequestOperationCount(32768)
	.maxWriteRequestSize("16k")
	.name("my_auto_follow_pattern")
	.readPollTimeout(r -> r
		.time("30s")
	)
	.remoteCluster("remote_cluster")
	.settings("index.number_of_replicas", JsonData.fromJson("0"))
);
""","""client.ccr().resumeAutoFollowPattern(r -> r
	.name("my_auto_follow_pattern")
);
""","""client.ccr().resumeFollow(r -> r
	.index("follower_index")
	.maxOutstandingReadRequests(16L)
	.maxOutstandingWriteRequests(8L)
	.maxReadRequestOperationCount(1024L)
	.maxReadRequestSize("1024k")
	.maxRetryDelay(m -> m
		.time("10s")
	)
	.maxWriteBufferCount(512L)
	.maxWriteBufferSize("512k")
	.maxWriteRequestOperationCount(32768L)
	.maxWriteRequestSize("16k")
	.readPollTimeout(re -> re
		.time("30s")
	)
);
""","""client.ccr().stats(s -> s);
""","""client.ccr().unfollow(u -> u
	.index("follower_index")
);
""","""client.clearScroll(c -> c
	.scrollId("DXF1ZXJ5QW5kRmV0Y2gBAAAAAAAAAD4WYm9laVYtZndUQlNsdDcwakFMNjU1QQ==")
);
""","""client.closePointInTime(c -> c
	.id("46ToAwMDaWR5BXV1aWQyKwZub2RlXzMAAAAAAAAAACoBYwADaWR4BXV1aWQxAgZub2RlXzEAAAAAAAAAAAEBYQADaWR5BXV1aWQyKgZub2RlXzIAAAAAAAAAAAwBYgACBXV1aWQyAAAFdXVpZDEAAQltYXRjaF9hbGw_gAAAAA==")
);
""","""client.cluster().allocationExplain(a -> a
	.currentNode("my-node")
	.index("my-index-000001")
	.primary(false)
	.shard(0)
);
""","""client.cluster().allocationExplain(a -> a
	.currentNode("my-node")
	.index("my-index-000001")
	.primary(false)
	.shard(0)
);
""","""client.cluster().deleteComponentTemplate(d -> d
	.name("template_1")
);
""","""client.cluster().getComponentTemplate(g -> g
	.name("template_1")
);
""","""client.cluster().getSettings(g -> g);
""","""client.cluster().health(h -> h);
""","""client.cluster().info(i -> i
	.target("_all")
);
""","""client.cluster().pendingTasks(p -> p);
""","""client.cluster().putComponentTemplate(p -> p
	.name("template_1")
	.template(t -> t
		.aliases(Map.of("alias1", Alias.of(a -> a),"{index}-alias", Alias.of(a -> a),"alias2", Alias.of(a -> a
				.filter(f -> f
					.term(te -> te
						.field("user.id")
						.value(FieldValue.of("kimchy"))
					)
				)
				.routing("shard-1")
			)))
		.settings(s -> s
			.numberOfShards("1")
		)
	)
);
""","""client.cluster().putComponentTemplate(p -> p
	.name("template_1")
	.template(t -> t
		.mappings(m -> m
			.properties(Map.of("created_at", Property.of(pr -> pr
					.date(d -> d
						.format("EEE MMM dd HH:mm:ss Z yyyy")
					)
				),"host_name", Property.of(pro -> pro
					.keyword(k -> k)
				)))
			.source(s -> s
				.enabled(false)
			)
		)
		.settings(s -> s
			.numberOfShards("1")
		)
	)
);
""","""client.cluster().putSettings(p -> p
	.persistent("action.auto_create_index", JsonData.fromJson("\"my-index-000001,index10,-index1*,+ind*\""))
);
""","""client.cluster().putSettings(p -> p
	.persistent("indices.recovery.max_bytes_per_sec", JsonData.fromJson("\"50mb\""))
);
""","""client.cluster().putSettings(p -> p);
""","""client.cluster().remoteInfo();
""","""client.cluster().reroute(r -> r
	.commands(List.of(Command.of(c -> c
			.move(m -> m
				.index("test")
				.shard(0)
				.fromNode("node1")
				.toNode("node2")
			)
		),Command.of(c -> c
			.allocateReplica(a -> a
				.index("test")
				.shard(1)
				.node("node3")
			)
		)))
	.metric("none")
);
""","""client.cluster().state(s -> s);
""","""client.cluster().stats(s -> s);
""","""client.connector().checkIn(c -> c
	.connectorId("my-connector")
);
""","""client.connector().delete(d -> d
	.connectorId("my-connector-id&delete_sync_jobs=true")
);
""","""client.connector().get(g -> g
	.connectorId("my-connector-id")
);
""","""client.connector().list(l -> l);
""","""client.connector().put(p -> p
	.connectorId("my-connector")
	.description("My Connector to sync data to Elastic index from Google Drive")
	.indexName("search-google-drive")
	.language("english")
	.name("My Connector")
	.serviceType("google_drive")
);
""","""client.connector().put(p -> p
	.connectorId("my-connector")
	.indexName("search-google-drive")
	.name("My Connector")
	.serviceType("google_drive")
);
""","""client.connector().syncJobCancel(s -> s
	.connectorSyncJobId("my-connector-sync-job-id")
);
""","""client.connector().syncJobCheckIn(s -> s
	.connectorSyncJobId("my-connector-sync-job")
);
""","""client.connector().syncJobClaim(s -> s
	.connectorSyncJobId("my-connector-sync-job-id")
	.workerHostname("some-machine")
);
""","""client.connector().syncJobDelete(s -> s
	.connectorSyncJobId("my-connector-sync-job-id")
);
""","""client.connector().syncJobError(s -> s
	.connectorSyncJobId("my-connector-sync-job")
	.error("some-error")
);
""","""client.connector().syncJobGet(s -> s
	.connectorSyncJobId("my-connector-sync-job")
);
""","""client.connector().syncJobList(s -> s
	.connectorId("my-connector-id")
	.size(1)
);
""","""client.connector().syncJobPost(s -> s
	.id("connector-id")
	.jobType(SyncJobType.Full)
	.triggerMethod(SyncJobTriggerMethod.OnDemand)
);
""","""client.connector().syncJobUpdateStats(s -> s
	.connectorSyncJobId("my-connector-sync-job")
	.deletedDocumentCount(10L)
	.indexedDocumentCount(20L)
	.indexedDocumentVolume(1000L)
	.lastSeen(l -> l
		.time("2023-01-02T10:00:00Z")
	)
	.totalDocumentCount(2000)
);
""","""client.connector().updateApiKeyId(u -> u
	.apiKeyId("my-api-key-id")
	.apiKeySecretId("my-connector-secret-id")
	.connectorId("my-connector")
);
""","""client.connector().updateConfiguration(u -> u
	.connectorId("my-spo-connector")
	.values("secret_value", JsonData.fromJson("\"foo-bar\""))
);
""","""client.connector().updateConfiguration(u -> u
	.connectorId("my-spo-connector")
	.values(Map.of("tenant_id", JsonData.fromJson("\"my-tenant-id\""),"tenant_name", JsonData.fromJson("\"my-sharepoint-site\""),"secret_value", JsonData.fromJson("\"bar\""),"client_id", JsonData.fromJson("\"foo\""),"site_collections", JsonData.fromJson("\"*\"")))
);
""","""client.connector().updateError(u -> u
	.connectorId("my-connector")
	.error("Houston, we have a problem!")
);
""","""client.connector().updateFeatures(u -> u
	.connectorId("my-connector")
	.features(f -> f
		.documentLevelSecurity(d -> d
			.enabled(true)
		)
		.incrementalSync(i -> i
			.enabled(true)
		)
		.syncRules(s -> s
			.advanced(a -> a
				.enabled(false)
			)
			.basic(b -> b
				.enabled(true)
			)
		)
	)
);
""","""client.connector().updateFeatures(u -> u
	.connectorId("my-connector")
	.features(f -> f
		.documentLevelSecurity(d -> d
			.enabled(true)
		)
	)
);
""","""client.connector().updateFiltering(u -> u
	.advancedSnippet(a -> a
		.value(JsonData.fromJson("[{\"tables\":[\"users\",\"orders\"],\"query\":\"SELECT users.id AS id, orders.order_id AS order_id FROM users JOIN orders ON users.id = orders.user_id\"}]"))
	)
	.connectorId("my-sql-connector")
);
""","""client.connector().updateFiltering(u -> u
	.connectorId("my-g-drive-connector")
	.rules(List.of(FilteringRule.of(f -> f
			.field("file_extension")
			.id("exclude-txt-files")
			.order(0)
			.policy(FilteringPolicy.Exclude)
			.rule(FilteringRuleRule.Equals)
			.value("txt")
		),FilteringRule.of(f -> f
			.field("_")
			.id("DEFAULT")
			.order(1)
			.policy(FilteringPolicy.Include)
			.rule(FilteringRuleRule.Regex)
			.value(".*")
		)))
);
""","""client.connector().updateIndexName(u -> u
	.connectorId("my-connector")
	.indexName("data-from-my-google-drive")
);
""","""client.connector().updateName(u -> u
	.connectorId("my-connector")
	.description("This is my customized connector")
	.name("Custom connector")
);
""","""client.connector().updatePipeline(u -> u
	.connectorId("my-connector")
	.pipeline(p -> p
		.extractBinaryContent(true)
		.name("my-connector-pipeline")
		.reduceWhitespace(true)
		.runMlInference(true)
	)
);
""","""client.connector().updateScheduling(u -> u
	.connectorId("my-connector")
	.scheduling(s -> s
		.accessControl(a -> a
			.enabled(true)
			.interval("0 10 0 * * ?")
		)
		.full(f -> f
			.enabled(true)
			.interval("0 20 0 * * ?")
		)
		.incremental(i -> i
			.enabled(false)
			.interval("0 30 0 * * ?")
		)
	)
);
""","""client.connector().updateScheduling(u -> u
	.connectorId("my-connector")
	.scheduling(s -> s
		.full(f -> f
			.enabled(true)
			.interval("0 10 0 * * ?")
		)
	)
);
""","""client.connector().updateServiceType(u -> u
	.connectorId("my-connector")
	.serviceType("sharepoint_online")
);
""","""client.connector().updateStatus(u -> u
	.connectorId("my-connector")
	.status(ConnectorStatus.NeedsConfiguration)
);
""","""client.count(c -> c
	.index("my-index-000001")
	.query(q -> q
		.term(t -> t
			.field("user.id")
			.value(FieldValue.of("kimchy"))
		)
	)
);
""","""client.create(c -> c
	.id("1")
	.index("my-index-000001")
	.document(JsonData.fromJson("{\"@timestamp\":\"2099-11-15T13:12:00\",\"message\":\"GET /search HTTP/1.1 200 1070000\",\"user\":{\"id\":\"kimchy\"}}"))
);
""","""client.danglingIndices().deleteDanglingIndex(d -> d
	.acceptDataLoss(true)
	.indexUuid("<index-uuid>")
);
""","""client.danglingIndices().importDanglingIndex(i -> i
	.acceptDataLoss(true)
	.indexUuid("zmM4e0JtBkeUjiHD-MihPQ")
);
""","""client.danglingIndices().listDanglingIndices();
""","""client.delete(d -> d
	.id("1")
	.index("my-index-000001")
);
""","""client.deleteByQuery(d -> d
	.index("my-index-000001")
	.maxDocs(1L)
	.query(q -> q
		.term(t -> t
			.field("user.id")
			.value(FieldValue.of("kimchy"))
		)
	)
);
""","""client.deleteByQuery(d -> d
	.index("my-index-000001")
	.query(q -> q
		.range(r -> r
			.untyped(u -> u
				.field("http.response.bytes")
				.lt(JsonData.fromJson("2000000"))
			)
		)
	)
	.refresh(true)
	.slices(s -> s
		.value(5)
	)
);
""","""client.deleteByQuery(d -> d
	.index("my-index-000001")
	.query(q -> q
		.range(r -> r
			.untyped(u -> u
				.field("http.response.bytes")
				.lt(JsonData.fromJson("2000000"))
			)
		)
	)
	.slice(s -> s
		.id("0")
		.max(2)
	)
);
""","""client.deleteByQuery(d -> d
	.index(List.of("my-index-000001","my-index-000002"))
	.query(q -> q
		.matchAll(m -> m)
	)
);
""","""client.deleteByQueryRethrottle(d -> d
	.requestsPerSecond(-1.0F)
	.taskId("r1A2WoRbTwKZ516z6NEs5A:36619")
);
""","""client.deleteScript(d -> d
	.id("my-search-template")
);
""","""client.enrich().deletePolicy(d -> d
	.name("my-policy")
);
""","""client.enrich().executePolicy(e -> e
	.name("my-policy")
	.waitForCompletion(false)
);
""","""client.enrich().getPolicy(g -> g
	.name("my-policy")
);
""","""client.enrich().putPolicy(p -> p
	.geoMatch(g -> g
		.enrichFields(List.of("location","postal_code"))
		.indices("postal_codes")
		.matchField("location")
	)
	.name("postal_policy")
);
""","""client.enrich().stats(s -> s);
""","""client.eql().delete(d -> d
	.id("FmNJRUZ1YWZCU3dHY1BIOUhaenVSRkEaaXFlZ3h4c1RTWFNocDdnY2FSaERnUTozNDE=")
);
""","""client.eql().get(g -> g
	.id("FmNJRUZ1YWZCU3dHY1BIOUhaenVSRkEaaXFlZ3h4c1RTWFNocDdnY2FSaERnUTozNDE=")
	.waitForCompletionTimeout(w -> w
		.offset(2)
	)
);
""","""client.eql().getStatus(g -> g
	.id("FmNJRUZ1YWZCU3dHY1BIOUhaenVSRkEaaXFlZ3h4c1RTWFNocDdnY2FSaERnUTozNDE=")
);
""","""client.eql().search(s -> s
	.index("my-data-stream")
	.query("
	process where (process.name == "cmd.exe" and process.pid != 2013)
  ")
);
""","""client.eql().search(s -> s
	.index("my-data-stream")
	.query("
	sequence by process.pid
	  [ file where file.name == "cmd.exe" and process.pid != 2013 ]
	  [ process where stringContains(process.executable, "regsvr32") ]
  ")
);
""","""client.esql().query(q -> q
	.includeCcsMetadata(true)
	.query("
	FROM library,remote-*:library
	| EVAL year = DATE_TRUNC(1 YEARS, release_date)
	| STATS MAX(page_count) BY year
	| SORT year
	| LIMIT 5
  ")
);
""","""client.exists(e -> e
	.id("0")
	.index("my-index-000001")
);
""","""client.existsSource(e -> e
	.id("1")
	.index("my-index-000001")
);
""","""client.explain(e -> e
	.id("0")
	.index("my-index-000001")
	.query(q -> q
		.match(m -> m
			.field("message")
			.query(FieldValue.of("elasticsearch"))
		)
	)
);
""","""client.features().getFeatures(g -> g);
""","""client.features().resetFeatures(r -> r);
""","""client.fieldCaps(f -> f
	.fields("rating")
	.index("my-index-*")
	.indexFilter(i -> i
		.range(r -> r
			.untyped(u -> u
				.field("@timestamp")
				.gte(JsonData.fromJson("\"2018\""))
			)
		)
	)
);
""","""client.get(g -> g
	.id("1")
	.index("my-index-000001")
	.storedFields(List.of("tags","counter"))
);
""","""client.getScript(g -> g
	.id("my-search-template")
);
""","""client.getScriptContext();
""","""client.getScriptLanguages();
""","""client.getSource(g -> g
	.id("1")
	.index("my-index-000001")
);
""","""client.graph().explore(e -> e
	.connections(c -> c
		.vertices(v -> v
			.field("query.raw")
		)
	)
	.index("clicklogs")
	.query(q -> q
		.match(m -> m
			.field("query.raw")
			.query(FieldValue.of("midi"))
		)
	)
	.vertices(v -> v
		.field("product")
	)
);
""","""client.healthReport(h -> h);
""","""client.ilm().deleteLifecycle(d -> d
	.name("my_policy")
);
""","""client.ilm().explainLifecycle(e -> e
	.index(".ds-timeseries-*")
);
""","""client.ilm().getLifecycle(g -> g
	.name("my_policy")
);
""","""client.ilm().getStatus();
""","""client.ilm().migrateToDataTiers(m -> m
	.legacyTemplateToDelete("global-template")
	.nodeAttribute("custom_attribute_name")
);
""","""client.ilm().moveToStep(m -> m
	.currentStep(c -> c
		.action("complete")
		.name("complete")
		.phase("hot")
	)
	.index("my-index-000001")
	.nextStep(n -> n
		.phase("warm")
	)
);
""","""client.ilm().moveToStep(m -> m
	.currentStep(c -> c
		.action("complete")
		.name("complete")
		.phase("new")
	)
	.index("my-index-000001")
	.nextStep(n -> n
		.action("forcemerge")
		.name("forcemerge")
		.phase("warm")
	)
);
""","""client.ilm().putLifecycle(p -> p
	.name("my_policy")
	.policy(po -> po
		.phases(ph -> ph
			.delete(d -> d
				.actions(a -> a
					.delete(de -> de)
				)
				.minAge(m -> m
					.time("30d")
				)
			)
			.warm(w -> w
				.actions(a -> a
					.forcemerge(f -> f
						.maxNumSegments(1)
					)
				)
				.minAge(m -> m
					.time("10d")
				)
			)
		)
		.meta(Map.of("description", JsonData.fromJson("\"used for nginx log\""),"project", JsonData.fromJson("{\"name\":\"myProject\",\"department\":\"myDepartment\"}")))
	)
);
""","""client.ilm().removePolicy(r -> r
	.index("logs-my_app-default")
);
""","""client.ilm().retry(r -> r
	.index("my-index-000001")
);
""","""client.ilm().start(s -> s);
""","""client.ilm().stop(s -> s);
""","""client.index(i -> i
	.id("1")
	.index("my-index-000001")
	.document(JsonData.fromJson("{\"@timestamp\":\"2099-11-15T13:12:00\",\"message\":\"GET /search HTTP/1.1 200 1070000\",\"user\":{\"id\":\"kimchy\"}}"))
);
""","""client.index(i -> i
	.index("my-index-000001")
	.document(JsonData.fromJson("{\"@timestamp\":\"2099-11-15T13:12:00\",\"message\":\"GET /search HTTP/1.1 200 1070000\",\"user\":{\"id\":\"kimchy\"}}"))
);
""","""client.indices().addBlock(a -> a
	.block(IndicesBlockOptions.Write)
	.index("my-index-000001")
);
""","""client.indices().analyze(a -> a
	.analyzer("standard")
	.text("this is a test")
);
""","""client.indices().analyze(a -> a
	.analyzer("standard")
	.text(List.of("this is a test","the second text"))
);
""","""client.indices().analyze(a -> a
	.attributes("keyword")
	.explain(true)
	.filter(f -> f
		.name("snowball")
	)
	.text("detailed output")
	.tokenizer(t -> t
		.name("standard")
	)
);
""","""client.indices().analyze(a -> a
	.charFilter(c -> c
		.name("html_strip")
	)
	.filter(f -> f
		.name("lowercase")
	)
	.text("this is a test</b>")
	.tokenizer(t -> t
		.name("keyword")
	)
);
""","""client.indices().analyze(a -> a
	.field("obj1.field1")
	.index("analyze_sample")
	.text("this is a test")
);
""","""client.indices().analyze(a -> a
	.filter(List.of(TokenFilter.of(t -> t
			.name("lowercase")
		),TokenFilter.of(to -> to
			.definition(d -> d
				.stop(s -> s
					.stopwords(List.of("a","is","this"))
				)
			)
		)))
	.text("this is a test")
	.tokenizer(tok -> tok
		.name("whitespace")
	)
);
""","""client.indices().analyze(a -> a
	.index("analyze_sample")
	.normalizer("my_normalizer")
	.text("BaR")
);
""","""client.indices().cancelMigrateReindex(c -> c
	.index("my-data-stream")
);
""","""client.indices().clearCache(c -> c
	.index(List.of("my-index-000001","my-index-000002"))
	.request(true)
);
""","""client.indices().clone(c -> c
	.aliases("my_search_indices", a -> a)
	.index("my_source_index")
	.settings("index.refresh_interval", JsonData.fromJson("\"2s\""))
	.target("my_target_index")
);
""","""client.indices().close(c -> c
	.index("my-index-00001")
);
""","""client.indices().create(c -> c
	.aliases(Map.of("alias_2", Alias.of(a -> a
			.filter(f -> f
				.term(t -> t
					.field("user.id")
					.value(FieldValue.of("kimchy"))
				)
			)
			.routing("shard-1")
		),"alias_1", Alias.of(al -> al)))
	.index("test")
);
""","""client.indices().create(c -> c
	.index("my-index-000001")
	.settings(s -> s
		.numberOfShards("3")
		.numberOfReplicas("2")
	)
);
""","""client.indices().create(c -> c
	.index("test")
	.mappings(m -> m
		.properties("field1", p -> p
			.text(t -> t)
		)
	)
	.settings(s -> s
		.numberOfShards("1")
	)
);
""","""client.indices().createDataStream(c -> c
	.name("logs-foo-bar")
);
""","""client.indices().createFrom(c -> c
	.dest("my-new-index")
	.source("my-index")
	.createFrom(cr -> cr)
);
""","""client.indices().dataStreamsStats(d -> d
	.name("my-index-000001")
);
""","""client.indices().delete(d -> d
	.index("books")
);
""","""client.indices().deleteAlias(d -> d
	.index("my-data-stream")
	.name("my-alias")
);
""","""client.indices().deleteDataLifecycle(d -> d
	.name("my-data-stream")
);
""","""client.indices().deleteDataStream(d -> d
	.name("my-data-stream")
);
""","""client.indices().deleteIndexTemplate(d -> d
	.name("my-index-template")
);
""","""client.indices().deleteTemplate(d -> d
	.name(".cloud-hot-warm-allocation-0")
);
""","""client.indices().diskUsage(d -> d
	.index("my-index-000001")
	.runExpensiveTasks(true)
);
""","""client.indices().diskUsage(d -> d
	.index("my-index-000001")
	.runExpensiveTasks(true)
);
""","""client.indices().downsample(d -> d
	.index("my-time-series-index")
	.targetIndex("my-downsampled-time-series-index")
	.config(c -> c
		.fixedInterval(f -> f
			.time("1d")
		)
	)
);
""","""client.indices().exists(e -> e
	.index("my-data-stream")
);
""","""client.indices().existsAlias(e -> e
	.name("my-alias")
);
""","""client.indices().existsTemplate(e -> e
	.name("template_1")
);
""","""client.indices().explainDataLifecycle(e -> e
	.index(".ds-metrics-2023.03.22-000001")
);
""","""client.indices().fieldUsageStats(f -> f
	.index("my-index-000001")
);
""","""client.indices().flush(f -> f);
""","""client.indices().forcemerge(f -> f
	.index("my-index-000001")
);
""","""client.indices().get(g -> g
	.index("my-index-000001")
);
""","""client.indices().getAlias(g -> g);
""","""client.indices().getDataLifecycle(g -> g
	.name("{name}")
);
""","""client.indices().getDataLifecycleStats();
""","""client.indices().getDataStream(g -> g
	.name("my-data-stream")
);
""","""client.indices().getDataStreamMappings(g -> g
	.name("my-data-stream")
);
""","""client.indices().getDataStreamSettings(g -> g
	.name("my-data-stream")
);
""","""client.indices().getFieldMapping(g -> g
	.fields("title")
	.index("publications")
);
""","""client.indices().getIndexTemplate(g -> g
	.name("*")
);
""","""client.indices().getMapping(g -> g
	.index("books")
);
""","""client.indices().getMigrateReindexStatus(g -> g
	.index("my-data-stream")
);
""","""client.indices().getSettings(g -> g
	.expandWildcards("all")
	.index("_all")
);
""","""client.indices().getTemplate(g -> g
	.name(".monitoring-*")
);
""","""client.indices().migrateReindex(m -> m
	.reindex(r -> r
		.mode(ModeEnum.Upgrade)
		.source(s -> s
			.index("my-data-stream")
		)
	)
);
""","""client.indices().migrateToDataStream(m -> m
	.name("my-time-series-data")
);
""","""client.indices().modifyDataStream(m -> m
	.actions(List.of(Action.of(a -> a
			.removeBackingIndex(r -> r
				.dataStream("my-data-stream")
				.index(".ds-my-data-stream-2023.07.26-000001")
			)
		),Action.of(ac -> ac
			.addBackingIndex(ad -> ad
				.dataStream("my-data-stream")
				.index(".ds-my-data-stream-2023.07.26-000001-downsample")
			)
		)))
);
""","""client.indices().open(o -> o
	.index(".ds-my-data-stream-2099.03.07-000001")
);
""","""client.indices().promoteDataStream(p -> p
	.name("my-data-stream")
);
""","""client.indices().putAlias(p -> p
	.filter(f -> f
		.bool(b -> b
			.filter(List.of(Query.of(q -> q
					.range(r -> r
						.untyped(u -> u
							.field("@timestamp")
							.gte(JsonData.fromJson("\"now-1d/d\""))
							.lt(JsonData.fromJson("\"now/d\""))
						)
					)
				),Query.of(qu -> qu
					.term(t -> t
						.field("user.id")
						.value(FieldValue.of("kimchy"))
					)
				)))
		)
	)
	.index("my-index-2099.05.06-000001")
	.name("my-alias")
);
""","""client.indices().putAlias(p -> p
	.index("logs-my_app-default")
	.isWriteIndex(true)
	.name("logs")
);
""","""client.indices().putAlias(p -> p
	.index("my-index-2099.05.06-000001")
	.name("my-alias")
	.routing("1")
);
""","""client.indices().putDataLifecycle(p -> p
	.dataRetention(d -> d
		.time("7d")
	)
	.name("my-data-stream")
);
""","""client.indices().putDataStreamMappings(p -> p
	.name("my-data-stream")
	.mappings(m -> m
		.properties(Map.of("field1", Property.of(pr -> pr
				.ip(i -> i)
			),"field3", Property.of(pro -> pro
				.text(t -> t)
			)))
	)
);
""","""client.indices().putDataStreamSettings(p -> p
	.name("my-data-stream")
	.settings(s -> s
		.otherSettings(Map.of("index.lifecycle.name", JsonData.fromJson("\"new-test-policy\""),"index.number_of_shards", JsonData.fromJson("11")))
	)
);
""","""client.indices().putIndexTemplate(p -> p
	.indexPatterns("template*")
	.name("template_1")
	.priority(1L)
	.template(t -> t
		.settings(s -> s
			.numberOfShards("2")
		)
	)
);
""","""client.indices().putIndexTemplate(p -> p
	.indexPatterns("template*")
	.name("template_1")
	.template(t -> t
		.aliases(Map.of("alias1", Alias.of(a -> a),"{index}-alias", Alias.of(a -> a),"alias2", Alias.of(a -> a
				.filter(f -> f
					.term(te -> te
						.field("user.id")
						.value(FieldValue.of("kimchy"))
					)
				)
				.routing("shard-1")
			)))
		.settings(s -> s
			.numberOfShards("1")
		)
	)
);
""","""client.indices().putMapping(p -> p
	.index("my-index-000001")
	.properties("user", pr -> pr
		.object(o -> o
			.properties("name", pro -> pro
				.keyword(k -> k)
			)
		)
	)
);
""","""client.indices().putSettings(p -> p
	.index("my-index-000001")
	.settings(s -> s
		.analysis(a -> a
			.analyzer("content", an -> an
				.custom(c -> c
					.tokenizer("whitespace")
				)
			)
		)
	)
);
""","""client.indices().putSettings(p -> p
	.index("my-index-000001")
	.settings(s -> s
		.index(i -> i
			.numberOfReplicas("2")
		)
	)
);
""","""client.indices().putTemplate(p -> p
	.aliases(Map.of("alias1", Alias.of(a -> a),"{index}-alias", Alias.of(a -> a),"alias2", Alias.of(a -> a
			.filter(f -> f
				.term(t -> t
					.field("user.id")
					.value(FieldValue.of("kimchy"))
				)
			)
			.routing("shard-1")
		)))
	.indexPatterns("te*")
	.name("template_1")
	.settings(s -> s
		.numberOfShards("1")
	)
);
""","""client.indices().putTemplate(p -> p
	.indexPatterns(List.of("te*","bar*"))
	.mappings(m -> m
		.properties(Map.of("created_at", Property.of(pr -> pr
				.date(d -> d
					.format("EEE MMM dd HH:mm:ss Z yyyy")
				)
			),"host_name", Property.of(pro -> pro
				.keyword(k -> k)
			)))
		.source(s -> s
			.enabled(false)
		)
	)
	.name("template_1")
	.settings(s -> s
		.numberOfShards("1")
	)
);
""","""client.indices().recovery(r -> r);
""","""client.indices().refresh(r -> r);
""","""client.indices().reloadSearchAnalyzers(r -> r
	.index("my-index-000001")
);
""","""client.indices().removeBlock(r -> r
	.block(IndicesBlockOptions.Write)
	.index("my-index-000001")
);
""","""client.indices().resolveCluster(r -> r
	.ignoreUnavailable(false)
	.name(List.of("not-present","clust*:my-index*","oldcluster:*"))
	.timeout(t -> t
		.offset(5)
	)
);
""","""client.indices().resolveIndex(r -> r
	.expandWildcards("all")
	.name(List.of("f*","remoteCluster1:bar*"))
);
""","""client.indices().rollover(r -> r
	.alias("my-data-stream")
	.conditions(c -> c
		.maxAge(m -> m
			.time("7d")
		)
		.maxDocs(1000L)
		.maxPrimaryShardSize("50gb")
		.maxPrimaryShardDocs(2000L)
	)
);
""","""client.indices().rollover(r -> r
	.alias("my-data-stream")
);
""","""client.indices().segments(s -> s
	.index("my-index-000001")
);
""","""client.indices().shardStores(s -> s
	.status("green")
);
""","""client.indices().shrink(s -> s
	.index("my_source_index")
	.settings(Map.of("index.blocks.write", JsonData.fromJson("null"),"index.routing.allocation.require._name", JsonData.fromJson("null")))
	.target("my_target_index")
);
""","""client.indices().simulateIndexTemplate(s -> s
	.name("my-index-000001")
);
""","""client.indices().simulateTemplate(s -> s
	.composedOf("ct2")
	.indexPatterns("my-index-*")
	.priority(10L)
	.template(t -> t
		.settings(se -> se
			.otherSettings("index.number_of_replicas", JsonData.fromJson("1"))
		)
	)
);
""","""client.indices().split(s -> s
	.index("my-index-000001")
	.settings("index.number_of_shards", JsonData.fromJson("2"))
	.target("split-my-index-000001")
);
""","""client.indices().stats(s -> s
	.fields("my_join_field")
	.metric("fielddata")
);
""","""client.indices().updateAliases(u -> u
	.actions(a -> a
		.add(ad -> ad
			.alias("logs")
			.index("logs-nginx.access-prod")
		)
	)
);
""","""client.indices().validateQuery(v -> v
	.index("my-index-000001")
	.q("user.id:kimchy")
);
""","""client.inference().chatCompletionUnified(c -> c
	.inferenceId("openai-completion")
	.chatCompletionRequest(ch -> ch
		.messages(List.of(Message.of(m -> m
				.content(co -> co
					.string("Let's find out what the weather is")
				)
				.role("assistant")
				.toolCalls(t -> t
					.id("call_KcAjWtAww20AihPHphUh46Gd")
					.function(f -> f
						.arguments("{"location":"Boston, MA"}")
						.name("get_current_weather")
					)
					.type("function")
				)
			),Message.of(me -> me
				.content(co -> co
					.string("The weather is cold")
				)
				.role("tool")
				.toolCallId("call_KcAjWtAww20AihPHphUh46Gd")
			)))
	)
);
""","""client.inference().chatCompletionUnified(c -> c
	.inferenceId("openai-completion")
	.chatCompletionRequest(ch -> ch
		.messages(m -> m
			.content(co -> co
				.object(o -> o
					.text("What's the price of a scarf?")
					.type("text")
				)
			)
			.role("user")
		)
		.toolChoice(t -> t
			.object(o -> o
				.type("function")
				.function(f -> f
					.name("get_current_price")
				)
			)
		)
		.tools(to -> to
			.type("function")
			.function(f -> f
				.description("Get the current price of a item")
				.name("get_current_price")
				.parameters(JsonData.fromJson("{\"type\":\"object\",\"properties\":{\"item\":{\"id\":\"123\"}}}"))
			)
		)
	)
);
""","""client.inference().chatCompletionUnified(c -> c
	.inferenceId("openai-completion")
	.chatCompletionRequest(ch -> ch
		.messages(m -> m
			.content(co -> co
				.string("What is Elastic?")
			)
			.role("user")
		)
		.model("gpt-4o")
	)
);
""","""client.inference().completion(c -> c
	.inferenceId("openai_completions")
	.input("What is Elastic?")
);
""","""client.inference().delete(d -> d
	.inferenceId("my-elser-model")
	.taskType(TaskType.SparseEmbedding)
);
""","""client.inference().get(g -> g
	.inferenceId("my-elser-model")
	.taskType(TaskType.SparseEmbedding)
);
""","""client.inference().put(p -> p
	.inferenceId("ai21-chat-completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("ai21")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"ai21-api-key\",\"model_id\":\"jamba-mini\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("ai21-completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("ai21")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"ai21-api-key\",\"model_id\":\"jamba-large\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("alibabacloud_ai_search_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("alibabacloud-ai-search")
		.serviceSettings(JsonData.fromJson("{\"host\":\"default-j01.platform-cn-shanghai.opensearch.aliyuncs.com\",\"api_key\":\"AlibabaCloud-API-Key\",\"service_id\":\"ops-qwen-turbo\",\"workspace\":\"default\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("alibabacloud_ai_search_embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("alibabacloud-ai-search")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"AlibabaCloud-API-Key\",\"service_id\":\"ops-text-embedding-001\",\"host\":\"default-j01.platform-cn-shanghai.opensearch.aliyuncs.com\",\"workspace\":\"default\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("alibabacloud_ai_search_rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("alibabacloud-ai-search")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"AlibabaCloud-API-Key\",\"service_id\":\"ops-bge-reranker-larger\",\"host\":\"default-j01.platform-cn-shanghai.opensearch.aliyuncs.com\",\"workspace\":\"default\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("alibabacloud_ai_search_sparse")
	.taskType(TaskType.SparseEmbedding)
	.inferenceConfig(i -> i
		.service("alibabacloud-ai-search")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"AlibabaCloud-API-Key\",\"service_id\":\"ops-text-sparse-embedding-001\",\"host\":\"default-j01.platform-cn-shanghai.opensearch.aliyuncs.com\",\"workspace\":\"default\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("amazon_bedrock_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("amazonbedrock")
		.serviceSettings(JsonData.fromJson("{\"access_key\":\"AWS-access-key\",\"secret_key\":\"AWS-secret-key\",\"region\":\"us-east-1\",\"provider\":\"amazontitan\",\"model\":\"amazon.titan-text-premier-v1:0\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("amazon_bedrock_embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("amazonbedrock")
		.serviceSettings(JsonData.fromJson("{\"access_key\":\"AWS-access-key\",\"secret_key\":\"AWS-secret-key\",\"region\":\"us-east-1\",\"provider\":\"amazontitan\",\"model\":\"amazon.titan-embed-text-v2:0\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("amazon_sagemaker_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("amazon_sagemaker")
		.serviceSettings(JsonData.fromJson("{\"access_key\":\"AWS-access-key\",\"secret_key\":\"AWS-secret-key\",\"region\":\"us-east-1\",\"api\":\"elastic\",\"endpoint_name\":\"my-endpoint\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("amazon_sagemaker_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("amazon_sagemaker")
		.serviceSettings(JsonData.fromJson("{\"access_key\":\"AWS-access-key\",\"secret_key\":\"AWS-secret-key\",\"region\":\"us-east-1\",\"api\":\"elastic\",\"endpoint_name\":\"my-endpoint\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("amazon_sagemaker_embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("amazon_sagemaker")
		.serviceSettings(JsonData.fromJson("{\"access_key\":\"AWS-access-key\",\"secret_key\":\"AWS-secret-key\",\"region\":\"us-east-1\",\"api\":\"elastic\",\"endpoint_name\":\"my-endpoint\",\"dimensions\":384,\"element_type\":\"float\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("amazon_sagemaker_rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("amazon_sagemaker")
		.serviceSettings(JsonData.fromJson("{\"access_key\":\"AWS-access-key\",\"secret_key\":\"AWS-secret-key\",\"region\":\"us-east-1\",\"api\":\"elastic\",\"endpoint_name\":\"my-endpoint\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("amazon_sagemaker_sparse_embedding")
	.taskType(TaskType.SparseEmbedding)
	.inferenceConfig(i -> i
		.service("amazon_sagemaker")
		.serviceSettings(JsonData.fromJson("{\"access_key\":\"AWS-access-key\",\"secret_key\":\"AWS-secret-key\",\"region\":\"us-east-1\",\"api\":\"elastic\",\"endpoint_name\":\"my-endpoint\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("anthropic_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("anthropic")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Anthropic-Api-Key\",\"model_id\":\"Model-ID\"}"))
		.taskSettings(JsonData.fromJson("{\"max_tokens\":1024}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("azure_ai_studio_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("azureaistudio")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Azure-AI-Studio-API-key\",\"target\":\"Target-URI\",\"provider\":\"databricks\",\"endpoint_type\":\"realtime\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("azure_ai_studio_embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("azureaistudio")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Azure-AI-Studio-API-key\",\"target\":\"Target-Uri\",\"provider\":\"openai\",\"endpoint_type\":\"token\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("azure_ai_studio_rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("azureaistudio")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Azure-AI-Studio-API-key\",\"target\":\"Target-URI\",\"provider\":\"cohere\",\"endpoint_type\":\"token\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("azure_openai_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("azureopenai")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Api-Key\",\"resource_name\":\"Resource-name\",\"deployment_id\":\"Deployment-id\",\"api_version\":\"2024-02-01\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("azure_openai_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("azureopenai")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Api-Key\",\"resource_name\":\"Resource-name\",\"deployment_id\":\"Deployment-id\",\"api_version\":\"2024-02-01\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("azure_openai_embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("azureopenai")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Api-Key\",\"resource_name\":\"Resource-name\",\"deployment_id\":\"Deployment-id\",\"api_version\":\"2024-02-01\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("cohere-completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("cohere")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Cohere-API-key\",\"model_id\":\"command-a-03-2025\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("cohere-embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("cohere")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Cohere-Api-key\",\"model_id\":\"embed-english-light-v3.0\",\"embedding_type\":\"byte\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("cohere-rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("cohere")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Cohere-API-key\",\"model_id\":\"rerank-english-v3.0\"}"))
		.taskSettings(JsonData.fromJson("{\"top_n\":10,\"return_documents\":true}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("contextualai-rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("contextualai")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"ContextualAI-Api-key\",\"model_id\":\"ctxl-rerank-v2-instruct-multilingual-mini\"}"))
		.taskSettings(JsonData.fromJson("{\"instruction\":\"Rerank the following documents based on their relevance to the query.\",\"top_k\":3}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("custom-embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("custom")
		.serviceSettings(JsonData.fromJson("{\"secret_parameters\":{\"api_key\":\"<api key>\"},\"url\":\"https://api.openai.com/v1/embeddings\",\"headers\":{\"Authorization\":\"Bearer ${'\$'}{api_key}\",\"Content-Type\":\"application/json;charset=utf-8\"},\"request\":\"{\\"input\\": ${'\$'}{input}, \\"model\\": \\"text-embedding-3-small\\"}\",\"response\":{\"json_parser\":{\"text_embeddings\":\"${'\$'}.data[*].embedding[*]\"}}}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("custom-rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("custom")
		.serviceSettings(JsonData.fromJson("{\"secret_parameters\":{\"api_key\":\"<api key>\"},\"url\":\"https://api.cohere.com/v2/rerank\",\"headers\":{\"Authorization\":\"bearer ${'\$'}{api_key}\",\"Content-Type\":\"application/json\"},\"request\":\"{\\"documents\\": ${'\$'}{input}, \\"query\\": ${'\$'}{query}, \\"model\\": \\"rerank-v3.5\\"}\",\"response\":{\"json_parser\":{\"reranked_index\":\"${'\$'}.results[*].index\",\"relevance_score\":\"${'\$'}.results[*].relevance_score\"}}}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("custom-rerank-jina")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("custom")
		.serviceSettings(JsonData.fromJson("{\"secret_parameters\":{\"api_key\":\"<api key>\"},\"url\":\"https://api.jina.ai/v1/rerank\",\"headers\":{\"Content-Type\":\"application/json\",\"Authorization\":\"Bearer ${'\$'}{api_key}\"},\"request\":\"{\\"model\\": \\"jina-reranker-v2-base-multilingual\\",\\"query\\": ${'\$'}{query},\\"documents\\":${'\$'}{input}}\",\"response\":{\"json_parser\":{\"relevance_score\":\"${'\$'}.results[*].relevance_score\",\"reranked_index\":\"${'\$'}.results[*].index\"}}}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("custom-text-embedding")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("custom")
		.serviceSettings(JsonData.fromJson("{\"secret_parameters\":{\"api_key\":\"<api key>\"},\"url\":\"https://api.cohere.com/v2/embed\",\"headers\":{\"Authorization\":\"bearer ${'\$'}{api_key}\",\"Content-Type\":\"application/json\"},\"request\":\"{\\"texts\\": ${'\$'}{input}, \\"model\\": \\"embed-v4.0\\", \\"input_type\\": ${'\$'}{input_type}}\",\"response\":{\"json_parser\":{\"text_embeddings\":\"${'\$'}.embeddings.float[*]\"}},\"input_type\":{\"translation\":{\"ingest\":\"search_document\",\"search\":\"search_query\"},\"default\":\"search_document\"}}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("custom-text-embedding-hf")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("custom")
		.serviceSettings(JsonData.fromJson("{\"secret_parameters\":{\"api_key\":\"<api key>\"},\"url\":\"<dedicated inference endpoint on HF>/v1/embeddings\",\"headers\":{\"Authorization\":\"Bearer ${'\$'}{api_key}\",\"Content-Type\":\"application/json\"},\"request\":\"{\\"input\\": ${'\$'}{input}}\",\"response\":{\"json_parser\":{\"text_embeddings\":\"${'\$'}.data[*].embedding[*]\"}}}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_ai_studio_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("googleaistudio")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"api-key\",\"model_id\":\"model-id\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_ai21_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"ai21\",\"service_account_json\":\"service-account-json\",\"streaming_url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/publishers/ai21/models/%MODEL_ID%:streamRawPredict\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_ai21_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"ai21\",\"service_account_json\":\"service-account-json\",\"url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/publishers/ai21/models/%MODEL_ID%:rawPredict\",\"streaming_url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/publishers/ai21/models/%MODEL_ID%:streamRawPredict\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_anthropic_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"anthropic\",\"service_account_json\":\"service-account-json\",\"streaming_url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/publishers/anthropic/models/%MODEL_ID%:streamRawPredict\"}"))
		.taskSettings(JsonData.fromJson("{\"max_tokens\":128}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_anthropic_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"anthropic\",\"service_account_json\":\"service-account-json\",\"url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/publishers/anthropic/models/%MODEL_ID%:rawPredict\",\"streaming_url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/publishers/anthropic/models/%MODEL_ID%:streamRawPredict\"}"))
		.taskSettings(JsonData.fromJson("{\"max_tokens\":128}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_hugging_face_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"hugging_face\",\"service_account_json\":\"service-account-json\",\"streaming_url\":\"https://%ENDPOINT_ID%.%LOCATION_ID%-%PROJECT_ID%.prediction.vertexai.goog/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_hugging_face_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"hugging_face\",\"service_account_json\":\"service-account-json\",\"streaming_url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_hugging_face_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"hugging_face\",\"service_account_json\":\"service-account-json\",\"url\":\"https://%ENDPOINT_ID%.%LOCATION_ID%-%PROJECT_ID%.prediction.vertexai.goog/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_hugging_face_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"hugging_face\",\"service_account_json\":\"service-account-json\",\"url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_meta_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"meta\",\"model_id\":\"meta/llama-3.3-70b-instruct-maas\",\"service_account_json\":\"service-account-json\",\"streaming_url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/openapi/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_meta_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"meta\",\"service_account_json\":\"service-account-json\",\"streaming_url\":\"https://%ENDPOINT_ID%.%LOCATION_ID%-fasttryout.prediction.vertexai.goog/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_meta_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"meta\",\"service_account_json\":\"service-account-json\",\"streaming_url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_meta_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"meta\",\"model_id\":\"meta/llama-3.3-70b-instruct-maas\",\"service_account_json\":\"service-account-json\",\"url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/openapi/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_meta_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"meta\",\"service_account_json\":\"service-account-json\",\"url\":\"https://%ENDPOINT_ID%.%LOCATION_ID%-fasttryout.prediction.vertexai.goog/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_meta_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"meta\",\"service_account_json\":\"service-account-json\",\"url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_mistral_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"mistral\",\"model_id\":\"mistral-small-2503\",\"service_account_json\":\"service-account-json\",\"streaming_url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/publishers/mistralai/models/%MODEL_ID%:streamRawPredict\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_mistral_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"mistral\",\"service_account_json\":\"service-account-json\",\"streaming_url\":\"https://%ENDPOINT_ID%.%LOCATION_ID%-%PROJECT_ID%.prediction.vertexai.goog/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_mistral_chat_completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"mistral\",\"service_account_json\":\"service-account-json\",\"streaming_url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_mistral_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"mistral\",\"model_id\":\"mistral-small-2503\",\"service_account_json\":\"service-account-json\",\"url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/publishers/mistralai/models/%MODEL_ID%:rawPredict\",\"streaming_url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/publishers/mistralai/models/%MODEL_ID%:streamRawPredict\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_mistral_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"mistral\",\"service_account_json\":\"service-account-json\",\"url\":\"https://%ENDPOINT_ID%.%LOCATION_ID%-%PROJECT_ID%.prediction.vertexai.goog/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_model_garden_mistral_completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"provider\":\"mistral\",\"service_account_json\":\"service-account-json\",\"url\":\"https://%LOCATION_ID%-aiplatform.googleapis.com/v1/projects/%PROJECT_ID%/locations/%LOCATION_ID%/endpoints/%ENDPOINT_ID%/chat/completions\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_vertex_ai_embeddingss")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"service_account_json\":\"service-account-json\",\"model_id\":\"model-id\",\"location\":\"location\",\"project_id\":\"project-id\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("google_vertex_ai_rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("googlevertexai")
		.serviceSettings(JsonData.fromJson("{\"service_account_json\":\"service-account-json\",\"project_id\":\"project-id\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("groq-chat-completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("groq")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"groq-api-key\",\"model_id\":\"llama-3.3-70b-versatile\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("hugging-face-embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("hugging_face")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"hugging-face-access-token\",\"url\":\"url-endpoint\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("hugging-face-rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("hugging_face")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"hugging-face-access-token\",\"url\":\"url-endpoint\"}"))
		.taskSettings(JsonData.fromJson("{\"return_documents\":true,\"top_n\":3}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("jinaai-embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("jinaai")
		.serviceSettings(JsonData.fromJson("{\"model_id\":\"jina-embeddings-v3\",\"api_key\":\"JinaAi-Api-key\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("jinaai-rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("jinaai")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"JinaAI-Api-key\",\"model_id\":\"jina-reranker-v2-base-multilingual\"}"))
		.taskSettings(JsonData.fromJson("{\"top_n\":10,\"return_documents\":true}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("llama-completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("llama")
		.serviceSettings(JsonData.fromJson("{\"url\":\"http://localhost:8321/v1/openai/v1/chat/completions\",\"model_id\":\"llama3.2:3b\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("llama-text-embedding")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("llama")
		.serviceSettings(JsonData.fromJson("{\"url\":\"http://localhost:8321/v1/inference/embeddings\",\"dimensions\":384,\"model_id\":\"all-MiniLM-L6-v2\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("mistral-embeddings-test")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("mistral")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Mistral-API-Key\",\"model\":\"mistral-embed\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("my-e5-model")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("elasticsearch")
		.serviceSettings(JsonData.fromJson("{\"adaptive_allocations\":{\"enabled\":true,\"min_number_of_allocations\":3,\"max_number_of_allocations\":10},\"num_threads\":1,\"model_id\":\".multilingual-e5-small\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("my-e5-model")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("elasticsearch")
		.serviceSettings(JsonData.fromJson("{\"num_allocations\":1,\"num_threads\":1,\"model_id\":\".multilingual-e5-small\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("my-elastic-rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("elasticsearch")
		.serviceSettings(JsonData.fromJson("{\"model_id\":\".rerank-v1\",\"num_threads\":1,\"adaptive_allocations\":{\"enabled\":true,\"min_number_of_allocations\":1,\"max_number_of_allocations\":4}}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("my-elser-model")
	.taskType(TaskType.SparseEmbedding)
	.inferenceConfig(i -> i
		.service("elasticsearch")
		.serviceSettings(JsonData.fromJson("{\"adaptive_allocations\":{\"enabled\":true,\"min_number_of_allocations\":1,\"max_number_of_allocations\":4},\"num_threads\":1,\"model_id\":\".elser_model_2\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("my-elser-model")
	.taskType(TaskType.SparseEmbedding)
	.inferenceConfig(i -> i
		.service("elser")
		.serviceSettings(JsonData.fromJson("{\"adaptive_allocations\":{\"enabled\":true,\"min_number_of_allocations\":3,\"max_number_of_allocations\":10},\"num_threads\":1}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("my-elser-model")
	.taskType(TaskType.SparseEmbedding)
	.inferenceConfig(i -> i
		.service("elser")
		.serviceSettings(JsonData.fromJson("{\"num_allocations\":1,\"num_threads\":1}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("my-msmarco-minilm-model")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("elasticsearch")
		.serviceSettings(JsonData.fromJson("{\"num_allocations\":1,\"num_threads\":1,\"model_id\":\"msmarco-MiniLM-L12-cos-v5\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("my-rerank-model")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("cohere")
		.serviceSettings(JsonData.fromJson("{\"model_id\":\"rerank-english-v3.0\",\"api_key\":\"{{COHERE_API_KEY}}\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("nvidia-chat-completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("nvidia")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"nvidia-chat-completion-token\",\"model_id\":\"microsoft/phi-3-mini-128k-instruct\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("nvidia-chat-completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("nvidia")
		.serviceSettings(JsonData.fromJson("{\"url\":\"nvidia-chat-completion-url\",\"api_key\":\"nvidia-chat-completion-token\",\"model_id\":\"microsoft/phi-3-mini-128k-instruct\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("nvidia-completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("nvidia")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"nvidia-completion-token\",\"model_id\":\"microsoft/phi-3-mini-128k-instruct\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("nvidia-completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("nvidia")
		.serviceSettings(JsonData.fromJson("{\"url\":\"nvidia-completion-url\",\"api_key\":\"nvidia-completion-token\",\"model_id\":\"microsoft/phi-3-mini-128k-instruct\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("nvidia-rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("nvidia")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"nvidia-rerank-token\",\"model_id\":\"nv-rerank-qa-mistral-4b:1\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("nvidia-rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("nvidia")
		.serviceSettings(JsonData.fromJson("{\"url\":\"nvidia-rerank-url\",\"api_key\":\"nvidia-rerank-token\",\"model_id\":\"nv-rerank-qa-mistral-4b:1\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("nvidia-text-embedding")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("nvidia")
		.serviceSettings(JsonData.fromJson("{\"model_id\":\"nvidia/llama-3.2-nv-embedqa-1b-v2\",\"api_key\":\"nvidia-text-embeddings-token\"}"))
		.taskSettings(JsonData.fromJson("{\"input_type\":\"ingest\",\"truncate\":\"start\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("nvidia-text-embedding")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("nvidia")
		.serviceSettings(JsonData.fromJson("{\"url\":\"nvidia-embeddings-url\",\"api_key\":\"nvidia-embeddings-token\",\"model_id\":\"nvidia/llama-3.2-nv-embedqa-1b-v2\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("openai-completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("openai")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"OpenAI-API-Key\",\"model_id\":\"gpt-3.5-turbo\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("openai-embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("openai")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"OpenAI-API-Key\",\"model_id\":\"text-embedding-3-small\",\"dimensions\":128}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("openai-embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("voyageai")
		.serviceSettings(JsonData.fromJson("{\"model_id\":\"voyage-3-large\",\"dimensions\":512}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("openshift-ai-chat-completion")
	.taskType(TaskType.ChatCompletion)
	.inferenceConfig(i -> i
		.service("openshift_ai")
		.serviceSettings(JsonData.fromJson("{\"url\":\"openshift-ai-chat-completion-url\",\"api_key\":\"openshift-ai-chat-completion-token\",\"model_id\":\"llama-31-8b-instruct\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("openshift-ai-completion")
	.taskType(TaskType.Completion)
	.inferenceConfig(i -> i
		.service("openshift_ai")
		.serviceSettings(JsonData.fromJson("{\"url\":\"openshift-ai-completion-url\",\"api_key\":\"openshift-ai-completion-token\",\"model_id\":\"llama-31-8b-instruct\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("openshift-ai-rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("openshift_ai")
		.serviceSettings(JsonData.fromJson("{\"url\":\"openshift-ai-rerank-url\",\"api_key\":\"openshift-ai-rerank-token\",\"model_id\":\"bge-reranker-v2-m3\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("openshift-ai-rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("openshift_ai")
		.serviceSettings(JsonData.fromJson("{\"url\":\"openshift-ai-rerank-url\",\"api_key\":\"openshift-ai-rerank-token\"}"))
		.taskSettings(JsonData.fromJson("{\"return_documents\":true,\"top_n\":2}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("openshift-ai-text-embedding")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("openshift_ai")
		.serviceSettings(JsonData.fromJson("{\"url\":\"openshift-ai-embeddings-url\",\"api_key\":\"openshift-ai-embeddings-token\",\"model_id\":\"gritlm-7b\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("use_existing_deployment")
	.taskType(TaskType.SparseEmbedding)
	.inferenceConfig(i -> i
		.service("elasticsearch")
		.serviceSettings(JsonData.fromJson("{\"deployment_id\":\".elser_model_2\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("voyageai-rerank")
	.taskType(TaskType.Rerank)
	.inferenceConfig(i -> i
		.service("voyageai")
		.serviceSettings(JsonData.fromJson("{\"model_id\":\"rerank-2\"}"))
	)
);
""","""client.inference().put(p -> p
	.inferenceId("watsonx-embeddings")
	.taskType(TaskType.TextEmbedding)
	.inferenceConfig(i -> i
		.service("watsonxai")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"Watsonx-API-Key\",\"url\":\"Wastonx-URL\",\"model_id\":\"ibm/slate-30m-english-rtrvr\",\"project_id\":\"IBM-Cloud-ID\",\"api_version\":\"2024-03-14\"}"))
	)
);
""","""client.inference().rerank(r -> r
	.inferenceId("bge-reranker-base-mkn")
	.input(List.of("luke","like","leia","chewy","r2d2","star","wars"))
	.query("star wars main character")
);
""","""client.inference().rerank(r -> r
	.inferenceId("bge-reranker-base-mkn")
	.input(List.of("luke","like","leia","chewy","r2d2","star","wars"))
	.query("star wars main character")
);
""","""client.inference().rerank(r -> r
	.inferenceId("cohere_rerank")
	.input(List.of("luke","like","leia","chewy","r2d2","star","wars"))
	.query("star wars main character")
);
""","""client.inference().sparseEmbedding(s -> s
	.inferenceId("my-elser-model")
	.input("The sky above the port was the color of television tuned to a dead channel.")
);
""","""client.inference().streamCompletion(s -> s
	.inferenceId("openai-completion")
	.input("What is Elastic?")
);
""","""client.inference().textEmbedding(t -> t
	.inferenceId("my-cohere-endpoint")
	.input("The sky above the port was the color of television tuned to a dead channel.")
	.inputType("ingest")
);
""","""client.inference().update(u -> u
	.inferenceId("my-inference-endpoint")
	.inferenceConfig(i -> i
		.service("example-service")
		.serviceSettings(JsonData.fromJson("{\"api_key\":\"<API_KEY>\"}"))
	)
);
""","""client.info();
""","""client.ingest().deleteIpLocationDatabase(d -> d
	.id("my-database-id")
);
""","""client.ingest().deletePipeline(d -> d
	.id("my-pipeline-id")
);
""","""client.ingest().geoIpStats();
""","""client.ingest().getIpLocationDatabase(g -> g
	.id("my-database-id")
);
""","""client.ingest().getPipeline(g -> g
	.id("my-pipeline-id")
);
""","""client.ingest().processorGrok();
""","""client.ingest().putIpLocationDatabase(p -> p
	.id("my-database-1")
	.configuration(c -> c
		.maxmind(m -> m
			.accountId("1234567")
		)
		.name("GeoIP2-Domain")
	)
);
""","""client.ingest().putPipeline(p -> p
	.description("My optional pipeline description")
	.id("my-pipeline-id")
	.processors(pr -> pr
		.set(s -> s
			.field("my-keyword-field")
			.value(JsonData.fromJson("\"foo\""))
			.description("My optional processor description")
		)
	)
);
""","""client.ingest().putPipeline(p -> p
	.meta(Map.of("serialization", JsonData.fromJson("{\"class\":\"MyPipeline\",\"id\":10}"),"reason", JsonData.fromJson("\"set my-keyword-field to foo\"")))
	.description("My optional pipeline description")
	.id("my-pipeline-id")
	.processors(pr -> pr
		.set(s -> s
			.field("my-keyword-field")
			.value(JsonData.fromJson("\"foo\""))
			.description("My optional processor description")
		)
	)
);
""","""client.ingest().simulate(s -> s
	.docs(List.of(Document.of(d -> d
			.id("id")
			.index("index")
			.source(JsonData.fromJson("{\"foo\":\"bar\"}"))
		),Document.of(d -> d
			.id("id")
			.index("index")
			.source(JsonData.fromJson("{\"foo\":\"rab\"}"))
		)))
	.pipeline(p -> p
		.description("_description")
		.processors(pr -> pr
			.set(se -> se
				.field("field2")
				.value(JsonData.fromJson("\"_value\""))
			)
		)
	)
);
""","""client.license().delete(d -> d);
""","""client.license().get(g -> g);
""","""client.license().getBasicStatus();
""","""client.license().getTrialStatus();
""","""client.license().post(p -> p
	.licenses(l -> l
		.expiryDateInMillis(1914278399999L)
		.issueDateInMillis(1411948800000L)
		.issuedTo("issuedTo")
		.issuer("issuer")
		.maxNodes(1L)
		.signature("xx")
		.type(LicenseType.Basic)
		.uid("893361dc-9749-4997-93cb-802e3d7fa4xx")
	)
);
""","""client.license().postStartBasic(p -> p
	.acknowledge(true)
);
""","""client.license().postStartTrial(p -> p
	.acknowledge(true)
);
""","""client.logstash().deletePipeline(d -> d
	.id("my_pipeline")
);
""","""client.logstash().getPipeline(g -> g
	.id("my_pipeline")
);
""","""client.logstash().putPipeline(p -> p
	.id("my_pipeline")
	.pipeline(pi -> pi
		.description("Sample pipeline for illustration purposes")
		.lastModified(DateTime.of("2021-01-02T02:50:51.250Z"))
		.pipeline("input {}\n filter { grok {} }\n output {}")
		.pipelineMetadata(pip -> pip
			.type("logstash_pipeline")
			.version("1")
		)
		.pipelineSettings(pip -> pip
			.pipelineWorkers(1)
			.pipelineBatchSize(125)
			.pipelineBatchDelay(50)
			.queueType("memory")
			.queueMaxBytes("1gb")
			.queueCheckpointWrites(1024)
		)
		.username("elastic")
	)
);
""","""client.mget(m -> m
	.docs(List.of(MultiGetOperation.of(mu -> mu
			.id("1")
			.index("test")
			.routing("key2")
		),MultiGetOperation.of(mu -> mu
			.id("2")
			.index("test")
		)))
	.routing("key1")
);
""","""client.mget(m -> m
	.docs(List.of(MultiGetOperation.of(mu -> mu
			.id("1")
			.index("test")
			.storedFields(List.of("field1","field2"))
		),MultiGetOperation.of(mu -> mu
			.id("2")
			.index("test")
			.storedFields(List.of("field3","field4"))
		)))
);
""","""client.mget(m -> m
	.docs(List.of(MultiGetOperation.of(mu -> mu
			.id("1")
		),MultiGetOperation.of(mu -> mu
			.id("2")
		)))
	.index("my-index-000001")
);
""","""client.migration().deprecations(d -> d);
""","""client.migration().getFeatureUpgradeStatus();
""","""client.migration().postFeatureUpgrade();
""","""client.ml().clearTrainedModelDeploymentCache(c -> c
	.modelId("elastic__distilbert-base-uncased-finetuned-conll03-english")
);
""","""client.ml().closeJob(c -> c
	.jobId("low_request_rate")
);
""","""client.ml().deleteCalendar(d -> d
	.calendarId("planned-outages")
);
""","""client.ml().deleteCalendarEvent(d -> d
	.calendarId("planned-outages")
	.eventId("LS8LJGEBMTCMA-qz49st")
);
""","""client.ml().deleteCalendarJob(d -> d
	.calendarId("planned-outages")
	.jobId("total-requests")
);
""","""client.ml().deleteDataFrameAnalytics(d -> d
	.id("loganalytics")
);
""","""client.ml().deleteDatafeed(d -> d
	.datafeedId("datafeed-total-requests")
);
""","""client.ml().deleteExpiredData(d -> d
	.timeout(t -> t
		.offset(1)
	)
);
""","""client.ml().deleteFilter(d -> d
	.filterId("safe_domains")
);
""","""client.ml().deleteForecast(d -> d
	.forecastId("_all")
	.jobId("total-requests")
);
""","""client.ml().deleteJob(d -> d
	.jobId("total-requests")
);
""","""client.ml().deleteModelSnapshot(d -> d
	.jobId("farequote")
	.snapshotId("1491948163")
);
""","""client.ml().deleteTrainedModel(d -> d
	.modelId("regression-job-one-1574775307356")
);
""","""client.ml().deleteTrainedModelAlias(d -> d
	.modelAlias("flight_delay_model")
	.modelId("flight-delay-prediction-1574775339910")
);
""","""client.ml().estimateModelMemory(e -> e
	.analysisConfig(a -> a
		.bucketSpan(b -> b
			.time("5m")
		)
		.detectors(d -> d
			.byFieldName("status")
			.fieldName("bytes")
			.function("sum")
			.partitionFieldName("app")
		)
		.influencers(List.of("source_ip","dest_ip"))
	)
	.maxBucketCardinality(Map.of("dest_ip", 30L,"source_ip", 300L))
	.overallCardinality(Map.of("app", 50L,"status", 10L))
);
""","""client.ml().evaluateDataFrame(e -> e
	.evaluation(ev -> ev
		.classification(c -> c
			.actualField("animal_class")
			.metrics(m -> m
				.aucRoc(a -> a
					.className("dog")
				)
			)
		)
	)
	.index("animal_classification")
);
""","""client.ml().evaluateDataFrame(e -> e
	.evaluation(ev -> ev
		.classification(c -> c
			.actualField("animal_class")
			.predictedField("ml.animal_class_prediction")
			.metrics(m -> m)
		)
	)
	.index("animal_classification")
);
""","""client.ml().evaluateDataFrame(e -> e
	.evaluation(ev -> ev
		.outlierDetection(o -> o
			.actualField("is_outlier")
			.predictedProbabilityField("ml.outlier_score")
		)
	)
	.index("my_analytics_dest_index")
);
""","""client.ml().evaluateDataFrame(e -> e
	.evaluation(ev -> ev
		.regression(r -> r
			.actualField("price")
			.predictedField("ml.price_prediction")
			.metrics(m -> m
				.msle(ms -> ms
					.offset(10.0D)
				)
				.huber(h -> h
					.delta(1.5D)
				)
			)
		)
	)
	.index("house_price_predictions")
	.query(q -> q
		.bool(b -> b
			.filter(f -> f
				.term(t -> t
					.field("ml.is_training")
					.value(FieldValue.of(false))
				)
			)
		)
	)
);
""","""client.ml().evaluateDataFrame(e -> e
	.evaluation(ev -> ev
		.regression(r -> r
			.actualField("price")
			.predictedField("ml.price_prediction")
			.metrics(m -> m
				.msle(ms -> ms)
				.huber(h -> h)
			)
		)
	)
	.index("house_price_predictions")
	.query(q -> q
		.term(t -> t
			.field("ml.is_training")
			.value(FieldValue.of(true))
		)
	)
);
""","""client.ml().explainDataFrameAnalytics(e -> e
	.analysis(a -> a
		.regression(r -> r
			.dependentVariable("price")
		)
	)
	.source(s -> s
		.index("houses_sold_last_10_yrs")
	)
);
""","""client.ml().flushJob(f -> f
	.calcInterim(true)
	.jobId("low_request_rate")
);
""","""client.ml().forecast(f -> f
	.duration(d -> d
		.time("10d")
	)
	.jobId("low_request_rate")
);
""","""client.ml().getBuckets(g -> g
	.anomalyScore(80.0D)
	.jobId("low_request_rate")
	.start(DateTime.of("1454530200001"))
);
""","""client.ml().getCalendarEvents(g -> g
	.calendarId("planned-outages")
);
""","""client.ml().getCalendars(g -> g
	.calendarId("planned-outages")
);
""","""client.ml().getCategories(g -> g
	.jobId("esxi_log")
	.page(p -> p
		.size(1)
	)
);
""","""client.ml().getDataFrameAnalytics(g -> g
	.id("loganalytics")
);
""","""client.ml().getDataFrameAnalyticsStats(g -> g
	.id("weblog-outliers")
);
""","""client.ml().getDatafeedStats(g -> g
	.datafeedId("datafeed-high_sum_total_sales")
);
""","""client.ml().getDatafeeds(g -> g
	.datafeedId("datafeed-high_sum_total_sales")
);
""","""client.ml().getFilters(g -> g
	.filterId("safe_domains")
);
""","""client.ml().getInfluencers(g -> g
	.jobId("high_sum_total_sales")
);
""","""client.ml().getJobStats(g -> g
	.jobId("low_request_rate")
);
""","""client.ml().getJobs(g -> g
	.jobId("high_sum_total_sales")
);
""","""client.ml().getMemoryStats(g -> g);
""","""client.ml().getModelSnapshotUpgradeStats(g -> g
	.jobId("low_request_rate")
	.snapshotId("_all")
);
""","""client.ml().getModelSnapshots(g -> g
	.jobId("high_sum_total_sales")
	.start(DateTime.of("1575402236000"))
);
""","""client.ml().getOverallBuckets(g -> g
	.jobId("job-*")
	.overallScore(80.0D)
	.start(DateTime.of("1403532000000"))
);
""","""client.ml().getRecords(g -> g
	.desc(true)
	.jobId("low_request_rate")
	.sort("record_score")
	.start(DateTime.of("1454944100000"))
);
""","""client.ml().getTrainedModels(g -> g);
""","""client.ml().getTrainedModelsStats(g -> g);
""","""client.ml().inferTrainedModel(i -> i
	.docs(Map.of("text", JsonData.fromJson("\"The fool doth think he is wise, but the wise man knows himself to be a fool.\"")))
	.modelId("lang_ident_model_1")
);
""","""client.ml().info();
""","""client.ml().openJob(o -> o
	.jobId("job-01")
	.timeout(t -> t
		.time("35m")
	)
);
""","""client.ml().postCalendarEvents(p -> p
	.calendarId("planned-outages")
	.events(List.of(CalendarEvent.of(c -> c
			.description("event 1")
			.endTime(DateTime.ofEpochMilli(1513728000000L))
			.startTime(DateTime.ofEpochMilli(1513641600000L))
		),CalendarEvent.of(c -> c
			.description("event 2")
			.endTime(DateTime.ofEpochMilli(1513900800000L))
			.startTime(DateTime.ofEpochMilli(1513814400000L))
		),CalendarEvent.of(c -> c
			.description("event 3")
			.endTime(DateTime.ofEpochMilli(1514246400000L))
			.startTime(DateTime.ofEpochMilli(1514160000000L))
		)))
);
""","""client.ml().previewDataFrameAnalytics(p -> p
	.config(c -> c
		.source(s -> s
			.index("houses_sold_last_10_yrs")
		)
		.analysis(a -> a
			.regression(r -> r
				.dependentVariable("price")
			)
		)
	)
);
""","""client.ml().previewDatafeed(p -> p
	.datafeedId("datafeed-high_sum_total_sales")
);
""","""client.ml().putCalendar(p -> p
	.calendarId("planned-outages")
);
""","""client.ml().putCalendarJob(p -> p
	.calendarId("planned-outages")
	.jobId("total-requests")
);
""","""client.ml().putDataFrameAnalytics(p -> p
	.analysis(a -> a
		.regression(r -> r
			.dependentVariable("FlightDelayMin")
			.trainingPercent("90")
		)
	)
	.analyzedFields(an -> an
		.excludes("FlightNum")
	)
	.dest(d -> d
		.index("df-flight-delays")
		.resultsField("ml-results")
	)
	.id("model-flight-delays-pre")
	.modelMemoryLimit("100mb")
	.source(s -> s
		.index("kibana_sample_data_flights")
		.query(q -> q
			.range(r -> r
				.untyped(u -> u
					.field("DistanceKilometers")
					.gt(JsonData.fromJson("0"))
				)
			)
		)
		.source(so -> so
			.excludes(List.of("FlightDelay","FlightDelayType"))
		)
	)
);
""","""client.ml().putDatafeed(p -> p
	.datafeedId("datafeed-test-job")
	.indices("kibana_sample_data_logs")
	.jobId("test-job")
	.query(q -> q
		.bool(b -> b
			.must(m -> m
				.matchAll(ma -> ma)
			)
		)
	)
);
""","""client.ml().putFilter(p -> p
	.description("A list of safe domains")
	.filterId("safe_domains")
	.items(List.of("*.google.com","wikipedia.org"))
);
""","""client.ml().putJob(p -> p
	.analysisConfig(a -> a
		.bucketSpan(b -> b
			.time("15m")
		)
		.detectors(d -> d
			.detectorDescription("Sum of bytes")
			.fieldName("bytes")
			.function("sum")
		)
	)
	.analysisLimits(an -> an
		.modelMemoryLimit("11MB")
	)
	.dataDescription(d -> d
		.timeField("timestamp")
		.timeFormat("epoch_ms")
	)
	.datafeedConfig(d -> d
		.datafeedId("datafeed-test-job1")
		.indices("kibana_sample_data_logs")
		.query(q -> q
			.bool(b -> b
				.must(m -> m
					.matchAll(ma -> ma)
				)
			)
		)
		.runtimeMappings("hour_of_day", r -> r
			.script(s -> s
				.source(so -> so
					.scriptString("emit(doc['timestamp'].value.getHour());")
				)
			)
			.type(RuntimeFieldType.Long)
		)
	)
	.jobId("job-01")
	.modelPlotConfig(m -> m
		.annotationsEnabled(true)
		.enabled(true)
	)
	.resultsIndexName("test-job1")
);
""","""client.ml().putTrainedModelAlias(p -> p
	.modelAlias("flight_delay_model")
	.modelId("flight-delay-prediction-1574775339910")
);
""","""client.ml().putTrainedModelDefinitionPart(p -> p
	.definition("...")
	.modelId("elastic__distilbert-base-uncased-finetuned-conll03-english")
	.part(0)
	.totalDefinitionLength(265632637L)
	.totalParts(64)
);
""","""client.ml().putTrainedModelVocabulary(p -> p
	.modelId("elastic__distilbert-base-uncased-finetuned-conll03-english")
	.vocabulary(List.of("[PAD]","[unused0]"))
);
""","""client.ml().resetJob(r -> r
	.jobId("total-requests")
);
""","""client.ml().revertModelSnapshot(r -> r
	.deleteInterveningResults(true)
	.jobId("low_request_rate")
	.snapshotId("1637092688")
);
""","""client.ml().setUpgradeMode(s -> s
	.enabled(true)
);
""","""client.ml().startDataFrameAnalytics(s -> s
	.id("loganalytics")
);
""","""client.ml().startDatafeed(s -> s
	.datafeedId("datafeed-low_request_rate")
	.start(DateTime.of("2019-04-07T18:22:16Z"))
);
""","""client.ml().startTrainedModelDeployment(s -> s
	.modelId("elastic__distilbert-base-uncased-finetuned-conll03-english")
	.timeout(t -> t
		.offset(1)
	)
	.waitFor(DeploymentAllocationState.Started)
);
""","""client.ml().stopDataFrameAnalytics(s -> s
	.id("loganalytics")
);
""","""client.ml().stopDatafeed(s -> s
	.datafeedId("datafeed-low_request_rate")
	.timeout(t -> t
		.time("30s")
	)
);
""","""client.ml().stopTrainedModelDeployment(s -> s
	.modelId("my_model_for_search")
);
""","""client.ml().updateDataFrameAnalytics(u -> u
	.id("loganalytics")
	.modelMemoryLimit("200mb")
);
""","""client.ml().updateDatafeed(u -> u
	.datafeedId("datafeed-test-job")
	.query(q -> q
		.term(t -> t
			.field("geo.src")
			.value(FieldValue.of("US"))
		)
	)
);
""","""client.ml().updateFilter(u -> u
	.addItems("*.myorg.com")
	.description("Updated list of domains")
	.filterId("safe_domains")
	.removeItems("wikipedia.org")
);
""","""client.ml().updateJob(u -> u
	.backgroundPersistInterval(b -> b
		.time("2h")
	)
	.description("An updated job")
	.detectors(d -> d
		.detectorIndex(0)
		.description("An updated detector description")
	)
	.groups(List.of("kibana_sample_data","kibana_sample_web_logs"))
	.jobId("low_request_rate")
	.modelPlotConfig(m -> m
		.enabled(true)
	)
	.modelSnapshotRetentionDays(7L)
	.renormalizationWindowDays(30L)
	.resultsRetentionDays(60L)
);
""","""client.ml().updateModelSnapshot(u -> u
	.description("Snapshot 1")
	.jobId("it_ops_new_logs")
	.retain(true)
	.snapshotId("1491852978")
);
""","""client.ml().updateTrainedModelDeployment(u -> u
	.modelId("elastic__distilbert-base-uncased-finetuned-conll03-english")
	.numberOfAllocations(4)
);
""","""client.ml().upgradeJobSnapshot(u -> u
	.jobId("low_request_rate")
	.snapshotId("1828371")
	.timeout(t -> t
		.offset(45)
	)
	.waitForCompletion(true)
);
""","""client.mtermvectors(m -> m
	.docs(List.of(MultiTermVectorsOperation.of(mu -> mu
			.id("2")
			.fields("message")
			.termStatistics(true)
		),MultiTermVectorsOperation.of(mu -> mu
			.id("1")
		)))
	.index("my-index-000001")
);
""","""client.mtermvectors(m -> m
	.docs(List.of(MultiTermVectorsOperation.of(mu -> mu
			.index("my-index-000001")
			.doc(JsonData.fromJson("{\"message\":\"test test test\"}"))
		),MultiTermVectorsOperation.of(mu -> mu
			.index("my-index-000001")
			.doc(JsonData.fromJson("{\"message\":\"Another test ...\"}"))
		)))
);
""","""client.mtermvectors(m -> m
	.ids(List.of("1","2"))
	.index("my-index-000001")
);
""","""client.nodes().hotThreads(h -> h);
""","""client.nodes().info(i -> i
	.metric("jvm")
	.nodeId("_all")
);
""","""client.nodes().reloadSecureSettings(r -> r
	.secureSettingsPassword("keystore-password")
);
""","""client.nodes().stats(s -> s
	.metric("process")
);
""","""client.nodes().usage(u -> u);
""","""client.openPointInTime(o -> o
	.allowPartialSearchResults(true)
	.index("my-index-000001")
	.keepAlive(k -> k
		.offset(1)
	)
);
""","""client.project().tags();
""","""client.putScript(p -> p
	.id("my-stored-script")
	.script(s -> s
		.lang("painless")
		.source(so -> so
			.scriptString("Math.log(_score * 2) + params['my_modifier']")
		)
	)
);
""","""client.queryRules().deleteRule(d -> d
	.ruleId("my-rule1")
	.rulesetId("my-ruleset")
);
""","""client.queryRules().deleteRuleset(d -> d
	.rulesetId("my-ruleset")
);
""","""client.queryRules().getRule(g -> g
	.ruleId("my-rule1")
	.rulesetId("my-ruleset")
);
""","""client.queryRules().getRuleset(g -> g
	.rulesetId("my-ruleset")
);
""","""client.queryRules().listRulesets(l -> l
	.from(0)
	.size(3)
);
""","""client.queryRules().putRuleset(p -> p
	.rules(List.of(QueryRule.queryRuleOf(q -> q
			.ruleId("my-rule1")
			.type(QueryRuleType.Pinned)
			.criteria(List.of(QueryRuleCriteria.of(qu -> qu
					.type(QueryRuleCriteriaType.Contains)
					.metadata("user_query")
					.values(List.of(JsonData.fromJson("\"pugs\""),JsonData.fromJson("\"puggles\"")))
				),QueryRuleCriteria.of(qu -> qu
					.type(QueryRuleCriteriaType.Exact)
					.metadata("user_country")
					.values(JsonData.fromJson("\"us\""))
				)))
			.actions(a -> a
				.ids(List.of("id1","id2"))
			)
		),QueryRule.queryRuleOf(q -> q
			.ruleId("my-rule2")
			.type(QueryRuleType.Pinned)
			.criteria(c -> c
				.type(QueryRuleCriteriaType.Fuzzy)
				.metadata("user_query")
				.values(JsonData.fromJson("\"rescue dogs\""))
			)
			.actions(a -> a
				.docs(List.of(PinnedDoc.of(pi -> pi
						.id("id3")
						.index("index1")
					),PinnedDoc.of(pi -> pi
						.id("id4")
						.index("index2")
					)))
			)
		)))
	.rulesetId("my-ruleset")
);
""","""client.queryRules().putRuleset(p -> p
	.rules(List.of(QueryRule.queryRuleOf(q -> q
			.ruleId("my-rule1")
			.type(QueryRuleType.Pinned)
			.criteria(List.of(QueryRuleCriteria.of(qu -> qu
					.type(QueryRuleCriteriaType.Contains)
					.metadata("user_query")
					.values(List.of(JsonData.fromJson("\"pugs\""),JsonData.fromJson("\"puggles\"")))
				),QueryRuleCriteria.of(qu -> qu
					.type(QueryRuleCriteriaType.Exact)
					.metadata("user_country")
					.values(JsonData.fromJson("\"us\""))
				)))
			.actions(a -> a
				.ids(List.of("id1","id2"))
			)
		),QueryRule.queryRuleOf(q -> q
			.ruleId("my-rule2")
			.type(QueryRuleType.Pinned)
			.criteria(c -> c
				.type(QueryRuleCriteriaType.Fuzzy)
				.metadata("user_query")
				.values(JsonData.fromJson("\"rescue dogs\""))
			)
			.actions(a -> a
				.docs(List.of(PinnedDoc.of(pi -> pi
						.id("id3")
						.index("index1")
					),PinnedDoc.of(pi -> pi
						.id("id4")
						.index("index2")
					)))
			)
		)))
	.rulesetId("my-ruleset")
);
""","""client.queryRules().test(t -> t
	.matchCriteria("query_string", JsonData.fromJson("\"puggles\""))
	.rulesetId("my-ruleset")
);
""","""client.rankEval(r -> r
	.index("my-index-000001")
	.metric(m -> m
		.precision(p -> p
			.ignoreUnlabeled(false)
			.relevantRatingThreshold(1)
			.k(20)
		)
	)
	.requests(re -> re
		.id("JFK query")
		.request(req -> req
			.query(q -> q
				.matchAll(m -> m)
			)
		)
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("dest")
		.pipeline("some_ingest_pipeline")
	)
	.source(s -> s
		.index("source")
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("dest")
		.routing("=cat")
	)
	.source(s -> s
		.index("source")
		.query(q -> q
			.match(m -> m
				.field("company")
				.query(FieldValue.of("cat"))
			)
		)
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("metricbeat")
	)
	.script(s -> s
		.source(so -> so
			.scriptString("ctx._index = 'metricbeat-' + (ctx._index.substring('metricbeat-'.length(), ctx._index.length())) + '-1'")
		)
		.lang("painless")
	)
	.source(so -> so
		.index("metricbeat-*")
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("my-new-index-000001")
		.versionType(VersionType.External)
	)
	.script(s -> s
		.source(so -> so
			.scriptString("if (ctx._source.foo == 'bar') {ctx._version++; ctx._source.remove('foo')}")
		)
		.lang("painless")
	)
	.source(so -> so
		.index("my-index-000001")
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("my-new-index-000001")
	)
	.maxDocs(10L)
	.source(s -> s
		.index("my-index-000001")
		.query(q -> q
			.functionScore(f -> f
				.minScore(0.9D)
			)
		)
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("my-new-index-000001")
	)
	.maxDocs(1L)
	.source(s -> s
		.index("my-index-000001")
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("my-new-index-000001")
	)
	.refresh(true)
	.slices(s -> s
		.value(5)
	)
	.source(so -> so
		.index("my-index-000001")
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("my-new-index-000001")
	)
	.script(s -> s
		.source(so -> so
			.scriptString("ctx._source.tag = ctx._source.remove("flag")")
		)
	)
	.source(so -> so
		.index("my-index-000001")
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("my-new-index-000001")
	)
	.source(s -> s
		.index("my-index-000001")
		.query(q -> q
			.match(m -> m
				.field("test")
				.query(FieldValue.of("data"))
			)
		)
		.remote(re -> re
			.host("http://otherhost:9200")
			.username("user")
			.password("pass")
		)
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("my-new-index-000001")
	)
	.source(s -> s
		.index("my-index-000001")
		.query(q -> q
			.term(t -> t
				.field("user.id")
				.value(FieldValue.of("kimchy"))
			)
		)
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("my-new-index-000001")
	)
	.source(s -> s
		.index("my-index-000001")
		.slice(sl -> sl
			.id("0")
			.max(2)
		)
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("my-new-index-000001")
	)
	.source(s -> s
		.index("my-index-000001")
		.sourceFields(List.of("user.id","_doc"))
	)
);
""","""client.reindex(r -> r
	.dest(d -> d
		.index("my-new-index-000002")
	)
	.source(s -> s
		.index(List.of("my-index-000001","my-index-000002"))
	)
);
""","""client.reindexRethrottle(r -> r
	.requestsPerSecond(-1.0F)
	.taskId("r1A2WoRbTwKZ516z6NEs5A:36619")
);
""","""client.renderSearchTemplate(r -> r
	.id("my-search-template")
	.params(Map.of("size", JsonData.fromJson("10"),"from", JsonData.fromJson("20"),"query_string", JsonData.fromJson("\"hello world\"")))
);
""","""client.rollup().deleteJob(d -> d
	.id("sensor")
);
""","""client.rollup().getJobs(g -> g
	.id("sensor")
);
""","""client.rollup().getRollupCaps(g -> g
	.id("sensor-*")
);
""","""client.rollup().getRollupIndexCaps(g -> g
	.index("sensor_rollup")
);
""","""client.rollup().putJob(p -> p
	.cron("*/30 * * * * ?")
	.groups(g -> g
		.dateHistogram(d -> d
			.delay(de -> de
				.time("7d")
			)
			.field("timestamp")
			.fixedInterval(f -> f
				.time("1h")
			)
		)
		.terms(t -> t
			.fields("node")
		)
	)
	.id("sensor")
	.indexPattern("sensor-*")
	.metrics(List.of(FieldMetric.of(f -> f
			.field("temperature")
			.metrics(List.of(Metric.Min,Metric.Max,Metric.Sum))
		),FieldMetric.of(f -> f
			.field("voltage")
			.metrics(Metric.Avg)
		)))
	.pageSize(1000)
	.rollupIndex("sensor_rollup")
);
""","""client.rollup().rollupSearch(r -> r
	.aggregations("max_temperature", a -> a
		.max(m -> m
			.field("temperature")
		)
	)
	.index("sensor_rollup")
	.size(0)
);
""","""client.rollup().startJob(s -> s
	.id("sensor")
);
""","""client.rollup().stopJob(s -> s
	.id("sensor")
	.timeout(t -> t
		.offset(10)
	)
	.waitForCompletion(true)
);
""","""client.scriptsPainlessExecute(s -> s
	.context(PainlessContext.Filter)
	.contextSetup(c -> c
		.document(JsonData.fromJson("{\"field\":\"four\"}"))
		.index("my-index-000001")
	)
	.script(sc -> sc
		.source(so -> so
			.scriptString("doc['field'].value.length() <= params.max_length")
		)
		.params("max_length", JsonData.fromJson("4"))
	)
);
""","""client.scriptsPainlessExecute(s -> s
	.context(PainlessContext.Score)
	.contextSetup(c -> c
		.document(JsonData.fromJson("{\"rank\":4}"))
		.index("my-index-000001")
	)
	.script(sc -> sc
		.source(so -> so
			.scriptString("doc['rank'].value / params.max_rank")
		)
		.params("max_rank", JsonData.fromJson("5"))
	)
);
""","""client.scriptsPainlessExecute(s -> s
	.script(sc -> sc
		.source(so -> so
			.scriptString("params.count / params.total")
		)
		.params(Map.of("total", JsonData.fromJson("1000"),"count", JsonData.fromJson("100")))
	)
);
""","""client.scroll(s -> s
	.scrollId("DXF1ZXJ5QW5kRmV0Y2gBAAAAAAAAAD4WYm9laVYtZndUQlNsdDcwakFMNjU1QQ==")
);
""","""client.search(s -> s
	.from(40)
	.index("my-index-000001")
	.query(q -> q
		.term(t -> t
			.field("user.id")
			.value(FieldValue.of("kimchy"))
		)
	)
	.size(20)
,Void.class);
""","""client.search(s -> s
	.pit(p -> p
		.id("46ToAwMDaWR5BXV1aWQyKwZub2RlXzMAAAAAAAAAACoBYwADaWR4BXV1aWQxAgZub2RlXzEAAAAAAAAAAAEBYQADaWR5BXV1aWQyKgZub2RlXzIAAAAAAAAAAAwBYgACBXV1aWQyAAAFdXVpZDEAAQltYXRjaF9hbGw_gAAAAA==")
		.keepAlive(k -> k
			.time("1m")
		)
	)
	.query(q -> q
		.match(m -> m
			.field("title")
			.query(FieldValue.of("elasticsearch"))
		)
	)
	.size(100)
,Void.class);
""","""client.search(s -> s
	.pit(p -> p
		.id("46ToAwMDaWR5BXV1aWQyKwZub2RlXzMAAAAAAAAAACoBYwADaWR4BXV1aWQxAgZub2RlXzEAAAAAAAAAAAEBYQADaWR5BXV1aWQyKgZub2RlXzIAAAAAAAAAAAwBYgACBXV1aWQyAAAFdXVpZDEAAQltYXRjaF9hbGw_gAAAAA==")
	)
	.query(q -> q
		.match(m -> m
			.field("message")
			.query(FieldValue.of("foo"))
		)
	)
	.slice(sl -> sl
		.id("0")
		.max(2)
	)
,Void.class);
""","""client.searchApplication().delete(d -> d
	.name("my-app")
);
""","""client.searchApplication().deleteBehavioralAnalytics(d -> d
	.name("my_analytics_collection")
);
""","""client.searchApplication().get(g -> g
	.name("my-app")
);
""","""client.searchApplication().getBehavioralAnalytics(g -> g
	.name("my*")
);
""","""client.searchApplication().list(l -> l
	.from(0)
	.q("app*")
	.size(3)
);
""","""client.searchApplication().postBehavioralAnalyticsEvent(p -> p
	.collectionName("my_analytics_collection")
	.eventType(EventType.SearchClick)
	.payload(JsonData.fromJson("{\"session\":{\"id\":\"1797ca95-91c9-4e2e-b1bd-9c38e6f386a9\"},\"user\":{\"id\":\"5f26f01a-bbee-4202-9298-81261067abbd\"},\"search\":{\"query\":\"search term\",\"results\":{\"items\":[{\"document\":{\"id\":\"123\",\"index\":\"products\"}}],\"total_results\":10},\"sort\":{\"name\":\"relevance\"},\"search_application\":\"website\"},\"document\":{\"id\":\"123\",\"index\":\"products\"}}"))
);
""","""client.searchApplication().put(p -> p
	.name("my-app")
	.searchApplication(s -> s
		.indices(List.of("index1","index2"))
		.template(t -> t
			.script(sc -> sc
				.source(so -> so
					.scriptTemplate(scr -> scr
						.query(q -> q
							.queryString(qu -> qu
								.defaultField("{{default_field}}")
								.query("{{query_string}}")
							)
						)
					)
				)
				.params(Map.of("default_field", JsonData.fromJson("\"*\""),"query_string", JsonData.fromJson("\"*\"")))
			)
		)
	)
);
""","""client.searchApplication().putBehavioralAnalytics(p -> p
	.name("my_analytics_collection")
);
""","""client.searchApplication().renderQuery(r -> r
	.name("my-app")
	.params(Map.of("text_fields", JsonData.fromJson("[{\"name\":\"title\",\"boost\":5},{\"name\":\"description\",\"boost\":1}]"),"query_string", JsonData.fromJson("\"my first query\"")))
);
""","""client.searchApplication().search(s -> s
	.name("my-app")
	.params(Map.of("text_fields", JsonData.fromJson("[{\"name\":\"title\",\"boost\":5},{\"name\":\"description\",\"boost\":1}]"),"query_string", JsonData.fromJson("\"my first query\"")))
);
""","""client.searchMvt(s -> s
	.aggs(Map.of("max_price", Aggregation.of(a -> a
			.max(m -> m
				.field("price")
			)
		),"min_price", Aggregation.of(ag -> ag
			.min(m -> m
				.field("price")
			)
		),"avg_price", Aggregation.of(agg -> agg
			.avg(av -> av
				.field("price")
			)
		)))
	.field("location")
	.fields(List.of("name","price"))
	.gridAgg(GridAggregationType.Geotile)
	.gridPrecision(2)
	.index("museums")
	.query(q -> q
		.term(t -> t
			.field("included")
			.value(FieldValue.of(true))
		)
	)
	.x(4207)
	.y(2692)
	.zoom(13)
);
""","""client.searchShards(s -> s
	.index("my-index-000001")
);
""","""client.searchTemplate(s -> s
	.id("my-search-template")
	.index("my-index")
	.params(Map.of("size", JsonData.fromJson("10"),"from", JsonData.fromJson("0"),"query_string", JsonData.fromJson("\"hello world\"")))
);
""","""client.searchableSnapshots().cacheStats(c -> c);
""","""client.searchableSnapshots().clearCache(c -> c
	.index("my-index")
);
""","""client.searchableSnapshots().mount(m -> m
	.ignoreIndexSettings("index.refresh_interval")
	.index("my_docs")
	.indexSettings("index.number_of_replicas", JsonData.fromJson("0"))
	.renamedIndex("docs")
	.repository("my_repository")
	.snapshot("my_snapshot")
	.waitForCompletion(true)
);
""","""client.searchableSnapshots().stats(s -> s
	.index("my-index")
);
""","""client.security().activateUserProfile(a -> a
	.grantType(GrantType.Password)
	.password("l0ng-r4nd0m-p@ssw0rd")
	.username("jacknich")
);
""","""client.security().authenticate();
""","""client.security().bulkDeleteRole(b -> b
	.names(List.of("my_admin_role","my_user_role"))
);
""","""client.security().bulkPutRole(b -> b
	.roles(Map.of("my_admin_role", RoleDescriptor.of(r -> r
			.cluster("all")
			.indices(i -> i
				.fieldSecurity(f -> f
					.grant(List.of("title","body"))
				)
				.names(List.of("index1","index2"))
				.privileges("all")
				.query(q -> q
					.match(m -> m
						.field("title")
						.query(FieldValue.of("foo"))
					)
				)
			)
			.applications(a -> a
				.application("myapp")
				.privileges(List.of("admin","read"))
				.resources("*")
			)
			.metadata("version", JsonData.fromJson("1"))
			.runAs("other_user")
		),"my_user_role", RoleDescriptor.of(ro -> ro
			.cluster("all")
			.indices(i -> i
				.fieldSecurity(f -> f
					.grant(List.of("title","body"))
				)
				.names("index1")
				.privileges("read")
				.query(q -> q
					.match(m -> m
						.field("title")
						.query(FieldValue.of("foo"))
					)
				)
			)
			.applications(a -> a
				.application("myapp")
				.privileges(List.of("admin","read"))
				.resources("*")
			)
			.metadata("version", JsonData.fromJson("1"))
			.runAs("other_user")
		)))
);
""","""client.security().bulkPutRole(b -> b
	.roles(Map.of("my_admin_role", RoleDescriptor.of(r -> r
			.cluster("bad_cluster_privilege")
			.indices(i -> i
				.fieldSecurity(f -> f
					.grant(List.of("title","body"))
				)
				.names(List.of("index1","index2"))
				.privileges("all")
				.query(q -> q
					.match(m -> m
						.field("title")
						.query(FieldValue.of("foo"))
					)
				)
			)
			.applications(a -> a
				.application("myapp")
				.privileges(List.of("admin","read"))
				.resources("*")
			)
			.metadata("version", JsonData.fromJson("1"))
			.runAs("other_user")
		),"my_user_role", RoleDescriptor.of(ro -> ro
			.cluster("all")
			.indices(i -> i
				.fieldSecurity(f -> f
					.grant(List.of("title","body"))
				)
				.names("index1")
				.privileges("read")
				.query(q -> q
					.match(m -> m
						.field("title")
						.query(FieldValue.of("foo"))
					)
				)
			)
			.applications(a -> a
				.application("myapp")
				.privileges(List.of("admin","read"))
				.resources("*")
			)
			.metadata("version", JsonData.fromJson("1"))
			.runAs("other_user")
		)))
);
""","""client.security().bulkUpdateApiKeys(b -> b
	.expiration(e -> e
		.time("30d")
	)
	.ids(List.of("VuaCfGcBCdbkQm-e5aOx","H3_AhoIBA9hmeQJdg7ij"))
	.metadata("environment", JsonData.fromJson("{\"level\":2,\"trusted\":true,\"tags\":[\"production\"]}"))
	.roleDescriptors("role-a", r -> r
		.indices(i -> i
			.names("*")
			.privileges("write")
		)
	)
);
""","""client.security().bulkUpdateApiKeys(b -> b
	.ids(List.of("VuaCfGcBCdbkQm-e5aOx","H3_AhoIBA9hmeQJdg7ij"))
);
""","""client.security().changePassword(c -> c
	.password("new-test-password")
	.username("jacknich")
);
""","""client.security().clearApiKeyCache(c -> c
	.ids("yVGMr3QByxdh1MSaicYx")
);
""","""client.security().clearCachedPrivileges(c -> c
	.application("myapp")
);
""","""client.security().clearCachedRealms(c -> c
	.realms("default_file")
);
""","""client.security().clearCachedRoles(c -> c
	.name("my_admin_role")
);
""","""client.security().clearCachedServiceTokens(c -> c
	.name("token1")
	.namespace("elastic")
	.service("fleet-server")
);
""","""client.security().createApiKey(c -> c
	.expiration(e -> e
		.time("1d")
	)
	.metadata(Map.of("environment", JsonData.fromJson("{\"level\":1,\"trusted\":true,\"tags\":[\"dev\",\"staging\"]}"),"application", JsonData.fromJson("\"my-application\"")))
	.name("my-api-key")
	.roleDescriptors(Map.of("role-b", RoleDescriptor.of(r -> r
			.cluster("all")
			.indices(i -> i
				.names("index-b*")
				.privileges("all")
			)
		),"role-a", RoleDescriptor.of(r -> r
			.cluster("all")
			.indices(i -> i
				.names("index-a*")
				.privileges("read")
			)
		)))
);
""","""client.security().createCrossClusterApiKey(c -> c
	.access(a -> a
		.replication(r -> r
			.names("archive*")
		)
		.search(s -> s
			.names("logs*")
		)
	)
	.expiration(e -> e
		.time("1d")
	)
	.metadata(Map.of("environment", JsonData.fromJson("{\"level\":1,\"trusted\":true,\"tags\":[\"dev\",\"staging\"]}"),"description", JsonData.fromJson("\"phase one\"")))
	.name("my-cross-cluster-api-key")
);
""","""client.security().createServiceToken(c -> c
	.name("token1")
	.namespace("elastic")
	.service("fleet-server")
);
""","""client.security().delegatePki(d -> d
	.x509CertificateChain("MIIDeDCCAmCgAwIBAgIUBzj/nGGKxP2iXawsSquHmQjCJmMwDQYJKoZIhvcNAQELBQAwUzErMCkGA1UEAxMiRWxhc3RpY3NlYXJjaCBUZXN0IEludGVybWVkaWF0ZSBDQTEWMBQGA1UECxMNRWxhc3RpY3NlYXJjaDEMMAoGA1UEChMDb3JnMB4XDTIzMDcxODE5MjkwNloXDTQzMDcxMzE5MjkwNlowSjEiMCAGA1UEAxMZRWxhc3RpY3NlYXJjaCBUZXN0IENsaWVudDEWMBQGA1UECxMNRWxhc3RpY3NlYXJjaDEMMAoGA1UEChMDb3JnMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAllHL4pQkkfwAm/oLkxYYO+r950DEy1bjH+4viCHzNADLCTWO+lOZJVlNx7QEzJE3QGMdif9CCBBxQFMapA7oUFCLq84fPSQQu5AnvvbltVD9nwVtCs+9ZGDjMKsz98RhSLMFIkxdxi6HkQ3Lfa4ZSI4lvba4oo+T/GveazBDS+NgmKyq00EOXt3tWi1G9vEVItommzXWfv0agJWzVnLMldwkPqsw0W7zrpyT7FZS4iLbQADGceOW8fiauOGMkscu9zAnDR/SbWl/chYioQOdw6ndFLn1YIFPd37xL0WsdsldTpn0vH3YfzgLMffT/3P6YlwBegWzsx6FnM/93Ecb4wIDAQABo00wSzAJBgNVHRMEAjAAMB0GA1UdDgQWBBQKNRwjW+Ad/FN1Rpoqme/5+jrFWzAfBgNVHSMEGDAWgBRcya0c0x/PaI7MbmJVIylWgLqXNjANBgkqhkiG9w0BAQsFAAOCAQEACZ3PF7Uqu47lplXHP6YlzYL2jL0D28hpj5lGtdha4Muw1m/BjDb0Pu8l0NQ1z3AP6AVcvjNDkQq6Y5jeSz0bwQlealQpYfo7EMXjOidrft1GbqOMFmTBLpLA9SvwYGobSTXWTkJzonqVaTcf80HpMgM2uEhodwTcvz6v1WEfeT/HMjmdIsq4ImrOL9RNrcZG6nWfw0HR3JNOgrbfyEztEI471jHznZ336OEcyX7gQuvHE8tOv5+oD1d7s3Xg1yuFp+Ynh+FfOi3hPCuaHA+7F6fLmzMDLVUBAllugst1C3U+L/paD7tqIa4ka+KNPCbSfwazmJrt4XNiivPR4hwH5g==")
);
""","""client.security().deletePrivileges(d -> d
	.application("myapp")
	.name("read")
);
""","""client.security().deleteRole(d -> d
	.name("my_admin_role")
);
""","""client.security().deleteRoleMapping(d -> d
	.name("mapping1")
);
""","""client.security().deleteServiceToken(d -> d
	.name("token42")
	.namespace("elastic")
	.service("fleet-server")
);
""","""client.security().deleteUser(d -> d
	.username("jacknich")
);
""","""client.security().disableUser(d -> d
	.username("jacknich")
);
""","""client.security().disableUserProfile(d -> d
	.uid("u_79HkWkwmnBH5gqFKwoxggWPjEBOur1zLPXQPEl1VBW0_0")
);
""","""client.security().enableUser(e -> e
	.username("logstash_system")
);
""","""client.security().enableUserProfile(e -> e
	.uid("u_79HkWkwmnBH5gqFKwoxggWPjEBOur1zLPXQPEl1VBW0_0")
);
""","""client.security().enrollKibana();
""","""client.security().getApiKey(g -> g
	.realmName("native1")
	.username("myuser")
);
""","""client.security().getBuiltinPrivileges();
""","""client.security().getPrivileges(g -> g
	.application("myapp")
	.name("read")
);
""","""client.security().getRole(g -> g
	.name("my_admin_role")
);
""","""client.security().getRoleMapping(g -> g
	.name("mapping1")
);
""","""client.security().getServiceAccounts(g -> g
	.namespace("elastic")
	.service("fleet-server")
);
""","""client.security().getServiceCredentials(g -> g
	.namespace("elastic")
	.service("fleet-server")
);
""","""client.security().getSettings(g -> g);
""","""client.security().getToken(g -> g
	.grantType(AccessTokenGrantType.ClientCredentials)
);
""","""client.security().getToken(g -> g
	.grantType(AccessTokenGrantType.Password)
	.password("x-pack-test-password")
	.username("test_admin")
);
""","""client.security().getUser(g -> g
	.username("jacknich")
	.withProfileUid(true)
);
""","""client.security().getUserPrivileges();
""","""client.security().getUserProfile(g -> g
	.uid("u_79HkWkwmnBH5gqFKwoxggWPjEBOur1zLPXQPEl1VBW0_0")
);
""","""client.security().grantApiKey(g -> g
	.apiKey(a -> a
		.name("another-api-key")
	)
	.grantType(ApiKeyGrantType.Password)
	.password("x-pack-test-password")
	.runAs("test_user")
	.username("test_admin")
);
""","""client.security().grantApiKey(g -> g
	.apiKey(a -> a
		.name("my-api-key")
		.expiration(e -> e
			.time("1d")
		)
		.roleDescriptors(Map.of("role-b", RoleDescriptor.of(r -> r
				.cluster("all")
				.indices(i -> i
					.names("index-b*")
					.privileges("all")
				)
			),"role-a", RoleDescriptor.of(r -> r
				.cluster("all")
				.indices(i -> i
					.names("index-a*")
					.privileges("read")
				)
			)))
		.metadata(Map.of("environment", JsonData.fromJson("{\"level\":1,\"trusted\":true,\"tags\":[\"dev\",\"staging\"]}"),"application", JsonData.fromJson("\"my-application\"")))
	)
	.grantType(ApiKeyGrantType.Password)
	.password("x-pack-test-password")
	.username("test_admin")
);
""","""client.security().hasPrivileges(h -> h
	.application(a -> a
		.application("inventory_manager")
		.privileges(List.of("read","data:write/inventory"))
		.resources("product/1852563")
	)
	.cluster(List.of("monitor","manage"))
	.index(List.of(IndexPrivilegesCheck.of(i -> i
			.names(List.of("suppliers","products"))
			.privileges("read")
		),IndexPrivilegesCheck.of(i -> i
			.names("inventory")
			.privileges(List.of("read","write"))
		)))
);
""","""client.security().hasPrivilegesUserProfile(h -> h
	.privileges(p -> p
		.application(a -> a
			.application("inventory_manager")
			.privileges(List.of("read","data:write/inventory"))
			.resources("product/1852563")
		)
		.cluster(List.of("monitor","create_snapshot","manage_ml"))
		.index(List.of(IndexPrivilegesCheck.of(i -> i
				.names(List.of("suppliers","products"))
				.privileges("create_doc")
			),IndexPrivilegesCheck.of(i -> i
				.names("inventory")
				.privileges(List.of("read","write"))
			)))
	)
	.uids(List.of("u_LQPnxDxEjIH0GOUoFkZr5Y57YUwSkL9Joiq-g4OCbPc_0","u_rzRnxDgEHIH0GOUoFkZr5Y27YUwSk19Joiq=g4OCxxB_1","u_does-not-exist_0"))
);
""","""client.security().invalidateApiKey(i -> i
	.ids("VuaCfGcBCdbkQm-e5aOx")
	.owner(true)
);
""","""client.security().invalidateApiKey(i -> i
	.ids("VuaCfGcBCdbkQm-e5aOx")
);
""","""client.security().invalidateApiKey(i -> i
	.name("my-api-key")
);
""","""client.security().invalidateApiKey(i -> i
	.realmName("native1")
	.username("myuser")
);
""","""client.security().invalidateApiKey(i -> i
	.realmName("native1")
);
""","""client.security().invalidateApiKey(i -> i
	.username("myuser")
);
""","""client.security().invalidateToken(i -> i
	.realmName("saml1")
	.username("myuser")
);
""","""client.security().invalidateToken(i -> i
	.realmName("saml1")
);
""","""client.security().invalidateToken(i -> i
	.refreshToken("vLBPvmAB6KvwvJZr27cS")
);
""","""client.security().invalidateToken(i -> i
	.token("dGhpcyBpcyBub3QgYSByZWFsIHRva2VuIGJ1dCBpdCBpcyBvbmx5IHRlc3QgZGF0YS4gZG8gbm90IHRyeSB0byByZWFkIHRva2VuIQ==")
);
""","""client.security().invalidateToken(i -> i
	.username("myuser")
);
""","""client.security().oidcAuthenticate(o -> o
	.nonce("WaBPH0KqPVdG5HHdSxPRjfoZbXMCicm5v1OiAj0DUFM")
	.realm("oidc1")
	.redirectUri("https://oidc-kibana.elastic.co:5603/api/security/oidc/callback?code=jtI3Ntt8v3_XvcLzCFGq&state=4dbrihtIAt3wBTwo6DxK-vdk-sSyDBV8Yf0AjdkdT5I")
	.state("4dbrihtIAt3wBTwo6DxK-vdk-sSyDBV8Yf0AjdkdT5I")
);
""","""client.security().oidcLogout(o -> o
	.refreshToken("vLBPvmAB6KvwvJZr27cS")
	.token("dGhpcyBpcyBub3QgYSByZWFsIHRva2VuIGJ1dCBpdCBpcyBvbmx5IHRlc3QgZGF0YS4gZG8gbm90IHRyeSB0byByZWFkIHRva2VuIQ==")
);
""","""client.security().oidcPrepareAuthentication(o -> o
	.iss("http://127.0.0.1:8080")
	.loginHint("this_is_an_opaque_string")
);
""","""client.security().oidcPrepareAuthentication(o -> o
	.nonce("zOBXLJGUooRrbLbQk5YCcyC8AXw3iloynvluYhZ5")
	.realm("oidc1")
	.state("lGYK0EcSLjqH6pkT5EVZjC6eIW5YCGgywj2sxROO")
);
""","""client.security().oidcPrepareAuthentication(o -> o
	.realm("oidc1")
);
""","""client.security().putPrivileges(p -> p
	.privileges("myapp", Map.of("read", Actions.of(a -> a
			.actions(List.of("data:read/*","action:login"))
			.metadata("description", JsonData.fromJson("\"Read access to myapp\""))
		)))
);
""","""client.security().putPrivileges(p -> p
	.privileges(Map.of("app02", "all", pr -> pr
		.actions("*"),"app01", Map.of("read", Actions.of(a -> a
			.actions(List.of("action:login","data:read/*"))
		),"write", Actions.of(a -> a
			.actions(List.of("action:login","data:write/*"))
		))))
);
""","""client.security().putRole(p -> p
	.applications(a -> a
		.application("myapp")
		.privileges(List.of("admin","read"))
		.resources("*")
	)
	.cluster("all")
	.description("Grants full access to all management features within the cluster.")
	.indices(i -> i
		.fieldSecurity(f -> f
			.grant(List.of("title","body"))
		)
		.names(List.of("index1","index2"))
		.privileges("all")
		.query(q -> q
			.match(m -> m
				.field("title")
				.query(FieldValue.of("foo"))
			)
		)
	)
	.metadata("version", JsonData.fromJson("1"))
	.name("my_admin_role")
	.runAs("other_user")
);
""","""client.security().putRole(p -> p
	.cluster("cluster:monitor/main")
	.indices(i -> i
		.names("test")
		.privileges(List.of("read","indices:admin/get"))
	)
	.name("cli_or_drivers_minimal")
);
""","""client.security().putRole(p -> p
	.name("only_remote_access_role")
	.remoteCluster(r -> r
		.clusters("my_remote")
		.privileges(RemoteClusterPrivilege.MonitorStats)
	)
	.remoteIndices(r -> r
		.clusters("my_remote")
		.names("logs*")
		.privileges(List.of("read","read_cross_cluster","view_index_metadata"))
	)
);
""","""client.security().putRole(p -> p
	.name("only_remote_access_role")
	.remoteCluster(r -> r
		.clusters("my_remote")
		.privileges(RemoteClusterPrivilege.MonitorStats)
	)
	.remoteIndices(r -> r
		.clusters("my_remote")
		.names("logs*")
		.privileges(List.of("read","read_cross_cluster","view_index_metadata"))
	)
);
""","""client.security().putRoleMapping(p -> p
	.enabled(true)
	.metadata("version", JsonData.fromJson("1"))
	.name("mapping1")
	.roles("user")
	.rules(r -> r
		.field(NamedValue.of("username",List.of(FieldValue.of("*"))))
	)
);
""","""client.security().putRoleMapping(p -> p
	.enabled(true)
	.name("mapping2")
	.roles(List.of("user","admin"))
	.rules(r -> r
		.field(NamedValue.of("username",List.of(FieldValue.of("esadmin01"),FieldValue.of("esadmin02"))))
	)
);
""","""client.security().putRoleMapping(p -> p
	.enabled(true)
	.name("mapping3")
	.roles("ldap-user")
	.rules(r -> r
		.field(NamedValue.of("realm.name",List.of(FieldValue.of("ldap1"))))
	)
);
""","""client.security().putRoleMapping(p -> p
	.enabled(true)
	.name("mapping4")
	.roles("superuser")
	.rules(r -> r
		.any(List.of(RoleMappingRule.of(ro -> ro
				.field(NamedValue.of("username",List.of(FieldValue.of("esadmin"))))
			),RoleMappingRule.of(rol -> rol
				.field(NamedValue.of("groups",List.of(FieldValue.of("cn=admins,dc=example,dc=com"))))
			)))
	)
);
""","""client.security().putRoleMapping(p -> p
	.enabled(true)
	.name("mapping5")
	.roleTemplates(r -> r
		.format(TemplateFormat.Json)
		.template(t -> t
			.source(s -> s
				.scriptString("{{#tojson}}groups{{/tojson}}")
			)
		)
	)
	.rules(ru -> ru
		.field(NamedValue.of("realm.name",List.of(FieldValue.of("saml1"))))
	)
);
""","""client.security().putRoleMapping(p -> p
	.enabled(true)
	.name("mapping6")
	.roleTemplates(r -> r
		.format(TemplateFormat.Json)
		.template(t -> t
			.source(s -> s
				.scriptString("{{#tojson}}groups{{/tojson}}")
			)
		)
	)
	.rules(ru -> ru
		.field(NamedValue.of("realm.name",List.of(FieldValue.of("saml1"))))
	)
);
""","""client.security().putRoleMapping(p -> p
	.enabled(true)
	.name("mapping7")
	.roles("ldap-example-user")
	.rules(r -> r
		.all(List.of(RoleMappingRule.of(ro -> ro
				.field(NamedValue.of("dn",List.of(FieldValue.of("*,ou=subtree,dc=example,dc=com"))))
			),RoleMappingRule.of(rol -> rol
				.field(NamedValue.of("realm.name",List.of(FieldValue.of("ldap1"))))
			)))
	)
);
""","""client.security().putRoleMapping(p -> p
	.enabled(true)
	.name("mapping8")
	.roles("superuser")
	.rules(r -> r
		.all(List.of(RoleMappingRule.of(ro -> ro
				.any(List.of(RoleMappingRule.of(rol -> rol
						.field(NamedValue.of("dn",List.of(FieldValue.of("*,ou=admin,dc=example,dc=com"))))
					),RoleMappingRule.of(role -> role
						.field(NamedValue.of("username",List.of(FieldValue.of("es-admin"),FieldValue.of("es-system"))))
					)))
			),RoleMappingRule.of(roleM -> roleM
				.field(NamedValue.of("groups",List.of(FieldValue.of("cn=people,dc=example,dc=com"))))
			),RoleMappingRule.of(roleMa -> roleMa
				.except(e -> e
					.field(NamedValue.of("metadata.terminated_date",List.of(null)))
				)
			)))
	)
);
""","""client.security().putRoleMapping(p -> p
	.enabled(true)
	.name("mapping9")
	.roleTemplates(List.of(RoleTemplate.of(r -> r
			.template(t -> t
				.source(s -> s
					.scriptString("saml_user")
				)
			)
		),RoleTemplate.of(ro -> ro
			.template(t -> t
				.source(s -> s
					.scriptString("_user_{{username}}")
				)
			)
		)))
	.rules(ru -> ru
		.field(NamedValue.of("realm.name",List.of(FieldValue.of("cloud-saml"))))
	)
);
""","""client.security().putUser(p -> p
	.email("jacknich@example.com")
	.fullName("Jack Nicholson")
	.metadata("intelligence", JsonData.fromJson("7"))
	.password("l0ng-r4nd0m-p@ssw0rd")
	.roles(List.of("admin","other_role1"))
	.username("jacknich")
);
""","""client.security().queryApiKeys(q -> q
	.from(20)
	.query(qu -> qu
		.bool(b -> b
			.filter(List.of(Query.of(que -> que
					.wildcard(w -> w
						.field("username")
						.value("org-*-user")
					)
				),Query.of(quer -> quer
					.term(t -> t
						.field("metadata.environment")
						.value(FieldValue.of("production"))
					)
				)))
			.must(List.of(Query.of(query -> query
					.prefix(p -> p
						.field("name")
						.value("app1-key-")
					)
				),Query.of(query1 -> query1
					.term(t -> t
						.field("invalidated")
						.value(FieldValue.of("false"))
					)
				)))
			.mustNot(m -> m
				.term(t -> t
					.field("name")
					.value(FieldValue.of("app1-key-01"))
				)
			)
		)
	)
	.size(10)
	.sort(List.of(SortOptions.of(s -> s
			.field(f -> f
				.field("creation")
				.order(SortOrder.Desc)
				.format("date_time")
			)
		),SortOptions.of(so -> so
			.field(f -> f
				.field("name")
			)
		)))
);
""","""client.security().queryApiKeys(q -> q
	.query(qu -> qu
		.ids(i -> i
			.values("VuaCfGcBCdbkQm-e5aOx")
		)
	)
	.withLimitedBy(true)
);
""","""client.security().queryApiKeys(q -> q
	.query(qu -> qu
		.term(t -> t
			.field("name")
			.value(FieldValue.of("application-key-1"))
		)
	)
);
""","""client.security().queryRole(q -> q
	.query(qu -> qu
		.match(m -> m
			.field("description")
			.query(FieldValue.of("user access"))
		)
	)
	.size(1)
);
""","""client.security().queryRole(q -> q
	.sort(s -> s
		.field(f -> f
			.field("name")
		)
	)
);
""","""client.security().queryUser(q -> q
	.from(1)
	.query(qu -> qu
		.bool(b -> b
			.filter(f -> f
				.wildcard(w -> w
					.field("roles")
					.value("*other*")
				)
			)
			.must(List.of(Query.of(que -> que
					.wildcard(w -> w
						.field("email")
						.value("*example.com")
					)
				),Query.of(quer -> quer
					.term(t -> t
						.field("enabled")
						.value(FieldValue.of(true))
					)
				)))
		)
	)
	.size(2)
	.sort(s -> s
		.field(fi -> fi
			.field("username")
			.order(SortOrder.Desc)
		)
	)
);
""","""client.security().queryUser(q -> q
	.query(qu -> qu
		.prefix(p -> p
			.field("roles")
			.value("other")
		)
	)
	.withProfileUid(true)
);
""","""client.security().samlAuthenticate(s -> s
	.content("PHNhbWxwOlJlc3BvbnNlIHhtbG5zOnNhbWxwPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6cHJvdG9jb2wiIHhtbG5zOnNhbWw9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMD.....")
	.ids("4fee3b046395c4e751011e97f8900b5273d56685")
);
""","""client.security().samlCompleteLogout(s -> s
	.content("PHNhbWxwOkxvZ291dFJlc3BvbnNlIHhtbG5zOnNhbWxwPSJ1cm46...")
	.ids("_1c368075e0b3...")
	.realm("saml1")
);
""","""client.security().samlCompleteLogout(s -> s
	.ids("_1c368075e0b3...")
	.queryString("SAMLResponse=fZHLasMwEEVbfb1bf...&SigAlg=http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23rsa-sha1&Signature=CuCmFn%2BLqnaZGZJqK...")
	.realm("saml1")
);
""","""client.security().samlInvalidate(s -> s
	.queryString("SAMLRequest=nZFda4MwFIb%2FiuS%2BmviRpqFaClKQdbvo2g12M2KMraCJ9cRR9utnW4Wyi13sMie873MeznJ1aWrnS3VQGR0j4mLkKC1NUeljjA77zYyhVbIE0dR%2By7fmaHq7U%2BdegXWGpAZ%2B%2F4pR32luBFTAtWgUcCv56%2Fp5y30X87Yz1khTIycdgpUW9kY7WdsC9zxoXTvMvWuVV98YyMnSGH2SYE5pwALBIr9QKiwDGpW0oGVUznGeMyJZKFkQ4jBf5HnhUymjIhzCAL3KNFihbYx8TBYzzGaY7EnIyZwHzCWMfiDnbRIftkSjJr%2BFu0e9v%2B0EgOquRiiZjKpiVFp6j50T4WXoyNJ%2FEWC9fdqc1t%2F1%2B2F3aUpjzhPiXpqMz1%2FHSn4A&SigAlg=http%3A%2F%2Fwww.w3.org%2F2001%2F04%2Fxmldsig-more%23rsa-sha256&Signature=MsAYz2NFdovMG2mXf6TSpu5vlQQyEJAg%2B4KCwBqJTmrb3yGXKUtIgvjqf88eCAK32v3eN8vupjPC8LglYmke1ZnjK0%2FKxzkvSjTVA7mMQe2AQdKbkyC038zzRq%2FYHcjFDE%2Bz0qISwSHZY2NyLePmwU7SexEXnIz37jKC6NMEhus%3D")
	.realm("saml1")
);
""","""client.security().samlLogout(s -> s
	.refreshToken("mJdXLtmvTUSpoLwMvdBt_w")
	.token("46ToAxZVaXVVZTVKOVF5YU04ZFJVUDVSZlV3")
);
""","""client.security().samlPrepareAuthentication(s -> s
	.acs("https://kibana.org/api/security/saml/callback")
);
""","""client.security().samlPrepareAuthentication(s -> s
	.realm("saml1")
);
""","""client.security().suggestUserProfiles(s -> s
	.hint(h -> h
		.uids(List.of("u_8RKO7AKfEbSiIHZkZZ2LJy2MUSDPWDr3tMI_CkIGApU_0","u_79HkWkwmnBH5gqFKwoxggWPjEBOur1zLPXQPEl1VBW0_0"))
		.labels("direction", List.of("north","east"))
	)
	.name("jack")
);
""","""client.security().updateApiKey(u -> u
	.id("VuaCfGcBCdbkQm-e5aOx")
	.metadata("environment", JsonData.fromJson("{\"level\":2,\"trusted\":true,\"tags\":[\"production\"]}"))
	.roleDescriptors("role-a", r -> r
		.indices(i -> i
			.names("*")
			.privileges("write")
		)
	)
);
""","""client.security().updateApiKey(u -> u
	.id("VuaCfGcBCdbkQm-e5aOx")
);
""","""client.security().updateCrossClusterApiKey(u -> u
	.access(a -> a
		.replication(r -> r
			.names("archive")
		)
	)
	.id("VuaCfGcBCdbkQm-e5aOx")
	.metadata("application", JsonData.fromJson("\"replication\""))
);
""","""client.security().updateSettings(u -> u
	.security(s -> s)
	.securityProfile(s -> s)
	.securityTokens(s -> s)
);
""","""client.security().updateUserProfileData(u -> u
	.data("app1", JsonData.fromJson("{\"theme\":\"default\"}"))
	.labels("direction", JsonData.fromJson("\"east\""))
	.uid("u_P_0BMHgaOK3p7k-PFWUCbw9dQ-UFjt01oWJ_Dp2PmPc_0")
);
""","""client.security().updateUserProfileData(u -> u
	.uid("u_P_0BMHgaOK3p7k-PFWUCbw9dQ-UFjt01oWJ_Dp2PmPc_0")
);
""","""client.shutdown().deleteNode(d -> d
	.nodeId("USpTGYaBSIKbgSUJR2Z9lg")
);
""","""client.shutdown().getNode(g -> g
	.nodeId("USpTGYaBSIKbgSUJR2Z9lg")
);
""","""client.shutdown().putNode(p -> p
	.allocationDelay("20m")
	.nodeId("USpTGYaBSIKbgSUJR2Z9lg")
	.reason("Demonstrating how the node shutdown API works")
	.type(Type.Restart)
);
""","""client.simulate().ingest(i -> i
	.componentTemplateSubstitutions("my-component-template", c -> c
		.template(t -> t
			.settings("index", s -> s
				.defaultPipeline("my-pipeline")
			)
			.mappings(m -> m
				.dynamic(DynamicMapping.True)
				.properties("field3", p -> p
					.keyword(k -> k)
				)
			)
		)
	)
	.docs(List.of(Document.of(d -> d
			.id("id")
			.index("my-index")
			.source(JsonData.fromJson("{\"foo\":\"bar\"}"))
		),Document.of(d -> d
			.id("id")
			.index("my-index")
			.source(JsonData.fromJson("{\"foo\":\"rab\"}"))
		)))
	.indexTemplateSubstitutions("my-index-template", in -> in
		.indexPatterns("my-index-*")
		.composedOf(List.of("component_template_1","component_template_2"))
	)
	.mappingAddition(m -> m
		.dynamic(DynamicMapping.Strict)
		.properties("foo", p -> p
			.keyword(k -> k)
		)
	)
	.pipelineSubstitutions("my-pipeline", p -> p
		.processors(pr -> pr
			.set(s -> s
				.field("field3")
				.value(JsonData.fromJson("\"value3\""))
			)
		)
	)
);
""","""client.simulate().ingest(i -> i
	.componentTemplateSubstitutions("my-mappings_template", c -> c
		.template(t -> t
			.mappings(m -> m
				.dynamic(DynamicMapping.Strict)
				.properties(Map.of("bar", Property.of(p -> p
						.keyword(k -> k)
					),"foo", Property.of(pr -> pr
						.keyword(k -> k)
					)))
			)
		)
	)
	.docs(List.of(Document.of(d -> d
			.id("123")
			.index("my-index")
			.source(JsonData.fromJson("{\"foo\":\"foo\"}"))
		),Document.of(d -> d
			.id("456")
			.index("my-index")
			.source(JsonData.fromJson("{\"bar\":\"rab\"}"))
		)))
);
""","""client.simulate().ingest(i -> i
	.docs(List.of(Document.of(d -> d
			.id("123")
			.index("my-index")
			.source(JsonData.fromJson("{\"foo\":\"bar\"}"))
		),Document.of(d -> d
			.id("456")
			.index("my-index")
			.source(JsonData.fromJson("{\"foo\":\"rab\"}"))
		)))
	.pipelineSubstitutions("my-pipeline", p -> p
		.processors(pr -> pr
			.uppercase(u -> u
				.field("foo")
			)
		)
	)
);
""","""client.simulate().ingest(i -> i
	.docs(List.of(Document.of(d -> d
			.id("123")
			.index("my-index")
			.source(JsonData.fromJson("{\"foo\":\"bar\"}"))
		),Document.of(d -> d
			.id("456")
			.index("my-index")
			.source(JsonData.fromJson("{\"foo\":\"rab\"}"))
		)))
);
""","""client.slm().deleteLifecycle(d -> d
	.policyId("daily-snapshots")
);
""","""client.slm().executeLifecycle(e -> e
	.policyId("daily-snapshots")
);
""","""client.slm().executeRetention(e -> e);
""","""client.slm().getLifecycle(g -> g
	.policyId("daily-snapshots")
);
""","""client.slm().getStats(g -> g);
""","""client.slm().getStatus(g -> g);
""","""client.slm().putLifecycle(p -> p
	.config(c -> c
		.ignoreUnavailable(false)
		.indices(List.of("data-*","important"))
		.includeGlobalState(false)
	)
	.name("<daily-snap-{now/d}>")
	.policyId("daily-snapshots")
	.repository("my_repository")
	.retention(r -> r
		.expireAfter(e -> e
			.time("30d")
		)
		.maxCount(50)
		.minCount(5)
	)
	.schedule("0 30 1 * * ?")
);
""","""client.slm().putLifecycle(p -> p
	.config(c -> c
		.indices(List.of("data-*","important"))
	)
	.name("<hourly-snap-{now/d}>")
	.policyId("hourly-snapshots")
	.repository("my_repository")
	.schedule("1h")
);
""","""client.slm().start(s -> s);
""","""client.snapshot().cleanupRepository(c -> c
	.name("my_repository")
);
""","""client.snapshot().clone(c -> c
	.indices("index_a,index_b")
	.repository("my_repository")
	.snapshot("source_snapshot")
	.targetSnapshot("target_snapshot")
);
""","""client.snapshot().create(c -> c
	.ignoreUnavailable(true)
	.includeGlobalState(false)
	.indices("index_1,index_2")
	.metadata(Map.of("taken_by", JsonData.fromJson("\"user123\""),"taken_because", JsonData.fromJson("\"backup before upgrading\"")))
	.repository("my_repository")
	.snapshot("snapshot_2")
	.waitForCompletion(true)
);
""","""client.snapshot().createRepository(c -> c
	.name("my_backup")
	.repository(r -> r
		.azure(a -> a
			.settings(s -> s
				.client("secondary")
			)
		)
	)
);
""","""client.snapshot().createRepository(c -> c
	.name("my_gcs_repository")
	.repository(r -> r
		.gcs(g -> g
			.settings(s -> s
				.bucket("my_other_bucket")
				.basePath("dev")
			)
		)
	)
);
""","""client.snapshot().createRepository(c -> c
	.name("my_read_only_url_repository")
	.repository(r -> r
		.url(u -> u
			.settings(s -> s
				.url("file:/mount/backups/my_fs_backup_location")
			)
		)
	)
);
""","""client.snapshot().createRepository(c -> c
	.name("my_repository")
	.repository(r -> r
		.fs(f -> f
			.settings(s -> s
				.location("my_backup_location")
			)
		)
	)
);
""","""client.snapshot().createRepository(c -> c
	.name("my_s3_repository")
	.repository(r -> r
		.s3(s -> s
			.settings(se -> se
				.bucket("my-bucket")
			)
		)
	)
);
""","""client.snapshot().createRepository(c -> c
	.name("my_src_only_repository")
	.repository(r -> r
		.source(s -> s
			.settings(se -> se
				.delegateType("fs")
			)
		)
	)
);
""","""client.snapshot().delete(d -> d
	.repository("my_repository")
	.snapshot("snapshot_2,snapshot_3")
);
""","""client.snapshot().deleteRepository(d -> d
	.name("my_repository")
);
""","""client.snapshot().get(g -> g
	.fromSortValue("1577833200000")
	.repository("my_repository")
	.snapshot("snapshot_*")
	.sort(SnapshotSort.StartTime)
);
""","""client.snapshot().getRepository(g -> g
	.name("my_repository")
);
""","""client.snapshot().repositoryAnalyze(r -> r
	.blobCount(10)
	.maxBlobSize("1mb")
	.name("my_repository")
	.timeout(t -> t
		.offset(120)
	)
);
""","""client.snapshot().repositoryVerifyIntegrity(r -> r
	.name("my_repository")
);
""","""client.snapshot().restore(r -> r
	.ignoreUnavailable(true)
	.includeAliases(false)
	.includeGlobalState(false)
	.indices("index_1,index_2")
	.renamePattern("index_(.+)")
	.renameReplacement("restored_index_${'\$'}1")
	.repository("my_repository")
	.snapshot("snapshot_2")
	.waitForCompletion(true)
);
""","""client.snapshot().status(s -> s
	.repository("my_repository")
	.snapshot("snapshot_2")
);
""","""client.snapshot().verifyRepository(v -> v
	.name("my_unverified_backup")
);
""","""client.sql().clearCursor(c -> c
	.cursor("sDXF1ZXJ5QW5kRmV0Y2gBAAAAAAAAAAEWYUpOYklQMHhRUEtld3RsNnFtYU1hQQ==:BAFmBGRhdGUBZgVsaWtlcwFzB21lc3NhZ2UBZgR1c2Vy9f///w8=")
);
""","""client.sql().deleteAsync(d -> d
	.id("FmdMX2pIang3UWhLRU5QS0lqdlppYncaMUpYQ05oSkpTc3kwZ21EdC1tbFJXQToxOTI=")
);
""","""client.sql().getAsync(g -> g
	.format("json")
	.id("FnR0TDhyWUVmUmVtWXRWZER4MXZiNFEad2F5UDk2ZVdTVHV1S0xDUy00SklUdzozMTU=")
	.waitForCompletionTimeout(w -> w
		.offset(2)
	)
);
""","""client.sql().getAsyncStatus(g -> g
	.id("FnR0TDhyWUVmUmVtWXRWZER4MXZiNFEad2F5UDk2ZVdTVHV1S0xDUy00SklUdzozMTU=")
);
""","""client.sql().query(q -> q
	.format(SqlFormat.Txt)
	.query("SELECT * FROM library ORDER BY page_count DESC LIMIT 5")
);
""","""client.sql().translate(t -> t
	.fetchSize(10)
	.query("SELECT * FROM library ORDER BY page_count DESC")
);
""","""client.ssl().certificates();
""","""client.streams().logsDisable(l -> l);
""","""client.streams().logsEnable(l -> l);
""","""client.streams().status(s -> s);
""","""client.synonyms().deleteSynonym(d -> d
	.id("my-synonyms-set")
);
""","""client.synonyms().deleteSynonymRule(d -> d
	.ruleId("test-1")
	.setId("my-synonyms-set")
);
""","""client.synonyms().getSynonym(g -> g
	.id("my-synonyms-set")
);
""","""client.synonyms().getSynonymRule(g -> g
	.ruleId("test-1")
	.setId("my-synonyms-set")
);
""","""client.synonyms().getSynonymsSets(g -> g);
""","""client.synonyms().putSynonym(p -> p
	.id("my-synonyms-set")
	.synonymsSet(s -> s
		.synonyms("hello, hi, howdy")
	)
);
""","""client.synonyms().putSynonymRule(p -> p
	.ruleId("test-1")
	.setId("my-synonyms-set")
	.synonyms("hello, hi, howdy")
);
""","""client.tasks().cancel(c -> c
	.taskId("<task_id>")
);
""","""client.tasks().list(l -> l
	.actions("*/delete/byquery")
	.detailed(true)
);
""","""client.tasks().list(l -> l
	.actions("*search")
	.detailed(true)
);
""","""client.termsEnum(t -> t
	.field("tags")
	.index("stackoverflow")
	.string("kiba")
);
""","""client.termvectors(t -> t
	.doc(JsonData.fromJson("{\"fullname\":\"John Doe\",\"text\":\"test test test\"}"))
	.fields("fullname")
	.index("my-index-000001")
	.perFieldAnalyzer("fullname", "keyword")
);
""","""client.termvectors(t -> t
	.doc(JsonData.fromJson("{\"fullname\":\"John Doe\",\"text\":\"test test test\"}"))
	.index("my-index-000001")
);
""","""client.termvectors(t -> t
	.doc(JsonData.fromJson("{\"plot\":\"When wealthy industrialist Tony Stark is forced to build an armored suit after a life-threatening incident, he ultimately decides to use its technology to fight against evil.\"}"))
	.fieldStatistics(true)
	.filter(f -> f
		.maxNumTerms(3)
		.minDocFreq(1)
		.minTermFreq(1)
	)
	.index("imdb")
	.offsets(false)
	.positions(false)
	.termStatistics(true)
);
""","""client.termvectors(t -> t
	.fieldStatistics(true)
	.fields("text")
	.id("1")
	.index("my-index-000001")
	.offsets(true)
	.payloads(true)
	.positions(true)
	.termStatistics(true)
);
""","""client.termvectors(t -> t
	.fieldStatistics(true)
	.fields(List.of("text","some_field_without_term_vectors"))
	.id("1")
	.index("my-index-000001")
	.offsets(true)
	.positions(true)
	.termStatistics(true)
);
""","""client.textStructure().findFieldStructure(f -> f
	.field("message")
	.index("test-logs")
);
""","""client.textStructure().findMessageStructure(f -> f
	.messages(List.of("[2024-03-05T10:52:36,256][INFO ][o.a.l.u.VectorUtilPanamaProvider] [laptop] Java vector incubator API enabled; uses preferredBitSize=128","[2024-03-05T10:52:41,038][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [repository-url]","[2024-03-05T10:52:41,042][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [rest-root]","[2024-03-05T10:52:41,043][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [x-pack-core]","[2024-03-05T10:52:41,043][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [x-pack-redact]","[2024-03-05T10:52:41,043][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [ingest-user-agent]","[2024-03-05T10:52:41,044][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [x-pack-monitoring]","[2024-03-05T10:52:41,044][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [repository-s3]","[2024-03-05T10:52:41,044][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [x-pack-analytics]","[2024-03-05T10:52:41,044][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [x-pack-ent-search]","[2024-03-05T10:52:41,044][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [x-pack-autoscaling]","[2024-03-05T10:52:41,044][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [lang-painless]]","[2024-03-05T10:52:41,059][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [lang-expression]","[2024-03-05T10:52:41,059][INFO ][o.e.p.PluginsService	 ] [laptop] loaded module [x-pack-eql]","[2024-03-05T10:52:43,291][INFO ][o.e.e.NodeEnvironment	] [laptop] heap size [16gb], compressed ordinary object pointers [true]","[2024-03-05T10:52:46,098][INFO ][o.e.x.s.Security		 ] [laptop] Security is enabled","[2024-03-05T10:52:47,227][INFO ][o.e.x.p.ProfilingPlugin  ] [laptop] Profiling is enabled","[2024-03-05T10:52:47,259][INFO ][o.e.x.p.ProfilingPlugin  ] [laptop] profiling index templates will not be installed or reinstalled","[2024-03-05T10:52:47,755][INFO ][o.e.i.r.RecoverySettings ] [laptop] using rate limit [40mb] with [default=40mb, read=0b, write=0b, max=0b]","[2024-03-05T10:52:47,787][INFO ][o.e.d.DiscoveryModule	] [laptop] using discovery type [multi-node] and seed hosts providers [settings]","[2024-03-05T10:52:49,188][INFO ][o.e.n.Node			   ] [laptop] initialized","[2024-03-05T10:52:49,199][INFO ][o.e.n.Node			   ] [laptop] starting ..."))
);
""","""client.textStructure().testGrokPattern(t -> t
	.grokPattern("Hello %{WORD:first_name} %{WORD:last_name}")
	.text(List.of("Hello John Doe","this does not match"))
);
""","""client.transform().deleteTransform(d -> d
	.transformId("ecommerce_transform")
);
""","""client.transform().getTransform(g -> g
	.size(10)
);
""","""client.transform().getTransformStats(g -> g
	.transformId("ecommerce-customer-transform")
);
""","""client.transform().previewTransform(p -> p
	.pivot(pi -> pi
		.aggregations("max_price", a -> a
			.max(m -> m
				.field("taxful_total_price")
			)
		)
		.groupBy("customer_id", g -> g
			.terms(t -> t
				.field("customer_id")
				.missingBucket(true)
			)
		)
	)
	.source(s -> s
		.index("kibana_sample_data_ecommerce")
	)
);
""","""client.transform().putTransform(p -> p
	.description("Latest order for each customer")
	.dest(d -> d
		.index("kibana_sample_data_ecommerce_transform2")
	)
	.frequency(f -> f
		.time("5m")
	)
	.latest(l -> l
		.sort("order_date")
		.uniqueKey("customer_id")
	)
	.source(s -> s
		.index("kibana_sample_data_ecommerce")
	)
	.sync(s -> s
		.time(t -> t
			.delay(d -> d
				.time("60s")
			)
			.field("order_date")
		)
	)
	.transformId("ecommerce_transform2")
);
""","""client.transform().putTransform(p -> p
	.description("Maximum priced ecommerce data by customer_id in Asia")
	.dest(d -> d
		.index("kibana_sample_data_ecommerce_transform1")
		.pipeline("add_timestamp_pipeline")
	)
	.frequency(f -> f
		.time("5m")
	)
	.pivot(pi -> pi
		.aggregations("max_price", a -> a
			.max(m -> m
				.field("taxful_total_price")
			)
		)
		.groupBy("customer_id", g -> g
			.terms(t -> t
				.field("customer_id")
				.missingBucket(true)
			)
		)
	)
	.retentionPolicy(r -> r
		.time(t -> t
			.field("order_date")
			.maxAge(m -> m
				.time("30d")
			)
		)
	)
	.source(s -> s
		.index("kibana_sample_data_ecommerce")
		.query(q -> q
			.term(te -> te
				.field("geoip.continent_name")
				.value(FieldValue.of("Asia"))
			)
		)
	)
	.sync(sy -> sy
		.time(ti -> ti
			.delay(d -> d
				.time("60s")
			)
			.field("order_date")
		)
	)
	.transformId("ecommerce_transform1")
);
""","""client.transform().resetTransform(r -> r
	.transformId("ecommerce_transform")
);
""","""client.transform().scheduleNowTransform(s -> s
	.transformId("ecommerce_transform")
);
""","""client.transform().setUpgradeMode(s -> s
	.enabled(true)
);
""","""client.transform().startTransform(s -> s
	.transformId("ecommerce-customer-transform")
);
""","""client.transform().stopTransform(s -> s
	.transformId("ecommerce_transform")
);
""","""client.transform().updateTransform(u -> u
	.description("Maximum priced ecommerce data by customer_id in Asia")
	.dest(d -> d
		.index("kibana_sample_data_ecommerce_transform_v2")
		.pipeline("add_timestamp_pipeline")
	)
	.frequency(f -> f
		.time("15m")
	)
	.source(s -> s
		.index("kibana_sample_data_ecommerce")
		.query(q -> q
			.term(t -> t
				.field("geoip.continent_name")
				.value(FieldValue.of("Asia"))
			)
		)
	)
	.sync(sy -> sy
		.time(t -> t
			.delay(d -> d
				.time("120s")
			)
			.field("order_date")
		)
	)
	.transformId("simple-kibana-ecomm-pivot")
);
""","""client.transform().upgradeTransforms(u -> u);
""","""client.update(u -> u
	.doc(JsonData.fromJson("{\"name\":\"new_name\"}"))
	.docAsUpsert(true)
	.id("1")
	.index("test")
,Void.class);
""","""client.update(u -> u
	.doc(JsonData.fromJson("{\"name\":\"new_name\"}"))
	.id("1")
	.index("test")
,Void.class);
""","""client.update(u -> u
	.id("1")
	.index("test")
	.script(s -> s
		.source(so -> so
			.scriptString("
	  if ( ctx.op == 'create' ) {
		ctx._source.counter = params.count
	  } else {
		ctx._source.counter += params.count
	  }
	")
		)
		.params("count", JsonData.fromJson("4"))
	)
	.scriptedUpsert(true)
	.upsert(JsonData.fromJson("{}"))
,Void.class);
""","""client.update(u -> u
	.id("1")
	.index("test")
	.script(s -> s
		.source(so -> so
			.scriptString("ctx._source.counter += params.count")
		)
		.params("count", JsonData.fromJson("4"))
		.lang("painless")
	)
	.upsert(JsonData.fromJson("{\"counter\":1}"))
,Void.class);
""","""client.update(u -> u
	.id("1")
	.index("test")
	.script(s -> s
		.source(so -> so
			.scriptString("ctx._source.counter += params.count")
		)
		.params("count", JsonData.fromJson("4"))
		.lang("painless")
	)
,Void.class);
""","""client.update(u -> u
	.id("1")
	.index("test")
	.script(s -> s
		.source(so -> so
			.scriptString("ctx._source.new_field = 'value_of_new_field'")
		)
	)
,Void.class);
""","""client.update(u -> u
	.id("1")
	.index("test")
	.script(s -> s
		.source(so -> so
			.scriptString("ctx._source.remove('new_field')")
		)
	)
,Void.class);
""","""client.update(u -> u
	.id("1")
	.index("test")
	.script(s -> s
		.source(so -> so
			.scriptString("ctx._source.tags.add(params.tag)")
		)
		.params("tag", JsonData.fromJson("\"blue\""))
		.lang("painless")
	)
,Void.class);
""","""client.update(u -> u
	.id("1")
	.index("test")
	.script(s -> s
		.source(so -> so
			.scriptString("ctx._source['my-object'].remove('my-subfield')")
		)
	)
,Void.class);
""","""client.update(u -> u
	.id("1")
	.index("test")
	.script(s -> s
		.source(so -> so
			.scriptString("if (ctx._source.tags.contains(params.tag)) { ctx._source.tags.remove(ctx._source.tags.indexOf(params.tag)) }")
		)
		.params("tag", JsonData.fromJson("\"blue\""))
		.lang("painless")
	)
,Void.class);
""","""client.update(u -> u
	.id("1")
	.index("test")
	.script(s -> s
		.source(so -> so
			.scriptString("if (ctx._source.tags.contains(params.tag)) { ctx.op = 'delete' } else { ctx.op = 'noop' }")
		)
		.params("tag", JsonData.fromJson("\"green\""))
		.lang("painless")
	)
,Void.class);
""","""client.updateByQuery(u -> u
	.conflicts(Conflicts.Proceed)
	.index("my-index-000001")
	.query(q -> q
		.term(t -> t
			.field("user.id")
			.value(FieldValue.of("kimchy"))
		)
	)
);
""","""client.updateByQuery(u -> u
	.index("my-index-000001")
	.query(q -> q
		.term(t -> t
			.field("user.id")
			.value(FieldValue.of("kimchy"))
		)
	)
	.script(s -> s
		.source(so -> so
			.scriptString("ctx._source.count++")
		)
		.lang("painless")
	)
);
""","""client.updateByQuery(u -> u
	.index("my-index-000001")
	.refresh(true)
	.script(s -> s
		.source(so -> so
			.scriptString("ctx._source['extra'] = 'test'")
		)
	)
	.slices(sl -> sl
		.value(5)
	)
);
""","""client.updateByQuery(u -> u
	.index("my-index-000001")
	.script(s -> s
		.source(so -> so
			.scriptString("ctx._source['extra'] = 'test'")
		)
	)
	.slice(sl -> sl
		.id("0")
		.max(2)
	)
);
""","""client.updateByQueryRethrottle(u -> u
	.requestsPerSecond(-1.0F)
	.taskId("r1A2WoRbTwKZ516z6NEs5A:36619")
);
""","""client.watcher().ackWatch(a -> a
	.watchId("my_watch")
);
""","""client.watcher().activateWatch(a -> a
	.watchId("my_watch")
);
""","""client.watcher().deactivateWatch(d -> d
	.watchId("my_watch")
);
""","""client.watcher().deleteWatch(d -> d
	.id("my_watch")
);
""","""client.watcher().executeWatch(e -> e
	.actionModes("my-action", ActionExecutionMode.ForceSimulate)
	.alternativeInput("foo", JsonData.fromJson("\"bar\""))
	.id("my_watch")
	.ignoreCondition(true)
	.recordExecution(true)
	.triggerData(t -> t
		.scheduledTime(DateTime.of("now"))
		.triggeredTime(DateTime.of("now"))
	)
);
""","""client.watcher().executeWatch(e -> e
	.actionModes(Map.of("action1", ActionExecutionMode.ForceSimulate,"action2", ActionExecutionMode.Skip))
	.id("my_watch")
);
""","""client.watcher().executeWatch(e -> e
	.watch(w -> w
		.actions("log_error", a -> a
			.logging(l -> l
				.text("Found {{ctx.payload.hits.total}} errors in the logs")
			)
		)
		.condition(c -> c
			.compare(NamedValue.of("ctx.payload.hits.total",Pair.of(ConditionOp.Gt,FieldValue.of(0))))
		)
		.input(i -> i
			.search(s -> s
				.request(r -> r
					.body(b -> b
						.query(q -> q
							.match(m -> m
								.field("message")
								.query(FieldValue.of("error"))
							)
						)
					)
					.indices("logs")
				)
			)
		)
		.trigger(t -> t
			.schedule(sc -> sc
				.interval(in -> in
					.time("10s")
				)
			)
		)
	)
);
""","""client.watcher().getSettings(g -> g);
""","""client.watcher().getWatch(g -> g
	.id("my_watch")
);
""","""client.watcher().putWatch(p -> p
	.actions("email_admin", a -> a
		.email(e -> e
			.subject("404 recently encountered")
			.to("admin@domain.host.com")
		)
	)
	.condition(c -> c
		.compare(NamedValue.of("ctx.payload.hits.total",Pair.of(ConditionOp.Gt,FieldValue.of(0))))
	)
	.id("my-watch")
	.input(i -> i
		.search(s -> s
			.request(r -> r
				.body(b -> b
					.query(q -> q
						.bool(bo -> bo
							.filter(f -> f
								.range(ra -> ra
									.untyped(u -> u
										.field("@timestamp")
									)
								)
							)
							.must(m -> m
								.match(ma -> ma
									.field("response")
									.query(FieldValue.of(404))
								)
							)
						)
					)
				)
				.indices("logstash*")
			)
		)
	)
	.trigger(t -> t
		.schedule(sc -> sc
			.cron("0 0/1 * * * ?")
		)
	)
);
""","""client.watcher().queryWatches(q -> q);
""","""client.watcher().start(s -> s);
""","""client.watcher().stats(s -> s);
""","""client.watcher().stop(s -> s);
""","""client.watcher().updateSettings(u -> u
	.indexAutoExpandReplicas("0-4")
);
""","""client.xpack().info(i -> i);
""","""client.xpack().usage(u -> u);
""")
    }
}
