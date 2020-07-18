package cn.edu.bjut.test;

import java.lang.instrument.Instrumentation;

/**
 * 测试项目启动执行的agent
 *
 * @author zhengtianqi
 */
public class AgentTest {

    /**
     * JVM 首先尝试在代理类上调用以下方法
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("执行了JavaAgent " + agentArgs);
    }

    /**
     * 如果代理类没有实现上面的方法，那么 JVM 将尝试调用该方法
     */
    public static void premain(String agentArgs) {
    }

}
