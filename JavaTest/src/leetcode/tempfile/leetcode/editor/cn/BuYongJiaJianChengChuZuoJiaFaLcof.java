package leetcode.tempfile.leetcode.editor.cn;

public class BuYongJiaJianChengChuZuoJiaFaLcof {
    /**
     * 2021-11-14 20:44:36
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(BuYongJiaJianChengChuZuoJiaFaLcof.class);
        System.out.println(solution.add(1,1));
    }
//}

// 第剑指 Offer 65题：不用加减乘除做加法
//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 示例:
// 输入: a = 1, b = 1
//输出: 2 
//
// 提示：
// a, b 均可能是负数或 0
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 👍 230 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int add(int a, int b) {
        // 当进位为0时结束
        while (b != 0) {
            // 进位和为  a&b<<1
            int temp = (a & b) << 1;
            // 非进位和为  a^b
            a = a ^ b;
            b = temp;
        }
        return a;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
