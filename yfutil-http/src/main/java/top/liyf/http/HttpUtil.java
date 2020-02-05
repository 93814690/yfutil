package top.liyf.http;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Map;
import java.util.Set;

/**
 * @author liyf
 * Created in 2019-11-21
 */
public class HttpUtil {

    /**
     * 编码格式。发送编码格式统一用UTF-8
     */
    private static final String UTF8 = "UTF-8";


    public static HttpClientResult doGet(String url, Map<String, String> headers, Map<String, String> params) throws Exception {

        // 创建访问的地址
        URIBuilder uriBuilder = new URIBuilder(url);
        if (params != null) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue());
            }
        }

        // 创建http对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        packageHeader(headers, httpGet);


        // 自动释放资源
        try (CloseableHttpResponse httpResponse = HttpClient.getClient().execute(httpGet)) {
            // 执行请求并获得响应结果
            return getHttpClientResult(httpResponse);
        }
    }

    private static void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
        if (params != null) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                // 设置到请求头到HttpRequestBase对象中
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    private static HttpClientResult getHttpClientResult(CloseableHttpResponse response)
            throws Exception {

        String res = EntityUtils.toString(response.getEntity(), UTF8);
        EntityUtils.consume(response.getEntity());
        StatusLine statusLine = response.getStatusLine();
        return new HttpClientResult(statusLine.getStatusCode(), statusLine.toString(), res);

    }
}
