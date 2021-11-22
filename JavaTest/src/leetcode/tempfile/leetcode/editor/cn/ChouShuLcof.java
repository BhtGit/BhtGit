package leetcode.tempfile.leetcode.editor.cn;

/**
 * 2021-11-22 21:20:30
 *
 * @author BHT
 */
public class ChouShuLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ChouShuLcof.class);
        System.out.println(solution.nthUglyNumber(7));
        for (int i = 1; i < 100; i++) {
            System.out.println(i + "--" + solution.nthUglyNumber(i));
        }
    }
//}

// 第剑指 Offer 49题：丑数
//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 246 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            a += dp[i] == n2 ? 1 : 0;
            b += dp[i] == n3 ? 1 : 0;
            c += dp[i] == n5 ? 1 : 0;
        }

        return dp[n - 1];
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
