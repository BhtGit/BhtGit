package gy.util;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * @author ：BHT
 * @date ：2019-08-05 18:38
 */
public class MD5Util {
    public MD5Util() {
    }

    public static String hash(String input) {
        if (StringUtils.isEmpty(input)) {
            return "";
        } else {
            byte[] source;
            try {
                source = input.getBytes("UTF-8");
            } catch (UnsupportedEncodingException var10) {
                source = input.getBytes();
            }

            String result = null;
            char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(source);
                byte[] temp = md.digest();
                char[] str = new char[32];
                int k = 0;

                for(int i = 0; i < 16; ++i) {
                    byte byte0 = temp[i];
                    str[k++] = hexDigits[byte0 >>> 4 & 15];
                    str[k++] = hexDigits[byte0 & 15];
                }

                result = new String(str);
            } catch (Exception var11) {
                var11.printStackTrace();
            }

            return result;
        }
    }

    public static void main(String[] args) {

        String salt = "zhe3VnVXfu5PFBViHyakhd5Sv";
        String password = "U4~9^7zz";

        String hash = MD5Util.hash(MD5Util.hash(password) + salt);
        System.out.println(hash);


    }

}
