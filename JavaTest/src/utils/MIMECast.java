package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author ：BHT
 * @date ：2019-11-29 00:23
 */
public class MIMECast {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String mime = "%E7%A9%BA%E6%A0%BC%26lt%3B%E7%A9%BA%E6%A0%BC";

        String str = URLDecoder.decode(mime, "utf-8");
        System.out.println(str);

        str = "落叶秋风扫落叶";
        mime = URLEncoder.encode(str,"utf-8");
        System.out.println(mime);
    }

}
