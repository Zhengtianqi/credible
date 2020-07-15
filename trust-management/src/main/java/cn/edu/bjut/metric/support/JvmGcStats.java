package cn.edu.bjut.metric.support;

import javafx.util.Pair;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.HashSet;
import java.util.Set;

/**
 * JVM GC情况统计类(仅支持HotSpot及JRockit)
 *
 * @author zhengtianqi
 * @date 2019/9/1
 */
public final class JvmGcStats {
    /**
     * young gc收集器名称
     */
    private static final Set<String> YOUNG_GEN_COLLECTOR = new HashSet<>();
    /**
     * old gc收集器名称
     */
    private static final Set<String> OLD_GEN_COLLECTOR = new HashSet<>();

    static {
        // Oracle (Sun) HotSpot
        // -XX:+UseSerialGC
        YOUNG_GEN_COLLECTOR.add("Copy");
        // -XX:+UseParNewGC
        YOUNG_GEN_COLLECTOR.add("ParNew");
        // -XX:+UseParallelGC
        YOUNG_GEN_COLLECTOR.add("PS Scavenge");

        // Oracle (BEA) JRockit
        // -XgcPrio:pausetime
        YOUNG_GEN_COLLECTOR.add("Garbage collection optimized for short pausetimes Young Collector");
        // -XgcPrio:throughput
        YOUNG_GEN_COLLECTOR.add("Garbage collection optimized for throughput Young Collector");
        // -XgcPrio:deterministic
        YOUNG_GEN_COLLECTOR.add("Garbage collection optimized for deterministic pausetimes Young Collector");

        // Oracle (Sun) HotSpot
        // -XX:+UseSerialGC
        OLD_GEN_COLLECTOR.add("MarkSweepCompact");
        // -XX:+UseParallelGC and (-XX:+UseParallelOldGC or -XX:+UseParallelOldGCCompacting)
        OLD_GEN_COLLECTOR.add("PS MarkSweep");
        // -XX:+UseConcMarkSweepGC
        OLD_GEN_COLLECTOR.add("ConcurrentMarkSweep");

        // Oracle (BEA) JRockit
        // -XgcPrio:pausetime
        OLD_GEN_COLLECTOR.add("Garbage collection optimized for short pausetimes Old Collector");
        // -XgcPrio:throughput
        OLD_GEN_COLLECTOR.add("Garbage collection optimized for throughput Old Collector");
        // -XgcPrio:deterministic
        OLD_GEN_COLLECTOR.add("Garbage collection optimized for deterministic pausetimes Old Collector");
    }

    private JvmGcStats() {
    }

    public static Pair<Long, Long> getYoungGcCount() {
        long youngGcCount = 0;
        long youngGcTime = 0;
        for (GarbageCollectorMXBean gc : ManagementFactory.getGarbageCollectorMXBeans()) {
            long count = gc.getCollectionCount();
            long time = gc.getCollectionTime();
            String name = gc.getName();
            if (YOUNG_GEN_COLLECTOR.contains(name)) {
                youngGcCount += count;
                youngGcTime += time;
            }
        }
        return new Pair<>(youngGcCount, youngGcTime);
    }

    public static Pair<Long, Long> getOldGenGcCount() {
        long fullGcCount = 0;
        long fullGcTime = 0;
        for (GarbageCollectorMXBean gc : ManagementFactory.getGarbageCollectorMXBeans()) {
            long count = gc.getCollectionCount();
            long time = gc.getCollectionTime();
            String name = gc.getName();
            if (OLD_GEN_COLLECTOR.contains(name) && count > 0) {
                fullGcCount += count;
                fullGcTime += time;
            }
        }
        return new Pair<>(fullGcCount, fullGcTime);
    }
}
