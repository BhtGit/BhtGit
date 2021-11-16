package leetcode.tempfile.leetcode.editor.cn;

import java.util.Stack;

/**
 * 2021-11-16 19:52:18
 *
 * @author BHT
 */
public class ReverseWordsInAStringIii {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ReverseWordsInAStringIii.class);

    }
//}

// 第557题：反转字符串中的单词 III
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例：
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
//
// 提示： 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
// 
// Related Topics 双指针 字符串 👍 363 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            } else {
                stack.add(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();

    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
