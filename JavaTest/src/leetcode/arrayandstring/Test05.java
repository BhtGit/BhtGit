package leetcode.arrayandstring;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Test05 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        int indexA = 0;
        int indexB = 0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = s.length() - 1; j > i && j - i > indexB - indexA; j--) {
                if (chars[i] != chars[j] || !judge(chars, i, j)) {
                    continue;
                }
                indexA = i;
                indexB = j;
                break;
            }
        }

        return s.substring(indexA, indexB + 1);
    }

    private boolean judge(char[] chars, int indexA, int indexB) {
        for (int i = indexA, j = indexB; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "112321231dasd2asddsa312dsadA12";
        String s1 = new Test05().longestPalindrome(s);
        System.out.println(s1);
    }


}
