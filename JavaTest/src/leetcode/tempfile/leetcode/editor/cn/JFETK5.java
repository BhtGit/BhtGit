package leetcode.tempfile.leetcode.editor.cn;

/**
 * 2021-12-06 23:18:38
 *
 * @author BHT
 */
public class JFETK5 {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(JFETK5.class);
        System.out.println(solution.addBinary("11", "10"));
        System.out.println(solution.addBinary("1010", "1011"));
    }
//}

// 第剑指 Offer II 002题：二进制加法
//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 示例 1: 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 提示： 
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
// Related Topics 位运算 数学 字符串 模拟 👍 10 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        char[] res = new char[a.length() + 1];

        int indexA = a.length();
        int indexB = b.length();
        // 进位
        int x = 0;
        for (int i = res.length - 1; i > 0; i--) {
            // 本位
            int y = x;
            if (indexA-- > 0) {
                int temp = (a.charAt(indexA) - '0');
                y ^= temp;
                x &= temp;
            }
            if (indexB-- > 0) {
                int temp = (b.charAt(indexB) - '0');
                x |= y & temp;
                y ^= temp;
            }
            res[i] = (char) (y + '0');
        }
        res[0] = (char) (x + '0');
        int offset = 1 ^ x;
        return new String(res, offset, res.length - offset);

    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
