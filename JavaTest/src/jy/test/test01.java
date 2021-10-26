package jy.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.*;

public class test01 {

    public static void main(String[] args) {


//        String jsonStr = "[{\"FIELDITEM1\":\"黄丽李;林华\",\"LASTMODTIME\":\"\",\"CREATETIME\":{\"bytes\":[120,120,6,9,15,47,48,57,-47,6,-128],\"length\":11,\"stream\":{}},\"LASTMODUSER\":\"\",\"TITLE\":\"民主评议第一轮\"},{\"FIELDITEM1\":\"黄丽李;林华\",\"LASTMODTIME\":\"\",\"CREATETIME\":{\"bytes\":[120,120,6,9,15,50,29,21,-124,108,64],\"length\":11,\"stream\":{}},\"LASTMODUSER\":\"\",\"TITLE\":\"民主评议第一轮\"},{\"FIELDITEM1\":\"王连超;林华;曾燕媚\",\"LASTMODTIME\":\"\",\"CREATETIME\":{\"bytes\":[120,120,6,9,15,48,37,5,-26,-98,-64],\"length\":11,\"stream\":{}},\"LASTMODUSER\":\"\",\"TITLE\":\"民主评议第一轮\"}]";

        JSONArray jsonArray = null;

        Map<String, Integer> result = countVote("FIELDITEM1", jsonArray, 2);

        Set<Map.Entry<String, Integer>> entries = result.entrySet();


        System.out.println(result);

        List list = new ArrayList();

        StringBuilder sb = new StringBuilder("<style>#span {width:50px;}</style>");
        sb.append("<span>");
        sb.append("投票项");
        sb.append("</span>");
        sb.append("<span>");
        sb.append("票数");
        sb.append("</span>");

    }

    public static Map<String, Integer> countVote(String fieldName, JSONArray jsonArray, int maxNum) {
        fieldName = fieldName.toUpperCase();
        Map<String, Integer> result = new HashMap<>();
        for (Object obj : jsonArray) {
            JSONObject json = JSON.parseObject(obj.toString());
            String vote = json.getString(fieldName);
            if (StringUtils.isEmpty(vote)) {
                continue;
            }
            String[] values = vote.split(";");
            if (values.length > maxNum) {
                String key = "无效票";
                if (!result.containsKey(key)) {
                    result.put(key, 0);
                }
                Integer num = result.get(key);
                result.put(key, ++num);

            } else {
                for (String key : values) {
                    if (!result.containsKey(key)) {
                        result.put(key, 0);
                    }
                    Integer num = result.get(key);
                    result.put(key, ++num);
                }
            }
        }
        return result;
    }

}
