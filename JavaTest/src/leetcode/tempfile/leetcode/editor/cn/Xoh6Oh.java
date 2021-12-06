package leetcode.tempfile.leetcode.editor.cn;

/**
 * 2021-12-06 22:03:41
 *
 * @author BHT
 */
public class Xoh6Oh {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(Xoh6Oh.class);
        System.out.println(solution.divide(15, 2));
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
//}

// 第剑指 Offer II 001题：整数除法
//给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。 
//
// 注意：
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 2³¹−1]。本题中，如果除法结果溢出，则返回 231 − 1 
// 
// 示例 1：
//输入：a = 15, b = 2
//输出：7
//解释：15/2 = truncate(7.5) = 7
//
// 示例 2： 
//输入：a = 7, b = -3
//输出：-2
//解释：7/-3 = truncate(-2.33333..) = -2 
//
// 示例 3： 
//输入：a = 0, b = 1
//输出：0 
//
// 示例 4： 
//输入：a = 1, b = 1
//输出：1 
//
// 提示:
// -2³¹ <= a, b <= 2³¹ - 1
// b != 0 
//
// 注意：本题与主站 29 题相同：https://leetcode-cn.com/problems/divide-two-integers/ 
// Related Topics 位运算 数学 👍 55 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 测试用例全部通过，但是时间太长
     *
     * @param a
     * @param b
     * @return
     */
    public int divide1(int a, int b) {
        if (b == Integer.MIN_VALUE) {
            return a == b ? 1 : 0;
        }
        boolean minValue = false;
        if (a == Integer.MIN_VALUE) {
            minValue = true;
            a++;
        }
        int sign = 1;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            sign = -1;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        if (a < b) {
            return 0;
        }
        int res = 0;
        int tempA = a;
        boolean isAddOne = false;
        int i;
        while ((i = tempA >> 1) >= b) {
            res += 2;
            tempA -= b + b;
            i = tempA;
        }
        if (tempA >= b) {
            res++;
            tempA -= b;
        }
        if (minValue) {
            tempA++;
        }
        if (tempA >= b) {
            res++;
        }
        if (res < 0 && sign > 0) {
            res = Integer.MAX_VALUE;
        }

        return res * sign;
    }

    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            // 首先，右移的话，再怎么着也不会越界
            // 其次，无符号右移的目的是：将 -2147483648 看成 2147483648

            // 注意，这里不能是 (a >>> i) >= b 而应该是 (a >>> i) - b >= 0
            // 这个也是为了避免 b = -2147483648，如果 b = -2147483648
            // 那么 (a >>> i) >= b 永远为 true，但是 (a >>> i) - b >= 0 为 false
            if ((a >>> i) - b >= 0) { // a >= (b << i)
                a -= (b << i);
                res += (1 << i);
            }
        }
        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符
        return sign == 1 ? res : -res;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
