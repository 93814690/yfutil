package top.liyf.http;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liyf
 * Created in 2019-11-22
 */
@Data
public class HttpClientResult implements Serializable {

    /**
     * 响应状态码
     */
    private int code;

    private String statusLine;

    /**
     * 响应数据
     */
    private String content;

    public HttpClientResult() {
    }

    public HttpClientResult(int code) {
        this.code = code;
    }

    public HttpClientResult(String content) {
        this.content = content;
    }

    public HttpClientResult(int code, String statusLine, String content) {
        this.code = code;
        this.statusLine = statusLine;
        this.content = content;
    }

}
