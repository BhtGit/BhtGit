package test;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：BHT
 * @date ：2019-08-03 19:30
 */
public class Test07 {

    private final static String REGEX_BRACKET = "\\([^()]+\\)";
    private final static String REGEX_NUM = "\\d+";

    private final static Pattern PATTERN_BRACKET = Pattern.compile(REGEX_BRACKET);
    private final static Pattern PATTERN_NUM = Pattern.compile(REGEX_NUM);


    public static String test01(String zipStr) {
        while (true) {
            String matcher = getFirstMatcher(PATTERN_BRACKET, zipStr);
            if (StringUtils.isBlank(matcher)) {
                break;
            }
            int i = zipStr.indexOf(matcher);
            int index = i + matcher.length();
            int size = Integer.parseInt(zipStr.substring(index, index + 1));
            StringBuilder newStr = new StringBuilder();
            newStr.append(zipStr, 0, i);
            matcher = matcher.substring(1, matcher.length() - 1);
            for (int n = 0; n < size; n++) {
                newStr.append(matcher);
            }
            newStr.append(zipStr, index + 1, zipStr.length());
            zipStr = newStr.toString();
        }
        while (true) {
            String matcher = getFirstMatcher(PATTERN_NUM, zipStr);
            if (StringUtils.isBlank(matcher)) {
                break;
            }
            int i = zipStr.indexOf(matcher);
            String numsStr = zipStr.substring(i - 1, i);
            int num = Integer.parseInt(matcher);
            StringBuilder newStr = new StringBuilder();
            newStr.append(zipStr, 0, i - 1);
            for (int n = 0; n < num; n++) {
                newStr.append(numsStr);
            }
            newStr.append(zipStr, i + matcher.length(), zipStr.length());
            zipStr = newStr.toString();
        }
        return zipStr;
    }

    public static String getFirstMatcher(Pattern pattern, String source) {
        String result = "";
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            result = matcher.group();
        }
        return result;
    }


    public static void main(String[] args) {

        String str = "A11b";
        System.out.println(test01(str));


    }


}
