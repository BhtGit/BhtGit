package leetcode.tempfile.leetcode.editor.cn;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    /**
     * 2021-01-22 16:57:41
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(LongestSubstringWithAtLeastKRepeatingCharacters.class);
        String str = "aaabb";
        int k = 3;
        int a = solution.longestSubstring(str, k);
        System.out.println(a);
        int b = solution.longestSubstring2(str, k);
        System.out.println(b);
        int c = solution.longestSubstring3(str, k);
        System.out.println(c);
    }

// 第395题：至少有K个重复字符的最长子串
//找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。 
//
// 示例 1: 
//输入:
//s = "aaabb", k = 3
//输出:
//3
//最长子串为 "aaa" ，其中 'a' 重复了 3 次。
//
// 示例 2: 
//输入:
//s = "ababbc", k = 2
//输出:
//5
//最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 264 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = -1;
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[chars[i] - 'a']++;
        }
        // 是否符合规则
        boolean withRule = true;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 0 || alphabet[i] >= k) {
                continue;
            }
            withRule = false;
            char currChar = (char) ('a' + i);
            // 不符合规则的字符，直接切分，分别计算子串，计算最大值
            int index = s.indexOf(currChar);
            String s1 = s.substring(0, index);
            String s2 = s.substring(index + 1);
            length = Math.max(longestSubstring(s1, k), longestSubstring(s2, k));
            break;
        }
        if (withRule) {
            return s.length();
        }
        return length;
    }

    public int longestSubstring2(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        return longestSubstring2(s.toCharArray(), 0, s.length() - 1, k);
    }

    public int longestSubstring2(char[] chars, int start, int end, int k) {
        if (end + 1 - start < k || end >= chars.length) {
            return 0;
        }
        int length = -1;
        int[] alphabet = new int[26];
        int[] location = new int[26];
        for (int i = start; i <= end; i++) {
            int index = chars[i] - 'a';
            if (alphabet[index] == 0) {
                // 记录第一次出现该元素的位置
                location[index] = i;
            }
            alphabet[index]++;
        }
        // 是否符合规则
        boolean withRule = true;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 0 || alphabet[i] >= k) {
                continue;
            }
            withRule = false;
            // 不符合规则的字符，直接切分，分别计算子串，计算最大值
            length = Math.max(longestSubstring2(chars, start, location[i] - 1, k), longestSubstring2(chars, location[i] + 1, end, k));
            break;
        }
        if (withRule) {
            return end - start + 1;
        }
        return length;
    }

    public int longestSubstring3(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        return longestSubstring3(s.toCharArray(), 0, s.length() - 1, k);
    }

    /**
     * 之前两种方法都是遍历了 alphabet数组
     * 现在使用遍历chars的方法
     */
    public int longestSubstring3(char[] chars, int start, int end, int k) {
        if (end + 1 - start < k || end >= chars.length) {
            return 0;
        }
        int[] alphabet = new int[26];
        for (int i = start; i <= end; i++) {
            int index = chars[i] - 'a';
            alphabet[index]++;
        }

        // 将不符合的边界去掉
        while (end - start + 1 >= k) {
            if (alphabet[chars[start] - 'a'] >= k) {
                break;
            }
            start++;
        }
        while (end - start + 1 >= k) {
            if (alphabet[chars[end] - 'a'] >= k) {
                break;
            }
            end--;
        }
        if (end - start + 1 < k) {
            return 0;
        }

        for (int i = start; i <= end; i++) {
            if (alphabet[chars[i] - 'a'] < k) {
                // 不符合规则的情况  分治计算
                return Math.max(longestSubstring3(chars, start, i - 1, k), longestSubstring3(chars, i + 1, end, k));
            }
        }

        return end - start + 1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
