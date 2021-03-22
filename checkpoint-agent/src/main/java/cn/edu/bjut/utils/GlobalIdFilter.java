package cn.edu.bjut.utils;

import java.util.UUID;

/**
 * @author ztq
 */
public class GlobalIdFilter{

    private static final ThreadLocal<String> GLOBAL_ID = new ThreadLocal<>();

    public static String getGlobalId() {
        if(GLOBAL_ID.get() == null) {
            String s = UUID.randomUUID().toString();
            setGlobalId(s);
        }
        return GLOBAL_ID.get();
    }

    public static void setGlobalId(String traceId) {
        GLOBAL_ID.set(traceId);
    }
}
