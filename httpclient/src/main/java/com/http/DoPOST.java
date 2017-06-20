package com.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/**
 * 使用httpclient发送POST请求：
 *      模拟浏览器访问开源中国主页
 */
public class DoPOST {

    public static void main(String[] args) throws Exception {

        //1. 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //2. 创建http POST请求
        HttpPost httpPost = new HttpPost("http://www.oschina.net/");
        //3. 伪造为Firefox浏览器
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0");

        CloseableHttpResponse response = null;
        try {
            //4. 执行请求
            response = httpclient.execute(httpPost);
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
