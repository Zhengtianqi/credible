package cn.edu.bjut.agent;

import cn.edu.bjut.monitor.AppCollectInfo;
import cn.edu.bjut.monitor.JvmCollectInfo;
import cn.edu.bjut.monitor.JvmStack;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.*;

/**
 * @author zhengtianqi
 */
public class MyAgent {

    /**
     * JVM 首先尝试在代理类上调用以下方法
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is my agent：" + agentArgs);

        // 使用ScheduledExecutorService创建定时任务
        ScheduledExecutorService schedule =
                new ScheduledThreadPoolExecutor(1, new ThreadFactoryBuilder().setNameFormat("scheduled-%d").build());
        // 创建并执行在给定延迟后启用的一次性操作
        schedule.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                JvmStack.printMemoryInfo();
                JvmStack.printGCInfo();
            }
        }, 6000L, 3000L, TimeUnit.MILLISECONDS);

    }

    /**
     * 如果代理类没有实现上面的方法，那么 JVM 将尝试调用该方法
     */
    public static void premain(String agentArgs) {
    }
}
