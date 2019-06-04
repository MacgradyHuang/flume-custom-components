package com.simba.flume.source.query;

import com.cloudera.api.ApiRootResource;
import com.cloudera.api.ClouderaManagerClientBuilder;
import com.cloudera.api.model.ApiImpalaQuery;
import com.cloudera.api.model.ApiImpalaQueryDetailsResponse;
import com.cloudera.api.model.ApiImpalaQueryResponse;
import com.cloudera.api.v4.ImpalaQueriesResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.flume.ChannelException;
import org.apache.flume.Context;
import org.apache.flume.EventDrivenSource;
import org.apache.flume.conf.Configurable;
import org.apache.flume.event.EventBuilder;
import org.apache.flume.source.AbstractSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.simba.flume.source.query.Constants.*;

public class ClouderaManagerImpalaQuerySource extends AbstractSource implements Configurable, EventDrivenSource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ClouderaManagerImpalaQuerySource.class);
    private AtomicBoolean threadShouldStop;
    private Thread thread;
    private ScheduledExecutorService handlerService;

    private String cmHost;
    private Integer cmPort;
    private Boolean cmEnableTLS;
    private String cmUsername;
    private String cmPassword;
    private String cmClusterName;
    private String cmServiceName;

    public String getCmHost() {
        return cmHost;
    }

    public Integer getCmPort() {
        return cmPort;
    }

    public Boolean getCmEnableTLS() {
        return cmEnableTLS;
    }

    public String getCmUsername() {
        return cmUsername;
    }

    public String getCmPassword() {
        return cmPassword;
    }

    public String getCmClusterName() {
        return cmClusterName;
    }

    public String getCmServiceName() {
        return cmServiceName;
    }

    public ClouderaManagerImpalaQuerySource() {
        super();

        this.threadShouldStop = new AtomicBoolean(false);
    }

    @Override
    public void configure(Context context) {
        this.cmHost = context.getString("cmHost");
        Preconditions.checkState(this.cmHost != null, "The parameter cmHost must be specified");

        this.cmPort = context.getInteger("cmPort", 80);
        this.cmEnableTLS = context.getBoolean("cmEnableTLS", false);
        this.cmUsername = context.getString("cmUsername", "");
        this.cmPassword = context.getString("cmPassword", "");
        this.cmClusterName = context.getString("cmClusterName", "cluster");
        this.cmServiceName = context.getString("cmServiceName", "impala");
    }

    @Override
    public synchronized void start() {
        LOGGER.info("Source starting");

        this.handlerService = Executors.newScheduledThreadPool(HANDLER_SERVICE_CORE_POOL_SIZE, (new ThreadFactoryBuilder()).setNameFormat("cm-query-source-handler-%d").build());
        ClouderaManagerImpalaQuerySource.TaskContext context = new ClouderaManagerImpalaQuerySource.TaskContext();
        this.threadShouldStop.set(false);
        context.handlerService = this.handlerService;
        context.source = this;
        this.thread = new Thread(context);
        this.thread.start();
        LOGGER.debug("Source started");

        super.start();
    }

    @Override
    public synchronized void stop() {
        LOGGER.info("Source stopping");

        this.threadShouldStop.set(true);
        if (this.thread != null) {
            LOGGER.debug("Handler thread stopping");

            while(this.thread.isAlive()) {
                try {
                    LOGGER.debug("Waiting for handler to finish");
                    this.thread.interrupt();
                    this.thread.join(500L);
                } catch (InterruptedException var4) {
                    LOGGER.debug("Interrupted while waiting for handler to finish");
                    Thread.currentThread().interrupt();
                }
            }

            LOGGER.debug("Handler thread stopped");
        }

        if (this.handlerService != null) {
            this.handlerService.shutdown();
            LOGGER.debug("Handler service stopping");

            try {
                this.handlerService.awaitTermination(500L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException var2) {
                LOGGER.debug("Interrupted while waiting for handler service to stop");
                Thread.currentThread().interrupt();
            }

            if (!this.handlerService.isShutdown()) {
                this.handlerService.shutdownNow();
            }

            LOGGER.debug("Handler service stopped");
        }

        LOGGER.debug("Source stopped");

        super.stop();
    }

    private static class CustomTaskHandler implements Runnable {
        private ClouderaManagerImpalaQuerySource source;
        private ImpalaQueriesResource queryReource;

        CustomTaskHandler(ClouderaManagerImpalaQuerySource source) {
            this.source = source;

            ApiRootResource rootResource;
            if (source.getCmEnableTLS()) {
                rootResource = new ClouderaManagerClientBuilder()
                        .withHost(source.getCmHost()).withPort(source.getCmPort())
                        .withUsernamePassword(source.getCmUsername(), source.getCmPassword())
                        .enableTLS()
                        .build();
            } else {
                rootResource = new ClouderaManagerClientBuilder()
                        .withHost(source.getCmHost()).withPort(source.getCmPort())
                        .withUsernamePassword(source.getCmUsername(), source.getCmPassword())
                        .build();
            }
            this.queryReource = rootResource
                    .getRootV17()
                    .getClustersResource()
                    .getServicesResource(source.getCmClusterName())
                    .getImpalaQueriesResource(source.getCmServiceName());
        }

        @Override
        public void run() {
            // do custom task handle
            try {
                // get query scope
                QueryScope scope = getQueryScope();

                ClouderaManagerImpalaQuerySource.LOGGER.info("Current query scope: " + SDF.format(toCCT(scope.getStartTime())) + " ~ " + SDF.format(toCCT(scope.getEndTime())));

                // get query summary and details
                processEvent(scope);
            } catch (ChannelException e) {
                ClouderaManagerImpalaQuerySource.LOGGER.debug("Channel exception", e);
            }
        }

        private QueryScope getQueryScope() {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            // set timezone
            calendar.add(Calendar.HOUR_OF_DAY, -TIME_DIFF);

            // get query start time
            Date dateTo = calendar.getTime();
            String strDateTo = SDF.format(dateTo);

            // get query end time, default to query one hour per scheduler
            calendar.add(Calendar.MINUTE, -MINUTES_PER_TASK);
            Date dateFrom = calendar.getTime();
            String strDateFrom = SDF.format(dateFrom);

            return new QueryScope(strDateFrom, strDateTo, dateFrom, dateTo);
        }

        private Date toCCT(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.HOUR_OF_DAY, +TIME_DIFF);
            return calendar.getTime();
        }

        private void processEvent(QueryScope scope) {
            Date start = new Date();

            int i = 0;
            Map<String, ApiImpalaQuery> querySummaryMap = new HashMap<>();
            // get query summary
            while (true) {
                ApiImpalaQueryResponse response = this.queryReource.getImpalaQueries(this.source.getCmServiceName(), "", scope.getStrStartTime(), scope.getStrEndTime(), QUERY_LIMIT, QUERY_LIMIT * i++);
                List<ApiImpalaQuery> queries = response.getQueries();
                if (queries.isEmpty()) {
                    break;
                }

                for (ApiImpalaQuery query : queries) {
                    querySummaryMap.put(query.getQueryId(), query);
                }
            }

            ClouderaManagerImpalaQuerySource.LOGGER.info("Query scope: " + SDF.format(toCCT(scope.getStartTime())) + " ~ " + SDF.format(toCCT(scope.getEndTime())) + ", Query summary numbers: " + querySummaryMap.size());

            // get query details
            Map<String, String> queryDetailsMap = new HashMap<>();
            for (String queryId : querySummaryMap.keySet()) {
                ApiImpalaQueryDetailsResponse response = this.queryReource.getQueryDetails(queryId, "text");
                queryDetailsMap.put(queryId, response.getDetails());
            }

            ClouderaManagerImpalaQuerySource.LOGGER.info("Query scope: " + SDF.format(toCCT(scope.getStartTime())) + " ~ " + SDF.format(toCCT(scope.getEndTime())) + ", Query details numbers: " + queryDetailsMap.size());

            CustomImpalaQuery query = new CustomImpalaQuery();
            Map<String, String> headers = new HashMap<>();
            ObjectMapper objectMapper = new ObjectMapper();
            for (String queryId : querySummaryMap.keySet()) {
                try {
                    ApiImpalaQuery summary = querySummaryMap.get(queryId);
                    query.setQueryId(summary.getQueryId());
                    query.setStatement(summary.getStatement());
                    query.setQueryType(summary.getQueryType());
                    query.setQueryState(summary.getQueryState());

                    Date startTime = summary.getStartTime();
                    query.setStartTime(startTime != null ? SDF.format(startTime) : "");
                    Date endTime = summary.getEndTime();
                    query.setEndTime(endTime != null ? SDF.format(endTime) : "");
                    Long rowsProduced = summary.getRowsProduced();
                    query.setRowsProduced(rowsProduced != null ? rowsProduced.toString() : "0");

                    Map<String, String> attributes = summary.getAttributes();
                    query.setThreadCpuTimePercentage(attributes.get("thread_cpu_time_percentage"));
                    query.setThreadNetworkReceiveWaitTime(attributes.get("thread_network_receive_wait_time"));
                    query.setThreadCpuTime(attributes.get("thread_cpu_time"));
                    query.setHdfsAverageScanRange(attributes.get("hdfs_average_scan_range"));
                    query.setBytesStreamed(attributes.get("bytes_streamed"));
                    query.setHdfsBytesReadShortCircuit(attributes.get("hdfs_bytes_read_short_circuit"));
                    query.setHdfsBytesReadFromCache(attributes.get("hdfs_bytes_read_from_cache"));
                    query.setHdfsBytesRead(attributes.get("hdfs_bytes_read"));
                    query.setQueryStatus(attributes.get("query_status"));
                    query.setHdfsScannerAverageBytesReadPerSecond(attributes.get("hdfs_scanner_average_bytes_read_per_second"));
                    query.setThreadNetworkReceiveWaitTimePercentage(attributes.get("thread_network_receive_wait_time_percentage"));
                    query.setOom(attributes.get("oom"));
                    query.setPlanningWaitTimePercentage(attributes.get("planning_wait_time_percentage"));
                    query.setAdmissionWait(attributes.get("admission_wait"));
                    query.setConnectedUser(attributes.get("connected_user"));
                    query.setStatsMissing(attributes.get("stats_missing"));
                    query.setPlanningWaitTime(attributes.get("planning_wait_time"));
                    query.setMemoryAggregatePeak(attributes.get("memory_aggregate_peak"));
                    query.setClientFetchWaitTimePercentage(attributes.get("client_fetch_wait_time_percentage"));
                    query.setMemoryPerNodePeakNode(attributes.get("memory_per_node_peak_node"));
                    query.setSessionType(attributes.get("session_type"));
                    query.setHdfsBytesReadRemote(attributes.get("hdfs_bytes_read_remote"));
                    query.setEstimatedPerNodePeakMemory(attributes.get("estimated_per_node_peak_memory"));
                    query.setHdfsBytesReadLocalPercentage(attributes.get("hdfs_bytes_read_local_percentage"));
                    query.setHdfsBytesReadFromCachePercentage(attributes.get("hdfs_bytes_read_from_cache_percentage"));
                    query.setClientFetchWaitTime(attributes.get("client_fetch_wait_time"));
                    query.setFileFormats(attributes.get("file_formats"));
                    query.setAdmissionResult(attributes.get("admission_result"));
                    query.setPool(attributes.get("pool"));
                    query.setOriginalUser(attributes.get("original_user"));
                    query.setSessionId(attributes.get("session_id"));
                    query.setHdfsBytesReadRemotePercentage(attributes.get("hdfs_bytes_read_remote_percentage"));
                    query.setStatsCorrupt(attributes.get("stats_corrupt"));
                    query.setHdfsBytesReadShortCircuitPercentage(attributes.get("hdfs_bytes_read_short_circuit_percentage"));
                    query.setMemoryAccrual(attributes.get("memory_accrual"));
                    query.setThreadTotalTime(attributes.get("thread_total_time"));
                    query.setThreadNetworkSendWaitTimePercentage(attributes.get("thread_network_send_wait_time_percentage"));
                    query.setImpalaVersion(attributes.get("impala_version"));
                    query.setNetworkAddress(attributes.get("network_address"));
                    query.setThreadStorageWaitTimePercentage(attributes.get("thread_storage_wait_time_percentage"));
                    query.setHdfsBytesReadLocal(attributes.get("hdfs_bytes_read_local"));
                    query.setMemoryPerNodePeak(attributes.get("memory_per_node_peak"));
                    query.setThreadNetworkSendWaitTime(attributes.get("thread_network_send_wait_time"));
                    query.setThreadStorageWaitTime(attributes.get("thread_storage_wait_time"));

                    query.setUser(summary.getUser());
                    query.setCoordinator(summary.getCoordinator().getHostId());
                    query.setDetailsAvailable("" + summary.getDetailsAvailable());
                    query.setDatabase(summary.getDatabase());
                    query.setDurationMillis("" + summary.getDurationMillis());
                    query.setDetails(queryDetailsMap.get(queryId));

                    headers.put("query_id", queryId);
                    headers.put("year", SDF_YEAR.format(startTime));
                    headers.put("month", SDF_MONTH.format(startTime));
                    headers.put("day", SDF_DAY.format(startTime));
                    this.source.getChannelProcessor().processEvent(EventBuilder.withBody(objectMapper.writeValueAsString(query), Charset.forName("UTF-8"), headers));
                } catch (Exception e) {
                    ClouderaManagerImpalaQuerySource.LOGGER.error("Transform [" + queryId + "] exception", e);
                }
            }
            Date end = new Date();

            ClouderaManagerImpalaQuerySource.LOGGER.info("Query scope: " + SDF.format(toCCT(scope.getStartTime())) + " ~ " + SDF.format(toCCT(scope.getEndTime())) + ", Spent " + (end.getTime() - start.getTime()) / 1000 + "s");
        }

        private static class QueryScope {
            private String strStartTime;
            private String strEndTime;
            private Date startTime;
            private Date endTime;

            QueryScope(String strStartTime, String strEndTime, Date startTime, Date endTime) {
                this.strStartTime = strStartTime;
                this.strEndTime = strEndTime;
                this.startTime = startTime;
                this.endTime = endTime;
            }

            public String getStrStartTime() {
                return strStartTime;
            }

            public String getStrEndTime() {
                return strEndTime;
            }

            public Date getStartTime() {
                return startTime;
            }

            public Date getEndTime() {
                return endTime;
            }
        }
    }

    private static class TaskContext implements Runnable {
        private ScheduledExecutorService handlerService;
        private ClouderaManagerImpalaQuerySource source;

        @Override
        public void run() {
            ClouderaManagerImpalaQuerySource.LOGGER.debug("Task context starting");

            try {
                handlerService.scheduleAtFixedRate(new CustomTaskHandler(source), SCHEDULE_INITIAL_DELAY, SCHEDULE_PERIOD, TimeUnit.MINUTES);
            } catch (Exception e) {
                ClouderaManagerImpalaQuerySource.LOGGER.error("Task context exception", e);
            }

            ClouderaManagerImpalaQuerySource.LOGGER.debug("Task context exiting");
        }
    }
}
