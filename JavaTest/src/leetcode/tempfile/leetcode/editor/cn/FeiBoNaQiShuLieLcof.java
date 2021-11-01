package leetcode.tempfile.leetcode.editor.cn;

public class FeiBoNaQiShuLieLcof {
    /**
     * 2021-11-01 22:27:20
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(FeiBoNaQiShuLieLcof.class);
        System.out.println(solution.fib(48));
    }
//}

// 第剑指 Offer 10- I题：斐波那契数列
//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
// 示例 1： 
//输入：n = 2
//输出：1
//
// 示例 2： 
//输入：n = 5
//输出：5
//
// 提示： 
// 0 <= n <= 100
// Related Topics 记忆化搜索 数学 动态规划 👍 253 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int magicNum = 1000000007;

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            if (arr[i]>=magicNum){
                arr[i] %= magicNum;
            }
        }

        return arr[n - 1];
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
