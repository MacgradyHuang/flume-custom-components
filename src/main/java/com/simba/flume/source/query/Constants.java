package com.simba.flume.source.query;

import java.text.SimpleDateFormat;

public class Constants {
    public static final Integer HANDLER_SERVICE_CORE_POOL_SIZE = 12;
    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    public static final SimpleDateFormat SDF_YEAR = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat SDF_MONTH = new SimpleDateFormat("yyyyMM");
    public static final SimpleDateFormat SDF_DAY = new SimpleDateFormat("yyyyMMdd");
    public static final Integer QUERY_LIMIT = 500;
    public static final Integer TIME_DIFF = 8;
    public static final Integer SCHEDULE_INITIAL_DELAY = 0;
    public static final Integer SCHEDULE_PERIOD = 60;
    public static final Integer MINUTES_PER_TASK = 60;

}
