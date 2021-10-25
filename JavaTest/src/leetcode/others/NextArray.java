package leetcode.others;

import java.util.Arrays;

/**
 * next数组
 * 定义：从0开始截止到当前位置的字符串的前缀和后缀相等的最大长度，但是前缀和后缀的长度必须小于这个字符串长度
 *
 * @author BHT 2021/2/9 14:32
 */
public class NextArray {

    public static void main(String[] args) {

        String str = "abcdabd";

        int[] nextArray = getNextArray(str.toCharArray());
        Arrays.stream(nextArray).forEach(System.out::print);

    }

    public static int[] getNextArray(char[] chars) {
        int[] next = new int[chars.length];
        for (int i = 1; i < next.length; i++) {
            int index = i - 1;
            while (chars[i] != chars[next[index]] && index > 0) {
                index = next[index];
            }
            next[i] = index == 0 ? chars[i] == chars[0] ? 1 : 0 : next[index] + 1;
        }
        return next;
    }

}
