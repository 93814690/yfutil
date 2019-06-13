package top.liyf.id;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author liyf
 * Created in 2019-06-13
 */

public class TestIdUtil {

    @Test
    public void testID() {

        long snowId = IdUtil.snowId();
        System.out.println("snowId = " + snowId);

        String randomUUID = IdUtil.randomUUID();
        System.out.println("randomUUID = " + randomUUID);

        String simpleUUID = IdUtil.simpleUUID();
        System.out.println("simpleUUID = " + simpleUUID);
    }
}