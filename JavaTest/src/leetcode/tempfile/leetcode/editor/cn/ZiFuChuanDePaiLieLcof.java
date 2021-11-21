package leetcode.tempfile.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 2021-11-21 21:04:56
 *
 * @author BHT
 */
public class ZiFuChuanDePaiLieLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ZiFuChuanDePaiLieLcof.class);

    }
//}

// 第剑指 Offer 38题：字符串的排列
//输入一个字符串，打印出该字符串中字符的所有排列。 
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
// 示例: 
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
// 限制：
// 1 <= s 的长度 <= 8
// Related Topics 字符串 回溯 👍 452 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> res = new LinkedList<>();

    char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }


    private void dfs(int index) {
        if (index == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(i, index);
            dfs(index + 1);
            swap(index, i);
        }
    }

    private void swap(int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
