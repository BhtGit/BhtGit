package leetcode.tempfile.leetcode.editor.cn;

public class TiHuanKongGeLcof {
    /**
     * 2021-10-27 22:23:59
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(TiHuanKongGeLcof .class);

    }

// 第剑指 Offer 05题：替换空格
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 168 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();

    }
}}

//leetcode submit region end(Prohibit modification and deletion)
  
