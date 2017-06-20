package com.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 使用httpclient发送GET请求：
 *      模拟浏览器访问百度主页
 */
public class DoGET {

    public static void main(String[] args) throws Exception {

        //1. 创建Httpclient对象----相当于打开浏览器
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //2. 创建http GET请求----在地址栏输入百度url
        HttpGet httpGet = new HttpGet("http://www.baidu.com/");

        CloseableHttpResponse response = null;
        try {
            //3. 执行请求----相当于按下回车
            response = httpclient.execute(httpGet);
            //4. 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                //5. 获取响应内容
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("内容："+content);
            }
        } finally {
            //6. 相当于关闭浏览器，释放资源
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }

    }

}
