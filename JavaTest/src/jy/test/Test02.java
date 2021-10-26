package jy.test;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.SessionManager;
import org.eclipse.jetty.util.URIUtil;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

public class Test02 {

    public static void main(String[] args) {

        String aaa = "{\n" +
                "    \"agentid\": \"1000033\",\n" +
                "    \"needChangeQyhAccount\": 1,\n" +
                "    \"userIDs\": \"chenjb1\",\n" +
                "    \"aclgroupid\": \"1000033\",\n" +
                "    \"cmd\": \"sendTextMessage\",\n" +
                "    \"depts\": \"\",\n" +
//                "    \"content\": \"您所辖客户黄耀昌(资金账号11014089)下周生日\\n生日:1963年8月5日\\n可提前准备服务方案！\\n资产411元，性别男，电话15012998586。\",\n" +
                "    \"tags\": \"\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(aaa);
//        String result = post(jsonObject, "https://ydoa.jyzq.cn/qyh/mvc/wx/sendMessage");
        String result = post(jsonObject, "http://10.32.1.82:8880/qyh/mvc/wx/sendMessage");
//        String result = post(jsonObject, "http://127.0.0.1:8081/qyh/mvc/wx/sendMessage");

        System.out.println(result);

//        HttpServletResponse resp = new Response(null);
//        String request_uri = resp.encodeRedirectURL("validate_page" + "?sysid=" + "system_id" + "&url=" + URLEncoder.encode("request_uri") + "&authcode=" + "system_id");
//        System.out.println(request_uri);
    }



    public static String post(JSONObject json, String url) {
        String result = "";
        HttpPost post = new HttpPost(url);
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            StringEntity postingString = new StringEntity(json.toString(), "utf-8");
            post.setEntity(postingString);
            HttpResponse response = httpClient.execute(post);

            InputStream in = response.getEntity().getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
            StringBuilder strber = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                strber.append(line + '\n');
            }
            br.close();
            in.close();
            result = strber.toString();
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                result = "服务器异常--" + result;
            }
        } catch (Exception e) {
            System.out.println("请求异常");
            e.printStackTrace();
        } finally {
            post.abort();
        }
        return result;
    }
}
