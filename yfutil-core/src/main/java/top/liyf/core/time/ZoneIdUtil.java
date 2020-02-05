package top.liyf.core.time;

import java.time.ZoneId;

/**
 * @author liyf
 * Created in 2019-01-20
 */
public class ZoneIdUtil {

    /**
     * 功能描述: 默认获取上海时区
     *
     * @return java.time.ZoneId
     * @author liyf
     */
    public static ZoneId get() {
        return ZoneId.of("Asia/Shanghai");
    }
}
