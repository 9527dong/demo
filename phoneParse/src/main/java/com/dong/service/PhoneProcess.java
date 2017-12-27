package com.dong.service;

import com.dong.bean.PhoneInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PhoneProcess {
    //1. 创建Httpclient对象
    CloseableHttpClient httpclient = HttpClients.createDefault();
    /**
     * 是否是联通
     *
     * @return true 是联通 false 不是联通
     */
    public boolean isLianTong(String tel) throws Exception {
        //2. 定义请求的参数

        URI uri = new URIBuilder("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm").setParameter("tel", tel).build();

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
                String b = content.replace("__GetZoneResult_ = ", "").replaceAll("\\s*","");
                String c = b.replace("'", "\"");
                String d = c.replace("{", "{\"");
                String e = d.replace(",", ",\"");
                String f = e.replace(":", "\":");
                System.out.println(f);
                /**
                 * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
                 */
                ObjectMapper mapper = new ObjectMapper();
                PhoneInfo phoneInfo = mapper.readValue(f, PhoneInfo.class);
                System.out.println(phoneInfo);
                if(phoneInfo.getCatName().equals("中国联通")){
                    return true;
                }
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }
        return true;
    }

}
