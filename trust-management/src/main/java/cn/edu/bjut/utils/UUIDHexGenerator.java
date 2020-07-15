package cn.edu.bjut.utils;

import java.util.UUID;

/**
 * @author zhengtianqi
 * @date 2019/10/22
 */
public class UUIDHexGenerator {

    private UUIDHexGenerator() {
    }

    public static String guid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

}
