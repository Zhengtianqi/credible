package cn.edu.bjut.metric.support;

import cn.edu.bjut.constant.MetricsConstant;

import java.io.Serializable;
import java.lang.management.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.State.*;

/**
 * JVM收集信息类，收集内存和线程相关信息
 *
 * @author zhengtianqi
 * @date 2019/9/1
 */
public class JvmCollectInfo implements Serializable {

    private static final long serialVersionUID = 4698284427071076764L;

    private static MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

    private static ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    private JvmCollectInfo() {
    }

    private static class SingletonHolder {
        public static final JvmCollectInfo INSTANCE = new JvmCollectInfo();
    }

    public static JvmCollectInfo getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * @return 堆内存使用情况
     */
    public MemoryUsage getHeapMemoryUsage() {
        return memoryMXBean.getHeapMemoryUsage();
    }

    /**
     * @return 非堆内存使用情况
     */
    public MemoryUsage getNonHeapMemoryUsage() {
        return memoryMXBean.getNonHeapMemoryUsage();
    }

    /**
     * @return 用于内存管理的初始堆内内存容量（MB）
     */
    public long getHeapInit() {
        return getHeapMemoryUsage().getInit() / 1024 / 1024;
    }

    /**
     * @return 用于当前已经使用的堆内内存量（MB）
     */
    public long getHeapUsed() {
        return getHeapMemoryUsage().getUsed() / 1024 / 1024;
    }

    /**
     * @return 用于内存管理的最大堆内内存量（MB）
     */
    public long getHeapMax() {
        return getHeapMemoryUsage().getMax() / 1024 / 1024;
    }

    /**
     * @return 提交的堆内存存量（MB）
     */
    public long getHeapCommited() {
        return getHeapMemoryUsage().getCommitted() / 1024 / 1024;
    }

    /**
     * @return 用于内存管理的初始非堆内内存容量（MB）
     */
    public long getNonHeapInit() {
        return getNonHeapMemoryUsage().getInit() / 1024 / 1024;
    }

    /**
     * @return 当前已经使用的非堆内内存量（MB）
     */
    public long getNonHeapUsed() {
        return getNonHeapMemoryUsage().getUsed() / 1024 / 1024;
    }

    /**
     * @return 用于内存管理的最大非堆内内存量（MB）
     */
    public long getNonHeapMax() {
        return getNonHeapMemoryUsage().getMax() / 1024 / 1024;
    }

    /**
     * @return 提交的非堆内存存量（MB）
     */
    public long getNonHeapCommited() {
        return getNonHeapMemoryUsage().getCommitted() / 1024 / 1024;
    }

    /**
     * @return 空闲内存量（MB）
     */
    public long getFreeMemory() {
        return Runtime.getRuntime().freeMemory() / 1024 / 1024;
    }

    /**
     * @return JVM启动以来启动过的线程数
     */
    public long getTotalStartedThreadCount() {
        return threadMXBean.getTotalStartedThreadCount();
    }

    /**
     * @return 当前存活线程数，包括守护线程和非守护线程
     */
    public long getActiveThreadCount() {
        return threadMXBean.getThreadCount();
    }

    /**
     * @return 当前存活的守护线程数
     */
    public int getDaemonThreadCount() {
        return threadMXBean.getDaemonThreadCount();
    }

    /**
     * @return JVM启动或峰值重置以来峰值活动线程计数
     */
    public int getPeakThreadCount() {
        return threadMXBean.getPeakThreadCount();
    }

    /**
     * @return 各种状态的线程数量集合
     */
    public Map<String, Integer> getThreadCount4State() {
        int threadsNew = 0;
        int threadsRunnable = 0;
        int threadsBlocked = 0;
        int threadsWaiting = 0;
        int threadsTimedWaiting = 0;
        int threadsTerminated = 0;
        Map<String, Integer> threadCountMap = new HashMap<>(16);
        long[] threadIds = threadMXBean.getAllThreadIds();
        ThreadInfo[] threadInfoArr = threadMXBean.getThreadInfo(threadIds, 0);
        for (int i = 0; i < threadInfoArr.length; i++) {
            ThreadInfo threadInfo = threadInfoArr[i];
            if (threadInfo == null) {
                continue;
            }
            Thread.State state = threadInfo.getThreadState();
            if (state == NEW) {
                threadsNew++;
                threadCountMap.put(MetricsConstant.THREAD_NEW, threadsNew);
            } else if (state == RUNNABLE) {
                threadsRunnable++;
                threadCountMap.put(MetricsConstant.THREAD_RUNNABLE, threadsRunnable);
            } else if (state == BLOCKED) {
                threadsBlocked++;
                threadCountMap.put(MetricsConstant.THREAD_BLOCKED, threadsBlocked);
            } else if (state == WAITING) {
                threadsWaiting++;
                threadCountMap.put(MetricsConstant.THREAD_WAITING, threadsWaiting);
            } else if (state == TIMED_WAITING) {
                threadsTimedWaiting++;
                threadCountMap.put(MetricsConstant.THREAD_TIMED_WAITING, threadsTimedWaiting);
            } else if (state == TERMINATED) {
                threadsTerminated++;
                threadCountMap.put(MetricsConstant.THREAD_TERMINATED, threadsTerminated);
            }
        }
        return threadCountMap;
    }

}
