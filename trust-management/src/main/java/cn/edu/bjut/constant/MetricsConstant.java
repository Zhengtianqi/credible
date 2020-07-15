package cn.edu.bjut.constant;

/**
 * 应用收集指标常量类
 *
 * @author xiaokai@gooagoo.com
 * @version 2019-4-1
 */
public class MetricsConstant {
    public static final String THREAD_NEW = "threadsNew";
    public static final String THREAD_RUNNABLE = "threadsRunnable";
    public static final String THREAD_BLOCKED= "threadsBlocked";
    public static final String THREAD_WAITING = "threadsWaiting";
    public static final String THREAD_TIMED_WAITING = "threadsTimedWaiting";
    public static final String THREAD_TERMINATED = "threadsTerminated";

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final int MIN_BACKUP_POINTS_COUNT = 1;
    public static final int MAX_BACKUP_POINTS_COUNT = 8;

    public static final long MIN_TIME_SLICE = 1000L;

    public static final long MAX_TIME_SLICE = 10 * 60 * 1000L;

    public static final String JVM_THREAD_METRIC = "jvm_thread_metric";
    public static final String JVM_MEMORY_METRIC = "jvm_memory_metric";
    public static final String JVM_GC_METRIC = "jvm_gc_metric";
    public static final String APP_WHOLE_METRIC = "app_whole_metric";
    public static final String APP_METHOD_METRIC = "app_method_metric";

    public static final int SUCCESS = 0;

    private MetricsConstant() {}
}
