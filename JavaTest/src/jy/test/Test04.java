package jy.test;

import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Set;

public class Test04 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String keyURl = "/shenpi/task.jsf?id=";
        String mailBody = "http://10.32.1.25:7007/oa/shenpi/task.jsf?id=319330";
        String subject = "业务需求待办：水电费广告费发士大夫";
        int endIndex = subject.indexOf("待办：");
        String type = subject.substring(0, endIndex);
        String url = "/tybg/gotoTYGL.jsp?redirectUrl=http://10.32.71.85:9999/layui/admin/pro/dist/views/process/oaProcessDetail_ifram.html";
        String redirectParam = "?pStatus=unfinish";
        redirectParam += "&pType=" + type;
        redirectParam += "&taskId=";
        url += URLEncoder.encode(redirectParam,"iso-8859-1");
        mailBody = mailBody.replace(keyURl, url);
        String decode = URLDecoder.decode(url);
        System.out.println(mailBody);


        JSONObject diyConditions = JSONObject.fromObject("");
        Set paramKeys = diyConditions.keySet();
        StringBuilder diyConditionSqlSb = new StringBuilder(" and ");
        for (Object obj:paramKeys){
            String paramKey = (String) obj;
            paramKey = paramKey.toUpperCase();
            // 字段校验，必须是FIELDITEM开头
            if (paramKey.indexOf("FIELDITEM") == 0) {
                Object paramValue = diyConditions.get(paramKey);
                diyConditionSqlSb.append(" A1.FIELDNAME = ");
                diyConditionSqlSb.append(paramKey);
                if (paramValue == null || "".equals(paramValue)) {
                    diyConditionSqlSb.append(" and (A1.FIELDVALUE is null or A1.FIELDVALUE = '')");
                } else {
                    diyConditionSqlSb.append(" A1.FIELDVALUE = ");
                    diyConditionSqlSb.append(paramValue);
                }
            }
        }

    }//http://10.32.1.25:7007/oa/tybg/gotoTYGL.jsp?redirectUrl=http://10.32.71.85:9999/layui/admin/pro/dist/views/process/oaProcessDetail_ifram.html?processId=271733&taskId=318080&pDefId=&pType=%E5%86%85%E9%83%A8%E4%BA%8B%E5%8A%A1%E5%AE%A1%E6%89%B9&pStatus=unfinish

}
