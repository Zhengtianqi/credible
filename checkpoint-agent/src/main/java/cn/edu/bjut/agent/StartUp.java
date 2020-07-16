package cn.edu.bjut.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author zhengtianqi
 */
public class StartUp {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("hello, i'am agent!");
    }
}
