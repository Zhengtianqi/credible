package cn.edu.bjut.monitor;

import cn.edu.bjut.constant.Constants;
import cn.edu.bjut.entity.GcMetric;
import cn.edu.bjut.entity.MemoryMetric;
import cn.edu.bjut.utils.IdMakerUtil;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhengtianqi
 */
public class JvmStack {

    public static void printMemoryMetric() {
        MemoryMXBean memory = ManagementFactory.getMemoryMXBean();
        MemoryUsage headMemory = memory.getHeapMemoryUsage();
        MemoryUsage nonHeadMemory = memory.getNonHeapMemoryUsage();
        MemoryMetric memoryMetric = new MemoryMetric();
        memoryMetric.setId(IdMakerUtil.make32Id());
        memoryMetric.setInitHeapMemoryUsage(headMemory.getInit() / Constants.MB);
        memoryMetric.setMaxHeapMemoryUsage(headMemory.getMax() / Constants.MB);
        memoryMetric.setUsedHeapMemoryUsage(headMemory.getUsed() / Constants.MB);
        memoryMetric.setCommittedHeapMemoryUsage(headMemory.getCommitted() / Constants.MB);
        memoryMetric.setUsedHeapMemoryUsageRate((headMemory.getUsed() * 100 / headMemory.getCommitted()) + "%");
        memoryMetric.setInitNonHeapMemoryUsage(nonHeadMemory.getInit() / Constants.MB);
        memoryMetric.setMaxNonHeapMemoryUsage(nonHeadMemory.getMax() / Constants.MB);
        memoryMetric.setUsedNonHeapMemoryUsage(nonHeadMemory.getUsed() / Constants.MB);
        memoryMetric.setCommittedNonHeapMemoryUsage(nonHeadMemory.getCommitted() / Constants.MB);
        memoryMetric.setUsedNonHeapMemoryUsageRate((nonHeadMemory.getUsed() * 100 / nonHeadMemory.getCommitted()) + "%");
        System.out.println(memoryMetric.toString());
    }

    public static void printGcMetric() {
        List<GarbageCollectorMXBean> garbages = ManagementFactory.getGarbageCollectorMXBeans();
        LocalDateTime dateTime = LocalDateTime.now();
        for (GarbageCollectorMXBean garbage : garbages) {
            GcMetric gcMetric = new GcMetric();
            gcMetric.setId(IdMakerUtil.make32Id());
            gcMetric.setDescription(garbage.getName());
            gcMetric.setGarbageName(garbage.getName());
            gcMetric.setGarbageCount(garbage.getCollectionCount());
            gcMetric.setGarbageCollectionTime(garbage.getCollectionTime());
            gcMetric.setMemoryPoolNames(Arrays.asList(garbage.getMemoryPoolNames()));
            gcMetric.setDateTime(dateTime);
            System.out.println(gcMetric.toString());
        }
    }
}
