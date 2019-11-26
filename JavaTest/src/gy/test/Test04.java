package gy.test;

import com.alibaba.fastjson.JSONObject;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author ：BHT
 * @date ：2019-10-30 10:12
 */
public class Test04 {

    public static void main(String[] args) {
        String aaa = "a2d1af48f37f44fc8cd780eaae2f9ac4appkey116105data{\"business_man_code\":4077356205,\"tenantId\":2045969993,\"env\":\"cerpdemo\",\"userId\":4077356205}methodgy.erp.dd.warehouse.getsessionKey711ff9dbdbfd456686c110228602661ea2d1af48f37f44fc8cd780eaae2f9ac4";

        byte[] bytes = encryptMD5(aaa);

        System.out.println(bytes);

    }

    static void sign(JSONObject json, String secret) {
        //将sign字段与值去掉
        json.remove("sign");
        // 第一步：把字典按Key的字母顺序排序
        Map<String, Object> sortedParams = new TreeMap<>(json);

        Set<Map.Entry<String, Object>> paramSet = sortedParams.entrySet();

        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder("");
        query.append(secret);
        for (Map.Entry<String, Object> param : paramSet) {
            query.append(param.getKey());
            query.append(param.getValue());
        }
        query.append(secret);

        // 第三步：使用MD5加密
        byte[] bytes = encryptMD5(query.toString());

        // 第四步：把二进制转化为大写的十六进制
        String sign = byte2hex(bytes);


        json.put("sign", sign);
    }

    // 交换字符串测试
    private static byte[] encryptMD5(String data) {
        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(aByte & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

}
