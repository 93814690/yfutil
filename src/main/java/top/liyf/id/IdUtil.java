package top.liyf.id;

import java.util.UUID;

/**
 * ID 生成工具类
 *
 * @author liyf
 * Created in 2019-06-13
 */
public class IdUtil {

    /**
     * 功能描述: 雪花算法ID
     *
     * @return long
     * @author liyf
     */
    public static long snowId() {
        return KeyGenerator.INSTANCE.nextId();
    }

    /**
     * 功能描述: 获取随机UUID
     *
     * @return java.lang.String
     * @author liyf
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 功能描述: 获取无‘-’的UUID
     *
     * @return java.lang.String
     * @author liyf
     */
    public static String simpleUUID() {
        return randomUUID().replace("-", "");
    }
}
