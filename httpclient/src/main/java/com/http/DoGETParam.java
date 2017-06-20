package com.http;

import java.net.URI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 * 使用httpclient发送带有参数的GET请求：
 *      模拟使用百度搜索Java
 */
public class DoGETParam {

    public static void main(String[] args) throws Exception {

        //1. 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //2. 定义请求的参数
        URI uri = new URIBuilder("http://www.baidu.com/s").setParameter("wd", "java").build();

        System.out.println(uri);

        //3. 创建http GET请求
        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse response = null;
        try {
            //4. 执行请求
            response = httpclient.execute(httpGet);
            //5. 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }

    }

}
