package leetcode.tempfile.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 2021-11-22 21:55:09
 *
 * @author BHT
 */
public class NgeTouZiDeDianShuLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(NgeTouZiDeDianShuLcof.class);
        int n = 3;
        double[] doubles1 = solution.dicesProbability1(n);
        for (double aDouble : doubles1) {
            System.out.print(aDouble + ",");
        }
        System.out.println();
        double[] doubles = solution.dicesProbability(n);
        for (double aDouble : doubles) {
            System.out.print(aDouble + ",");
        }
        System.out.println();
    }
//}

// 第剑指 Offer 60题：n个骰子的点数
//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// Related Topics 数学 动态规划 概率与统计 👍 315 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] dicesProbability1(int n) {
        if (n == 1) {
            return new double[]{1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0};
        }
        double[] res = new double[n * 5 + 1];

        int last = n - 1;
        double[] lastRes = dicesProbability(last);

        for (int i = 0; i < lastRes.length; i++) {
            lastRes[i] /= 6.0;
            for (int j = 0; j < 6; j++) {
                res[i + j] += lastRes[i];
            }
        }
        return res;
    }

    // 不用递归
    public double[] dicesProbability(int n) {
        double[] res = new double[6];
        Arrays.fill(res, 1.0 / 6.0);

        for (int x = 2; x <= n; x++) {
            double[] temp = new double[x * 5 + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] /= 6.0;
                for (int j = 0; j < 6; j++) {
                    temp[i + j] += res[i];
                }
            }
            res = temp;
        }
        return res;
    }

}
}
//leetcode submit region end(Prohibit modification and deletion)
  
