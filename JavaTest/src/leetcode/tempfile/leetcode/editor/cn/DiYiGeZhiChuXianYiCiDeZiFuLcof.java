package leetcode.tempfile.leetcode.editor.cn;

import java.util.*;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    /**
     * 2021-10-29 22:11:33
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(DiYiGeZhiChuXianYiCiDeZiFuLcof.class);
        System.out.println(solution.firstUniqChar(""));
    }
//}

// 第剑指 Offer 50题：第一个只出现一次的字符
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//输入：s = "abaccdeff"
//输出：'b'
//
// 示例 2: 
//输入：s = ""
//输出：' '
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 148 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {

        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();

        for (char ch : chars) {
            if (map.containsKey(ch)) {
                list.set(map.get(ch), null);
            } else {
                list.add(ch);
                map.put(ch, list.size() - 1);
            }
        }

        for (Character ch : list) {
            if (ch != null ){
                return ch;
            }
        }

        return ' ';
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
