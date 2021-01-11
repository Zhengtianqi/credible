package cn.edu.bjut.trustmanagement;

import cn.edu.bjut.metric.support.AppCollectInfo;
import cn.edu.bjut.metric.support.JvmCollectInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class TrustManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        AppCollectInfo appCollectInfo = AppCollectInfo.getInstance();
        System.out.println(appCollectInfo.getCpuUsage());
        System.out.println(appCollectInfo.getMemoryUsed());
        System.out.println(appCollectInfo.getStartTime());
        System.out.println(appCollectInfo.getRunTime());
        System.out.println(appCollectInfo.getSystemLoadAverage());


        JvmCollectInfo jvmCollectInfo = JvmCollectInfo.getInstance();
        System.out.println(jvmCollectInfo.getThreadCount4State().toString());
    }

}
