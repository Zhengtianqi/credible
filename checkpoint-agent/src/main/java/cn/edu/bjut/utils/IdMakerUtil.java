package cn.edu.bjut.utils;

import java.util.UUID;

/**
 * id生成器
 *
 * @author zhengtianqi
 * @date 2019/8/28
 */
public class IdMakerUtil {
    /**
     * @return 生成一个32位大写字符串id
     */
    public static String make32Id() {
        String uuid = UUID.randomUUID().toString().toUpperCase();
        uuid = uuid.replaceAll("-", "");
        return uuid;
    }
}