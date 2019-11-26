package gy.test;


import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;

/**
 * @author ：BHT
 * @date ：2019-07-24 10:31
 */
public class JsonUtil {
    public JsonUtil() {
    }

    public static String writeValueAsString(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(new Feature[]{Feature.FAIL_ON_EMPTY_BEANS});

        try {
            return mapper.writeValueAsString(o);
        } catch (IOException e) {
            System.out.println("json序列化错误");
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T readObject(String json, Class<T> clazz) {
        if (StringUtils.isEmpty(json)) {
            System.out.println("json data is empty:" + clazz);
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(new org.codehaus.jackson.map.DeserializationConfig.Feature[]{org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES});

            try {
                return mapper.readValue(json, clazz);
            } catch (IOException e) {
                System.out.println(String.format("json反序列化错误:JSON:{%s}", json));
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void main(String[] args) {

        JSONObject cloudDrpParam = new JSONObject();
        cloudDrpParam.put("deilivery_code", "123321123");
        cloudDrpParam.put("oi_code", "443323123123");
        System.out.println(cloudDrpParam.toJSONString());
        System.out.println(writeValueAsString(cloudDrpParam));

    }

}
