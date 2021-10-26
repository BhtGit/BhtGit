package jy.test;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Test03 {

    public static void main(String[] args) throws IOException {

        Test03 t = new Test03();

        t.test();

    }


    public void test() throws IOException {
        String token = getToken("http://10.32.71.94:8091/oauth/token");
        System.out.println("token=" + token);
        String url = "http://10.32.71.94:8091/crawl/article/getArticle?access_token=" + token;
        Map<String, String> map = new HashMap<>();
        map.put("queryBeginTime", "2020-06-29");
        //map.put("queryEndTime", "2020-05-12");

        JSONObject result = postJsonData(url, map);

//
        System.out.println("result:" + result);
    }


    public String getToken(String url) {
        try {

            // =admin11&password=7777&grant_type=password&client_id=dev&client_secret=dev
            Map<String, String> map = new HashMap<>();
            map.put("username", "admin");
            map.put("password", "123456");
            map.put("grant_type", "password");
            map.put("client_id", "dev");
            map.put("client_secret", "dev");

            HttpPost httppost = getHttpPost(url, map,false);
            //设置编码
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpResponse response = httpClient.execute(httppost);
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println("result1=" + result);
            String token = JSONObject.fromObject(result).getString("access_token");
            return token;
        } catch (Exception e) {
            System.out.println("【error】:" + e);
            e.printStackTrace();
            String content = "{\"msgtype\": \"markdown\",\"markdown\": {\"content\": \""
                    + "getToken=>【error】:" + e.toString().replace("\"", "'")
                    + "\" }}";
        }
        return null;


    }

    public HttpPost getHttpPost(String url, Map<String, String> params, boolean isJson) {
        HttpPost httppost = new HttpPost(url); //建立HttpPost对象
        List<NameValuePair> param = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            param.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(param, HTTP.UTF_8);
            if (isJson) {
                entity.setContentType("application/json");
            }
            httppost.setEntity(entity);
        } catch (UnsupportedEncodingException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement st:stackTrace){
                System.out.println(st.toString());
            }
            e.printStackTrace();
        }
        return httppost;
    }


    public JSONObject postJsonData(String connUrl, Map<String, String> params) {

        JSONObject returnJson;
        String paramJson = JSONObject.fromObject(params).toString();
        CloseableHttpClient httpClient = null;
        try {
            HttpPost httpost = getHttpPost(connUrl, params, false);
            httpost.setHeader("Content-Type", "application/json");

            httpost.setEntity(new StringEntity(paramJson, "UTF-8"));
            httpClient = HttpClients.createDefault();
            HttpResponse response = httpClient.execute(httpost);
            returnJson = JSONObject.fromObject(EntityUtils.toString(response.getEntity(), "utf-8"));
        } catch (Exception ex) {
            System.out.println("post connUrl:" + connUrl + "参数为:" + paramJson + " getJSONData error:"+ex.getMessage());
            returnJson = new JSONObject();
            returnJson.put("errMsg", ex.getMessage());
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                }
            }
        }
        return returnJson;
    }

}
