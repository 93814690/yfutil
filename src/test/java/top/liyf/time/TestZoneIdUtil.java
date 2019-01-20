package top.liyf.time;


import org.junit.Test;

import java.time.ZoneId;

import static org.junit.Assert.*;

/**
 * @author liyf
 * Created in 2019-01-20
 */
public class TestZoneIdUtil {

    @Test
    public void get() {
        ZoneId sh = ZoneId.of("Asia/Shanghai");
        assertEquals(sh, ZoneIdUtil.get());
    }
}