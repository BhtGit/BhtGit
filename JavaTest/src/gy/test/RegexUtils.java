package gy.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：BHT
 * @date ：2019-07-04 19:13
 */
public class RegexUtils {

    /**
     * 手机号
     */
    public static final String MOBILE_REGEX = "(0086|\\+86|086|86|)([1][0-9]{10})";
    /**
     * 固定电话
     */
    public static final String PHONE_REGEX = "(([0-9]{3,4}-)[0-9]{7,8})|([0-9]{7,12})";
    /**
     * 邮编
     */
    public static final String ZIP_REGEX = "[0-9]{6}";

    /**
     * 根据正则表达式从字符串中获取匹配内容
     *
     * @param regex  正则表达式
     * @param source 原字符串
     * @return 匹配的字符串
     */
    public static String getMatcher(String regex, String source) {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            result = matcher.group();
        }
        return result;
    }

}
