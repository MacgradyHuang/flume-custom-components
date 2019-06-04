package com.simba.flume.source.query;

public class CustomImpalaQuery {
    private String queryId;
    private String statement;
    private String queryType;
    private String queryState;
    private String startTime;
    private String endTime;
    private String rowsProduced;
    private String threadCpuTimePercentage;
    private String threadNetworkReceiveWaitTime;
    private String threadCpuTime;
    private String hdfsAverageScanRange;
    private String bytesStreamed;
    private String hdfsBytesReadShortCircuit;
    private String hdfsBytesReadFromCache;
    private String hdfsBytesRead;
    private String queryStatus;
    private String hdfsScannerAverageBytesReadPerSecond;
    private String threadNetworkReceiveWaitTimePercentage;
    private String oom;
    private String planningWaitTimePercentage;
    private String admissionWait;
    private String connectedUser;
    private String statsMissing;
    private String planningWaitTime;
    private String memoryAggregatePeak;
    private String clientFetchWaitTimePercentage;
    private String memoryPerNodePeakNode;
    private String sessionType;
    private String hdfsBytesReadRemote;
    private String estimatedPerNodePeakMemory;
    private String hdfsBytesReadLocalPercentage;
    private String hdfsBytesReadFromCachePercentage;
    private String clientFetchWaitTime;
    private String fileFormats;
    private String admissionResult;
    private String pool;
    private String originalUser;
    private String sessionId;
    private String hdfsBytesReadRemotePercentage;
    private String statsCorrupt;
    private String hdfsBytesReadShortCircuitPercentage;
    private String memoryAccrual;
    private String threadTotalTime;
    private String threadNetworkSendWaitTimePercentage;
    private String impalaVersion;
    private String networkAddress;
    private String threadStorageWaitTimePercentage;
    private String hdfsBytesReadLocal;
    private String memoryPerNodePeak;
    private String threadNetworkSendWaitTime;
    private String threadStorageWaitTime;
    private String user;
    private String coordinator;
    private String detailsAvailable;
    private String database;
    private String durationMillis;
    private String details;

    public CustomImpalaQuery() {

    }

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

    @Override
    public String toString() {
        return "{" +
                "queryId='" + queryId + '\'' +
                ", statement='" + statement + '\'' +
                ", queryType='" + queryType + '\'' +
                ", queryState='" + queryState + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", rowsProduced='" + rowsProduced + '\'' +
                ", threadCpuTimePercentage='" + threadCpuTimePercentage + '\'' +
                ", threadNetworkReceiveWaitTime='" + threadNetworkReceiveWaitTime + '\'' +
                ", threadCpuTime='" + threadCpuTime + '\'' +
                ", hdfsAverageScanRange='" + hdfsAverageScanRange + '\'' +
                ", bytesStreamed='" + bytesStreamed + '\'' +
                ", hdfsBytesReadShortCircuit='" + hdfsBytesReadShortCircuit + '\'' +
                ", hdfsBytesReadFromCache='" + hdfsBytesReadFromCache + '\'' +
                ", hdfsBytesRead='" + hdfsBytesRead + '\'' +
                ", queryStatus='" + queryStatus + '\'' +
                ", hdfsScannerAverageBytesReadPerSecond='" + hdfsScannerAverageBytesReadPerSecond + '\'' +
                ", threadNetworkReceiveWaitTimePercentage='" + threadNetworkReceiveWaitTimePercentage + '\'' +
                ", oom='" + oom + '\'' +
                ", planningWaitTimePercentage='" + planningWaitTimePercentage + '\'' +
                ", admissionWait='" + admissionWait + '\'' +
                ", connectedUser='" + connectedUser + '\'' +
                ", statsMissing='" + statsMissing + '\'' +
                ", planningWaitTime='" + planningWaitTime + '\'' +
                ", memoryAggregatePeak='" + memoryAggregatePeak + '\'' +
                ", clientFetchWaitTimePercentage='" + clientFetchWaitTimePercentage + '\'' +
                ", memoryPerNodePeakNode='" + memoryPerNodePeakNode + '\'' +
                ", sessionType='" + sessionType + '\'' +
                ", hdfsBytesReadRemote='" + hdfsBytesReadRemote + '\'' +
                ", estimatedPerNodePeakMemory='" + estimatedPerNodePeakMemory + '\'' +
                ", hdfsBytesReadLocalPercentage='" + hdfsBytesReadLocalPercentage + '\'' +
                ", hdfsBytesReadFromCachePercentage='" + hdfsBytesReadFromCachePercentage + '\'' +
                ", clientFetchWaitTime='" + clientFetchWaitTime + '\'' +
                ", fileFormats='" + fileFormats + '\'' +
                ", admissionResult='" + admissionResult + '\'' +
                ", pool='" + pool + '\'' +
                ", originalUser='" + originalUser + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", hdfsBytesReadRemotePercentage='" + hdfsBytesReadRemotePercentage + '\'' +
                ", statsCorrupt='" + statsCorrupt + '\'' +
                ", hdfsBytesReadShortCircuitPercentage='" + hdfsBytesReadShortCircuitPercentage + '\'' +
                ", memoryAccrual='" + memoryAccrual + '\'' +
                ", threadTotalTime='" + threadTotalTime + '\'' +
                ", threadNetworkSendWaitTimePercentage='" + threadNetworkSendWaitTimePercentage + '\'' +
                ", impalaVersion='" + impalaVersion + '\'' +
                ", networkAddress='" + networkAddress + '\'' +
                ", threadStorageWaitTimePercentage='" + threadStorageWaitTimePercentage + '\'' +
                ", hdfsBytesReadLocal='" + hdfsBytesReadLocal + '\'' +
                ", memoryPerNodePeak='" + memoryPerNodePeak + '\'' +
                ", threadNetworkSendWaitTime='" + threadNetworkSendWaitTime + '\'' +
                ", threadStorageWaitTime='" + threadStorageWaitTime + '\'' +
                ", user='" + user + '\'' +
                ", coordinator='" + coordinator + '\'' +
                ", detailsAvailable='" + detailsAvailable + '\'' +
                ", database='" + database + '\'' +
                ", durationMillis='" + durationMillis + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
