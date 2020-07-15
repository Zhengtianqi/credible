package cn.edu.bjut.metric.support;

import cn.edu.bjut.constant.MetricsConstant;
import com.jezhumble.javasysmon.CpuTimes;
import com.jezhumble.javasysmon.JavaSysMon;
import com.sun.management.OperatingSystemMXBean;

import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * APP收集信息类，收集整体运行环境和方法级别信息
 *
 * @author zhengtianqi
 * @date 2019/9/1
 */
public class AppCollectInfo implements Serializable {

    private static final long serialVersionUID = -7535758111291127412L;

    private static OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    private static RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

    private static JavaSysMon monitor = new JavaSysMon();


    private AppCollectInfo() {
    }

    private static class SingletonHolder {
        public static final AppCollectInfo INSTANCE = new AppCollectInfo();

    }

    public static AppCollectInfo getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 系统负载
     *
     * @return 如果是-1
     */
    public double getSystemLoadAverage() {
        return operatingSystemMXBean.getSystemLoadAverage();
    }

    /**
     * 启动时间
     *
     * @return 格式化后的时间
     */
    public String getStartTime() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(runtimeMXBean.getStartTime()), ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern(MetricsConstant.DATE_FORMAT));
    }

    /**
     * 正常运行时长
     *
     * @return 总时长
     */
    public long getRunTime() {
        return runtimeMXBean.getUptime();
    }

    /**
     *
     * @return 平均吞吐量（1分钟）

    public long getAvgThroughput() {
    return 0L;
    }
     */

    /**
     *
     * 请使用以下公式来确定 Tresponse 的值，即峰值负载时的响应时间 （以秒为单位）：
     * Tresponse = n/r - Tthink
     * n 是并发用户数
     * r 是服务器每秒收到的请求数
     * Tthink 是平均延迟时间（以秒为单位）
     * 要获得准确的响应时间结果，应始终在等式中使用延迟时间。
     *
     * @return 平均响应时间
     *

    public long getAvgResponseTime() {
    return 0L;
    }
     */

    /**
     * @return 当前已经使用的内存量（M）
     */
    public long getMemoryUsed() {
        return (monitor.physical().getTotalBytes() - monitor.physical().getFreeBytes()) / 1024 / 1024;
    }

    /**
     * @return 当前CPU使用率%
     */
    public double getCpuUsage() {
        CpuTimes cpuTimes = monitor.cpuTimes();
        long totalTime = cpuTimes.getTotalMillis();
        long idleTime = cpuTimes.getIdleMillis();
        /**
         * 空闲
         * double idlPer = ((double) idleTime / (double) totalTime) * 100;
         **/
        //已使用
        double cupPer = (1 - ((double) idleTime / (double) totalTime)) * 100;

        BigDecimal bg = BigDecimal.valueOf(cupPer).setScale(2, RoundingMode.UP);
        /**
         * 每个CPU已使用
         * double cupPer2 = (1 - ((double) idleTime / (double) totalTime)) / monitor.numCpus() * 100;
         **/
        return bg.doubleValue();
    }

}
