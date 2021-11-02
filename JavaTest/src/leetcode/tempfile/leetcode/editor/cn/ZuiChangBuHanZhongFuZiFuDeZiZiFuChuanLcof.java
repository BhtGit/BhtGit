package leetcode.tempfile.leetcode.editor.cn;

import java.util.*;

public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    /**
     * 2021-11-02 23:12:50
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof.class);
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
//}

// 第剑指 Offer 48题：最长不含重复字符的子字符串
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 示例 1:
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
// 示例 2: 
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
// 示例 3:
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// 提示：
// s.length <= 40000
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 307 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();

        int longLength = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(s.charAt(i));
            if (index != null && index >= left) {
                left = index+1;
            }
            map.put(s.charAt(i), i);
            longLength = Math.max(longLength, i - left + 1);
        }
        return longLength;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
