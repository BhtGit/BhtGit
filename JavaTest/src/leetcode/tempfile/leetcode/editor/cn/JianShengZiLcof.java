package leetcode.tempfile.leetcode.editor.cn;

/**
 * 2021-11-16 20:06:40
 *
 * @author BHT
 */
public class JianShengZiLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(JianShengZiLcof.class);
        System.out.println(solution.cuttingRope(120));
    }
//}

// 第剑指 Offer 14- I题：剪绳子
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
// 示例 1：
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
// 2 <= n <= 58
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
// Related Topics 数学 动态规划 👍 321 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int split = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, split);
        }
        if (remainder == 1) {
            return (int) Math.pow(3, split - 1) * 4;
        }
        return (int) Math.pow(3, split) * 2;
    }

    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i < n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    // 先暴力解
    public int cuttingRope1(int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * cuttingRope11(n - i));
        }
        return max;
    }

    // 先暴力解
    public int cuttingRope11(int n) {
        int max = n;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * cuttingRope11(n - i));
        }
        return max;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
