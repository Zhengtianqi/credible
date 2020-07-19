package cn.edu.bjut.entity;

import cn.edu.bjut.constant.Constants;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhengtianqi
 */
public class GcMetric implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String description;

    /**
     * 垃圾收集器名称
     * PS Scavenge
     * PS MarkSweep
     */
    private String garbageName;
    /**
     * 已收集总数
     */
    private long garbageCount;
    /**
     * 大概的累计收集时间,毫秒
     */
    private long garbageCollectionTime;
    /**
     * 此内存管理器管理的内存池的名称
     */
    private List<String> memoryPoolNames;
    private LocalDateTime dateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGarbageName() {
        return garbageName;
    }

    public void setGarbageName(String garbageName) {
        this.garbageName = garbageName;
    }

    public long getGarbageCount() {
        return garbageCount;
    }

    public void setGarbageCount(long garbageCount) {
        this.garbageCount = garbageCount;
    }

    public long getGarbageCollectionTime() {
        return garbageCollectionTime;
    }

    public void setGarbageCollectionTime(long garbageCollectionTime) {
        this.garbageCollectionTime = garbageCollectionTime;
    }

    public List<String> getMemoryPoolNames() {
        return memoryPoolNames;
    }

    public void setMemoryPoolNames(List<String> memoryPoolNames) {
        this.memoryPoolNames = memoryPoolNames;
    }

    public String getDateTime() {
        return Constants.FORMAT.format(dateTime);
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "GcMetric{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", garbageName='" + garbageName + '\'' +
                ", garbageCount=" + garbageCount +
                ", garbageCollectionTime=" + garbageCollectionTime +
                ", memoryPoolNames=" + memoryPoolNames +
                ", dateTime=" + dateTime +
                '}';
    }
}
