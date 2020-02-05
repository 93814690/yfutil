package top.liyf.http;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author liyf
 * Created in 2019-11-23
 */
public class TestHttpUtil {

    @Test
    @Ignore
    public void doGet() throws Exception {
        HttpClientResult result = HttpUtil.doGet("https://www.oschina.net/", null, null);
        System.out.println("result = " + result);
    }
}