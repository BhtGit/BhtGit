package gy.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author ：BHT
 * @date ：2019-09-27 18:54
 */
public class Test03 {

    class A {
        public int aa = 0;
    }

    public static void main(String[] args) throws IOException {

//        Map<String,Double> map = new HashMap<>();
//        map.put("1",1.0);
//        map.put("12312311",1.0);
//        map.put("adsd",123123.0);
//        map.put("gfdgdfgdf",1323123.0);
//        String s = JSON.toJSONString(map);
//        System.out.println(s);
//        JSONObject jsonObject = JSONObject.parseObject(s);
//        System.out.println(jsonObject);

//        String s = JSON.toJSONString(new HashMap<>());
//        System.out.println(s);
//        Map<String,Double> map = JSON.parseObject(s, HashMap.class);
//        System.out.println(map);

//
//        // list.addAll到底是地址add还是复制了数组
//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        a.add(4);
//        a.add(5);
//        a.add(6);
//        a.add(7);
//        a.add(8);
//        a.add(9);
//        a.add(0);
//        List<Integer> list = a.subList(0, 1);
//        List<Integer> list1 = a.subList(6, 10);
//        System.out.println(list);
//        System.out.println(list1);


//        BigDecimal bigDecimal = new BigDecimal("2.3");
//        System.out.println(bigDecimal.toString());


//        String str = "[{\"a\":1,\"b\":\"c\"},{\"a\":3,\"b\":\"ad\"}]";
//        Object parse = JSON.parse(str);
//        JSONObject jsonObject = JSONObject.parseObject(str);
//        System.out.println(jsonObject);


        Map<String, Object> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "1");
        map.put("c", "1");
        map.put("d", "1");
        Map<String, String> param = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        param.put("aaa", objectMapper.writeValueAsString(map));
        System.out.println(JSON.toJSONString(param));
        StringBuilder query = new StringBuilder();
        Set<Map.Entry<String, String>> entries = param.entrySet();
        boolean hasParam = false;

        for (Map.Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            // 忽略参数名或参数值为空的参数
            if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }

                query.append(name).append("=").append(URLEncoder.encode(value, "UTF-8"));
            }
        }
        System.out.println(query.toString());

    }


}
