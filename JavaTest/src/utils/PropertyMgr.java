package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    static Properties pro = new Properties();

    static {
        try {
            pro.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config/tank.properties")); //从输入流中读取属性列表
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertyMgr() {
    } //防止别人申明该类的对象

    public static String getProperty(String key) {
        return pro.getProperty(key); //从配置文件中读取
    }
}
