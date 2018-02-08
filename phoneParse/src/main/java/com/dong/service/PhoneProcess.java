package com.dong.service;

import com.dong.bean.PhoneInfo;
import com.dong.http.HttpConnectManager;
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

    /**
     * 是否是联通
     *
     * @return true 是联通 false 不是联通
     */
    public boolean isUnicom(HttpConnectManager httpConnectManager,String tel) throws Exception {
        String content = httpConnectManager.doGet("https://tcc.taobao.com/cc/json/mobile_tel_segment.htm", tel);
        // System.out.println(content);
        String b = content.replace("__GetZoneResult_ = ", "").replaceAll("\\s*","");
        String c = b.replace("'", "\"");
        String d = c.replace("{", "{\"");
        String e = d.replace(",", ",\"");
        String f = e.replace(":", "\":");
        //System.out.println(f);
        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        ObjectMapper mapper = new ObjectMapper();
        PhoneInfo phoneInfo = mapper.readValue(f, PhoneInfo.class);
        // System.out.println(phoneInfo);
        if(phoneInfo.getCatName().equals("中国联通")){
            return true;
        }
        return false;
    }

}
