package top.liyf.http;

import lombok.Getter;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author liyf
 * Created in 2019-11-21
 */
public class HttpClient {

    @Getter
    private CloseableHttpClient httpclient;

    private RequestConfig requestConfig;


    private HttpClient() {
        // 长连接保持30秒
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager(30, TimeUnit.SECONDS);
        // 总连接数
        manager.setMaxTotal(100);
        // 默认同路由的并发数
        manager.setDefaultMaxPerRoute(10);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(3000)
                .setSocketTimeout(3000)
                .build();

        HttpClientBuilder builder = HttpClients.custom();
        builder.setConnectionManager(manager);
        builder.setDefaultRequestConfig(requestConfig);
        // 重试次数
        builder.setRetryHandler(new DefaultHttpRequestRetryHandler(3, true));
        // 保持长连接配置，需要在头添加Keep-Alive
        builder.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE);

        this.httpclient = builder.build();

        // 开启监控线程,对异常和空闲线程进行关闭
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // 关闭异常连接
                manager.closeExpiredConnections();
                // 关闭30s空闲的连接
                manager.closeIdleConnections(30, TimeUnit.MILLISECONDS);
            }
        }, 30, 5, TimeUnit.SECONDS);

    }

    private static class SingletonHolder {
        private static final HttpClient INSTANCE = new HttpClient();
    }

    static CloseableHttpClient getClient() {
        return SingletonHolder.INSTANCE.getHttpclient();
    }



}
