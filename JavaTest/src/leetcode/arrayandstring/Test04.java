package leetcode.arrayandstring;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Test04 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        return length(chars, 0, chars.length - 1);
    }

    private int length = 0;

    private int length(char[] chars, int startIndex, int endIndex) {
        if (endIndex - startIndex + 1 <= length) {
            return length;
        }
        for (int i = startIndex; i <= endIndex; i++) {
            for (int j = startIndex; j <= endIndex; j++) {
                if (i != j && chars[i] == chars[j]) {
                    // 分三组
                    int l1 = length(chars, startIndex, j - 1);
                    int l2 = length(chars, i + 1, endIndex);
                    int l3 = length(chars, i + 1, j);
                    return max(l1, l2, l3);
                }
            }
        }
        if (length == 0) {
            length = endIndex - startIndex + 1;
        }
        return endIndex - startIndex + 1;
    }

    private int max(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
        String s = "asdfasdferglkjqenfdjksbljqb34ewkjfndshjlgkrqewnds,fkfjnrej";
        int i = new Test04().lengthOfLongestSubstring(s);
        long l2 = System.currentTimeMillis();
        System.out.println(i + "--" + (l2 - l1));
    }
}
