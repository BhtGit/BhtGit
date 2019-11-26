package utils;

import java.util.Random;

/**
 * 随机生成密码
 *
 * @author ：BHT
 * @date ：2019-07-19 11:24
 */
public class RandomPassword {

    private static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789`~!@#$%^&*()_+=-{}[]\\|,;:'\",<.>/?";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 15;
        String randomString = getRandomString(n);
        System.out.println(randomString);
    }

}
