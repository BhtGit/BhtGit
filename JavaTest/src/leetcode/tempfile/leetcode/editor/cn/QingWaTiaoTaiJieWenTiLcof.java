package leetcode.tempfile.leetcode.editor.cn;

public class QingWaTiaoTaiJieWenTiLcof {
    /**
     * 2021-11-01 22:27:25
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(QingWaTiaoTaiJieWenTiLcof.class);

    }
//}

// 第剑指 Offer 10- II题：青蛙跳台阶问题
//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

// 示例 1：
// 输入：n = 2
//输出：2
//
// 示例 2： 
// 输入：n = 7
//输出：21
//
// 示例 3： 
// 输入：n = 0
//输出：1 
//
// 提示： 
// 0 <= n <= 100
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 214 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 这不就是斐波那契数列？？？？？
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int magicNum = 1000000007;

        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            if (arr[i] >= magicNum) {
                arr[i] %= magicNum;
            }
        }

        return arr[n];
    }

}
}
//leetcode submit region end(Prohibit modification and deletion)
  
