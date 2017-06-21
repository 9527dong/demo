package com.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * 使用httpClient连接管理来创建httpclient对象
 */
public class HttpConnectManager {

    public static void main(String[] args) throws Exception {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        // 设置最大连接数
        cm.setMaxTotal(200);
        // 设置每个主机地址的并发数
        cm.setDefaultMaxPerRoute(20);

        doGet(cm);
        doGet(cm);
    }

    public static void doGet(HttpClientConnectionManager cm) throws Exception {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        // 创建http GET请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com/");

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpClient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("内容长度：" + content.length());
            }
        } finally {
            if (response != null) {
                response.close();
            }
            // 此处不能关闭httpClient，如果关闭httpClient，连接池也会销毁
            // httpClient.close();
        }
    }

}
