package com.simba.flume.source.query;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public class CustomImpalaQuery {
    @JsonProperty("query_id")
    private String queryId;
    @JsonProperty("statement")
    private String statement;
    @JsonProperty("query_type")
    private String queryType;
    @JsonProperty("query_state")
    private String queryState;
    @JsonProperty("start_time")
    private String startTime;
    @JsonProperty("end_time")
    private String endTime;
    @JsonProperty("rows_produced")
    private String rowsProduced;
    @JsonProperty("thread_cpu_time_percentage")
    private String threadCpuTimePercentage;
    @JsonProperty("thread_network_receive_wait_time")
    private String threadNetworkReceiveWaitTime;
    @JsonProperty("thread_cpu_time")
    private String threadCpuTime;
    @JsonProperty("hdfs_average_scan_range")
    private String hdfsAverageScanRange;
    @JsonProperty("bytes_streamed")
    private String bytesStreamed;
    @JsonProperty("hdfs_bytes_read_short_circuit")
    private String hdfsBytesReadShortCircuit;
    @JsonProperty("hdfs_bytes_read_from_cache")
    private String hdfsBytesReadFromCache;
    @JsonProperty("hdfs_bytes_read")
    private String hdfsBytesRead;
    @JsonProperty("query_status")
    private String queryStatus;
    @JsonProperty("hdfs_scanner_average_bytes_read_per_second")
    private String hdfsScannerAverageBytesReadPerSecond;
    @JsonProperty("thread_network_receive_wait_time_percentage")
    private String threadNetworkReceiveWaitTimePercentage;
    @JsonProperty("oom")
    private String oom;
    @JsonProperty("planning_wait_time_percentage")
    private String planningWaitTimePercentage;
    @JsonProperty("admission_wait")
    private String admissionWait;
    @JsonProperty("connected_user")
    private String connectedUser;
    @JsonProperty("stats_missing")
    private String statsMissing;
    @JsonProperty("planning_wait_time")
    private String planningWaitTime;
    @JsonProperty("memory_aggregate_peak")
    private String memoryAggregatePeak;
    @JsonProperty("client_fetch_wait_time_percentage")
    private String clientFetchWaitTimePercentage;
    @JsonProperty("memory_per_node_peak_node")
    private String memoryPerNodePeakNode;
    @JsonProperty("session_type")
    private String sessionType;
    @JsonProperty("hdfs_bytes_read_remote")
    private String hdfsBytesReadRemote;
    @JsonProperty("estimated_per_node_peak_memory")
    private String estimatedPerNodePeakMemory;
    @JsonProperty("hdfs_bytes_read_local_percentage")
    private String hdfsBytesReadLocalPercentage;
    @JsonProperty("hdfs_bytes_read_from_cache_percentage")
    private String hdfsBytesReadFromCachePercentage;
    @JsonProperty("client_fetch_wait_time")
    private String clientFetchWaitTime;
    @JsonProperty("file_formats")
    private String fileFormats;
    @JsonProperty("admission_result")
    private String admissionResult;
    @JsonProperty("pool")
    private String pool;
    @JsonProperty("original_user")
    private String originalUser;
    @JsonProperty("session_id")
    private String sessionId;
    @JsonProperty("hdfs_bytes_read_remote_percentage")
    private String hdfsBytesReadRemotePercentage;
    @JsonProperty("stats_corrupt")
    private String statsCorrupt;
    @JsonProperty("hdfs_bytes_read_short_circuit_percentage")
    private String hdfsBytesReadShortCircuitPercentage;
    @JsonProperty("memory_accrual")
    private String memoryAccrual;
    @JsonProperty("thread_total_time")
    private String threadTotalTime;
    @JsonProperty("thread_network_send_wait_time_percentage")
    private String threadNetworkSendWaitTimePercentage;
    @JsonProperty("impala_version")
    private String impalaVersion;
    @JsonProperty("network_address")
    private String networkAddress;
    @JsonProperty("thread_storage_wait_time_percentage")
    private String threadStorageWaitTimePercentage;
    @JsonProperty("hdfs_bytes_read_local")
    private String hdfsBytesReadLocal;
    @JsonProperty("memory_per_node_peak")
    private String memoryPerNodePeak;
    @JsonProperty("thread_network_send_wait_time")
    private String threadNetworkSendWaitTime;
    @JsonProperty("thread_storage_wait_time")
    private String threadStorageWaitTime;
    @JsonProperty("user")
    private String user;
    @JsonProperty("coordinator")
    private String coordinator;
    @JsonProperty("details_available")
    private String detailsAvailable;
    @JsonProperty("database")
    private String database;
    @JsonProperty("duration_millis")
    private String durationMillis;
    @JsonProperty("details")
    private String details;

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getQueryState() {
        return queryState;
    }

    public void setQueryState(String queryState) {
        this.queryState = queryState;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRowsProduced() {
        return rowsProduced;
    }

    public void setRowsProduced(String rowsProduced) {
        this.rowsProduced = rowsProduced;
    }

    public String getThreadCpuTimePercentage() {
        return threadCpuTimePercentage;
    }

    public void setThreadCpuTimePercentage(String threadCpuTimePercentage) {
        this.threadCpuTimePercentage = threadCpuTimePercentage;
    }

    public String getThreadNetworkReceiveWaitTime() {
        return threadNetworkReceiveWaitTime;
    }

    public void setThreadNetworkReceiveWaitTime(String threadNetworkReceiveWaitTime) {
        this.threadNetworkReceiveWaitTime = threadNetworkReceiveWaitTime;
    }

    public String getThreadCpuTime() {
        return threadCpuTime;
    }

    public void setThreadCpuTime(String threadCpuTime) {
        this.threadCpuTime = threadCpuTime;
    }

    public String getHdfsAverageScanRange() {
        return hdfsAverageScanRange;
    }

    public void setHdfsAverageScanRange(String hdfsAverageScanRange) {
        this.hdfsAverageScanRange = hdfsAverageScanRange;
    }

    public String getBytesStreamed() {
        return bytesStreamed;
    }

    public void setBytesStreamed(String bytesStreamed) {
        this.bytesStreamed = bytesStreamed;
    }

    public String getHdfsBytesReadShortCircuit() {
        return hdfsBytesReadShortCircuit;
    }

    public void setHdfsBytesReadShortCircuit(String hdfsBytesReadShortCircuit) {
        this.hdfsBytesReadShortCircuit = hdfsBytesReadShortCircuit;
    }

    public String getHdfsBytesReadFromCache() {
        return hdfsBytesReadFromCache;
    }

    public void setHdfsBytesReadFromCache(String hdfsBytesReadFromCache) {
        this.hdfsBytesReadFromCache = hdfsBytesReadFromCache;
    }

    public String getHdfsBytesRead() {
        return hdfsBytesRead;
    }

    public void setHdfsBytesRead(String hdfsBytesRead) {
        this.hdfsBytesRead = hdfsBytesRead;
    }

    public String getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(String queryStatus) {
        this.queryStatus = queryStatus;
    }

    public String getHdfsScannerAverageBytesReadPerSecond() {
        return hdfsScannerAverageBytesReadPerSecond;
    }

    public void setHdfsScannerAverageBytesReadPerSecond(String hdfsScannerAverageBytesReadPerSecond) {
        this.hdfsScannerAverageBytesReadPerSecond = hdfsScannerAverageBytesReadPerSecond;
    }

    public String getThreadNetworkReceiveWaitTimePercentage() {
        return threadNetworkReceiveWaitTimePercentage;
    }

    public void setThreadNetworkReceiveWaitTimePercentage(String threadNetworkReceiveWaitTimePercentage) {
        this.threadNetworkReceiveWaitTimePercentage = threadNetworkReceiveWaitTimePercentage;
    }

    public String getOom() {
        return oom;
    }

    public void setOom(String oom) {
        this.oom = oom;
    }

    public String getPlanningWaitTimePercentage() {
        return planningWaitTimePercentage;
    }

    public void setPlanningWaitTimePercentage(String planningWaitTimePercentage) {
        this.planningWaitTimePercentage = planningWaitTimePercentage;
    }

    public String getAdmissionWait() {
        return admissionWait;
    }

    public void setAdmissionWait(String admissionWait) {
        this.admissionWait = admissionWait;
    }

    public String getConnectedUser() {
        return connectedUser;
    }

    public void setConnectedUser(String connectedUser) {
        this.connectedUser = connectedUser;
    }

    public String getStatsMissing() {
        return statsMissing;
    }

    public void setStatsMissing(String statsMissing) {
        this.statsMissing = statsMissing;
    }

    public String getPlanningWaitTime() {
        return planningWaitTime;
    }

    public void setPlanningWaitTime(String planningWaitTime) {
        this.planningWaitTime = planningWaitTime;
    }

    public String getMemoryAggregatePeak() {
        return memoryAggregatePeak;
    }

    public void setMemoryAggregatePeak(String memoryAggregatePeak) {
        this.memoryAggregatePeak = memoryAggregatePeak;
    }

    public String getClientFetchWaitTimePercentage() {
        return clientFetchWaitTimePercentage;
    }

    public void setClientFetchWaitTimePercentage(String clientFetchWaitTimePercentage) {
        this.clientFetchWaitTimePercentage = clientFetchWaitTimePercentage;
    }

    public String getMemoryPerNodePeakNode() {
        return memoryPerNodePeakNode;
    }

    public void setMemoryPerNodePeakNode(String memoryPerNodePeakNode) {
        this.memoryPerNodePeakNode = memoryPerNodePeakNode;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public String getHdfsBytesReadRemote() {
        return hdfsBytesReadRemote;
    }

    public void setHdfsBytesReadRemote(String hdfsBytesReadRemote) {
        this.hdfsBytesReadRemote = hdfsBytesReadRemote;
    }

    public String getEstimatedPerNodePeakMemory() {
        return estimatedPerNodePeakMemory;
    }

    public void setEstimatedPerNodePeakMemory(String estimatedPerNodePeakMemory) {
        this.estimatedPerNodePeakMemory = estimatedPerNodePeakMemory;
    }

    public String getHdfsBytesReadLocalPercentage() {
        return hdfsBytesReadLocalPercentage;
    }

    public void setHdfsBytesReadLocalPercentage(String hdfsBytesReadLocalPercentage) {
        this.hdfsBytesReadLocalPercentage = hdfsBytesReadLocalPercentage;
    }

    public String getHdfsBytesReadFromCachePercentage() {
        return hdfsBytesReadFromCachePercentage;
    }

    public void setHdfsBytesReadFromCachePercentage(String hdfsBytesReadFromCachePercentage) {
        this.hdfsBytesReadFromCachePercentage = hdfsBytesReadFromCachePercentage;
    }

    public String getClientFetchWaitTime() {
        return clientFetchWaitTime;
    }

    public void setClientFetchWaitTime(String clientFetchWaitTime) {
        this.clientFetchWaitTime = clientFetchWaitTime;
    }

    public String getFileFormats() {
        return fileFormats;
    }

    public void setFileFormats(String fileFormats) {
        this.fileFormats = fileFormats;
    }

    public String getAdmissionResult() {
        return admissionResult;
    }

    public void setAdmissionResult(String admissionResult) {
        this.admissionResult = admissionResult;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getOriginalUser() {
        return originalUser;
    }

    public void setOriginalUser(String originalUser) {
        this.originalUser = originalUser;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getHdfsBytesReadRemotePercentage() {
        return hdfsBytesReadRemotePercentage;
    }

    public void setHdfsBytesReadRemotePercentage(String hdfsBytesReadRemotePercentage) {
        this.hdfsBytesReadRemotePercentage = hdfsBytesReadRemotePercentage;
    }

    public String getStatsCorrupt() {
        return statsCorrupt;
    }

    public void setStatsCorrupt(String statsCorrupt) {
        this.statsCorrupt = statsCorrupt;
    }

    public String getHdfsBytesReadShortCircuitPercentage() {
        return hdfsBytesReadShortCircuitPercentage;
    }

    public void setHdfsBytesReadShortCircuitPercentage(String hdfsBytesReadShortCircuitPercentage) {
        this.hdfsBytesReadShortCircuitPercentage = hdfsBytesReadShortCircuitPercentage;
    }

    public String getMemoryAccrual() {
        return memoryAccrual;
    }

    public void setMemoryAccrual(String memoryAccrual) {
        this.memoryAccrual = memoryAccrual;
    }

    public String getThreadTotalTime() {
        return threadTotalTime;
    }

    public void setThreadTotalTime(String threadTotalTime) {
        this.threadTotalTime = threadTotalTime;
    }

    public String getThreadNetworkSendWaitTimePercentage() {
        return threadNetworkSendWaitTimePercentage;
    }

    public void setThreadNetworkSendWaitTimePercentage(String threadNetworkSendWaitTimePercentage) {
        this.threadNetworkSendWaitTimePercentage = threadNetworkSendWaitTimePercentage;
    }

    public String getImpalaVersion() {
        return impalaVersion;
    }

    public void setImpalaVersion(String impalaVersion) {
        this.impalaVersion = impalaVersion;
    }

    public String getNetworkAddress() {
        return networkAddress;
    }

    public void setNetworkAddress(String networkAddress) {
        this.networkAddress = networkAddress;
    }

    public String getThreadStorageWaitTimePercentage() {
        return threadStorageWaitTimePercentage;
    }

    public void setThreadStorageWaitTimePercentage(String threadStorageWaitTimePercentage) {
        this.threadStorageWaitTimePercentage = threadStorageWaitTimePercentage;
    }

    public String getHdfsBytesReadLocal() {
        return hdfsBytesReadLocal;
    }

    public void setHdfsBytesReadLocal(String hdfsBytesReadLocal) {
        this.hdfsBytesReadLocal = hdfsBytesReadLocal;
    }

    public String getMemoryPerNodePeak() {
        return memoryPerNodePeak;
    }

    public void setMemoryPerNodePeak(String memoryPerNodePeak) {
        this.memoryPerNodePeak = memoryPerNodePeak;
    }

    public String getThreadNetworkSendWaitTime() {
        return threadNetworkSendWaitTime;
    }

    public void setThreadNetworkSendWaitTime(String threadNetworkSendWaitTime) {
        this.threadNetworkSendWaitTime = threadNetworkSendWaitTime;
    }

    public String getThreadStorageWaitTime() {
        return threadStorageWaitTime;
    }

    public void setThreadStorageWaitTime(String threadStorageWaitTime) {
        this.threadStorageWaitTime = threadStorageWaitTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public String getDetailsAvailable() {
        return detailsAvailable;
    }

    public void setDetailsAvailable(String detailsAvailable) {
        this.detailsAvailable = detailsAvailable;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(String durationMillis) {
        this.durationMillis = durationMillis;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
