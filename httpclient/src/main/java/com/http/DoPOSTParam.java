package com.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class DoPOSTParam {

    public static void main(String[] args) throws Exception {

        //1. 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //2. 创建http POST请求
        HttpPost httpPost = new HttpPost("http://www.oschina.net/search");
        //3. 伪造为Firefox浏览器
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0");

        //4. 构造form表单
        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("scope", "project"));
        parameters.add(new BasicNameValuePair("q", "java"));
        //oschina必须添加该参数才可以搜索
        parameters.add(new BasicNameValuePair("fromerr", "BgyjwY9d"));
        //5. 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        //6. 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            //7. 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
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
