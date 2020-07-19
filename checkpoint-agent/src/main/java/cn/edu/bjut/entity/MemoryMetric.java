package cn.edu.bjut.entity;

import cn.edu.bjut.constant.Constants;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhengtianqi
 */
public class MemoryMetric implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String description;
    private long initHeapMemoryUsage;
    private long maxHeapMemoryUsage;
    private long committedHeapMemoryUsage;
    private long usedHeapMemoryUsage;
    private String usedHeapMemoryUsageRate;

    private long initNonHeapMemoryUsage;
    private long maxNonHeapMemoryUsage;
    private long committedNonHeapMemoryUsage;
    private long usedNonHeapMemoryUsage;
    private String usedNonHeapMemoryUsageRate;

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

    public long getInitHeapMemoryUsage() {
        return initHeapMemoryUsage;
    }

    public void setInitHeapMemoryUsage(long initHeapMemoryUsage) {
        this.initHeapMemoryUsage = initHeapMemoryUsage;
    }

    public long getMaxHeapMemoryUsage() {
        return maxHeapMemoryUsage;
    }

    public void setMaxHeapMemoryUsage(long maxHeapMemoryUsage) {
        this.maxHeapMemoryUsage = maxHeapMemoryUsage;
    }

    public long getCommittedHeapMemoryUsage() {
        return committedHeapMemoryUsage;
    }

    public void setCommittedHeapMemoryUsage(long committedHeapMemoryUsage) {
        this.committedHeapMemoryUsage = committedHeapMemoryUsage;
    }

    public long getUsedHeapMemoryUsage() {
        return usedHeapMemoryUsage;
    }

    public void setUsedHeapMemoryUsage(long usedHeapMemoryUsage) {
        this.usedHeapMemoryUsage = usedHeapMemoryUsage;
    }

    public String getUsedHeapMemoryUsageRate() {
        return usedHeapMemoryUsageRate;
    }

    public void setUsedHeapMemoryUsageRate(String usedHeapMemoryUsageRate) {
        this.usedHeapMemoryUsageRate = usedHeapMemoryUsageRate;
    }

    public long getInitNonHeapMemoryUsage() {
        return initNonHeapMemoryUsage;
    }

    public void setInitNonHeapMemoryUsage(long initNonHeapMemoryUsage) {
        this.initNonHeapMemoryUsage = initNonHeapMemoryUsage;
    }

    public long getMaxNonHeapMemoryUsage() {
        return maxNonHeapMemoryUsage;
    }

    public void setMaxNonHeapMemoryUsage(long maxNonHeapMemoryUsage) {
        this.maxNonHeapMemoryUsage = maxNonHeapMemoryUsage;
    }

    public long getCommittedNonHeapMemoryUsage() {
        return committedNonHeapMemoryUsage;
    }

    public void setCommittedNonHeapMemoryUsage(long committedNonHeapMemoryUsage) {
        this.committedNonHeapMemoryUsage = committedNonHeapMemoryUsage;
    }

    public long getUsedNonHeapMemoryUsage() {
        return usedNonHeapMemoryUsage;
    }

    public void setUsedNonHeapMemoryUsage(long usedNonHeapMemoryUsage) {
        this.usedNonHeapMemoryUsage = usedNonHeapMemoryUsage;
    }

    public String getUsedNonHeapMemoryUsageRate() {
        return usedNonHeapMemoryUsageRate;
    }

    public void setUsedNonHeapMemoryUsageRate(String usedNonHeapMemoryUsageRate) {
        this.usedNonHeapMemoryUsageRate = usedNonHeapMemoryUsageRate;
    }

    public String getDateTime() {
        return Constants.FORMAT.format(dateTime);
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "MemoryMetric{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", initHeapMemoryUsage=" + initHeapMemoryUsage +
                ", maxHeapMemoryUsage=" + maxHeapMemoryUsage +
                ", committedHeapMemoryUsage=" + committedHeapMemoryUsage +
                ", usedHeapMemoryUsage=" + usedHeapMemoryUsage +
                ", usedHeapMemoryUsageRate='" + usedHeapMemoryUsageRate + '\'' +
                ", initNonHeapMemoryUsage=" + initNonHeapMemoryUsage +
                ", maxNonHeapMemoryUsage=" + maxNonHeapMemoryUsage +
                ", committedNonHeapMemoryUsage=" + committedNonHeapMemoryUsage +
                ", usedNonHeapMemoryUsage=" + usedNonHeapMemoryUsage +
                ", usedNonHeapMemoryUsageRate='" + usedNonHeapMemoryUsageRate + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
