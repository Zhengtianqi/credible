package cn.edu.bjut.trustmanagement;

import cn.edu.bjut.metric.support.AppCollectInfo;
import cn.edu.bjut.utils.LocalMac;
import cn.edu.bjut.utils.UUIDHexGenerator;
import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DataMaker {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        Map<String, Object> map = new HashMap<>();
        String uuid = UUIDHexGenerator.guid();
        Date timeStamp = new Date();
        System.out.println(UUIDHexGenerator.guid());
        System.out.println(UUIDHexGenerator.guid());

        InetAddress ip = InetAddress.getLocalHost();
        String mac = LocalMac.getLocalMac(ip);
        AppCollectInfo appCollectInfo = AppCollectInfo.getInstance();

        map.put("_id", uuid);
        map.put("_timeStamp", timeStamp);

        BranchCheckPoint branchCheckPoint = new BranchCheckPoint(mac, "node1", mac.replace("0", "1"));
        SystemCheckPoint systemCheckPoint = new SystemCheckPoint(ip.toString().split("/")[1], appCollectInfo.getCpuUsage(), appCollectInfo.getMemoryUsed());
        ApplicationCheckPoint applicationCheckPoint = new ApplicationCheckPoint("registerServer", 10029, 0.02, 0.01);

        map.put("_branchCheckPoint", branchCheckPoint);
        map.put("_systemCheckPoint", systemCheckPoint);
        map.put("_applicationCheckPoint", applicationCheckPoint);

        System.out.println(JSON.toJSONString(map));
    }
}

class BranchCheckPoint implements Serializable {
    private static final long serialVersionUID = 1L;

    private String branchId;
    private String branchName;
    private String parentId;

    public BranchCheckPoint() {
    }

    public BranchCheckPoint(String branchId, String branchName, String parentId) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.parentId = parentId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}

class SystemCheckPoint implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ip;
    private double cpuUsage;
    private double memoryUsed;

    public SystemCheckPoint() {
    }

    public SystemCheckPoint(String ip, double cpuUsage, double memoryUsed) {
        this.ip = ip;
        this.cpuUsage = cpuUsage;
        this.memoryUsed = memoryUsed;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public double getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(double memoryUsed) {
        this.memoryUsed = memoryUsed;
    }
}

class ApplicationCheckPoint implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ApplicationName;
    private int pid;
    /**
     * 每分钟请求数,是吞吐量(Throughput)指标
     */
    private double callPerMinutes;
    /**
     * 请求响应时间
     */
    private double responseTime;

    public ApplicationCheckPoint() {
    }

    public ApplicationCheckPoint(String applicationName, int pid, double callPerMinutes, double responseTime) {
        ApplicationName = applicationName;
        this.pid = pid;
        this.callPerMinutes = callPerMinutes;
        this.responseTime = responseTime;
    }

    public String getApplicationName() {
        return ApplicationName;
    }

    public void setApplicationName(String applicationName) {
        ApplicationName = applicationName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getCallPerMinutes() {
        return callPerMinutes;
    }

    public void setCallPerMinutes(double callPerMinutes) {
        this.callPerMinutes = callPerMinutes;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }
}

