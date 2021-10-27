package leetcode.tempfile.leetcode.editor.cn;

public class ZuoXuanZhuanZiFuChuanLcof {
    /**
     * 2021-10-27 22:30:07
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ZuoXuanZhuanZiFuChuanLcof.class);
        System.out.println(solution.reverseLeftWords("lrloseumgh", 6));
    }

// 第剑指 Offer 58 - II题：左旋转字符串
//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 数学 双指针 字符串 👍 158 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] res = new char[s.length()];

        char[] chars = s.toCharArray();
        for (int i = 0, j = n; i < chars.length; i++, j++) {
            res[i] = chars[j % chars.length];
        }
        return String.valueOf(res);
    }
}}

//leetcode submit region end(Prohibit modification and deletion)
  
