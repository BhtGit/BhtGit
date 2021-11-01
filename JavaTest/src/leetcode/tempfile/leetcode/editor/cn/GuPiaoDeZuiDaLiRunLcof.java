package leetcode.tempfile.leetcode.editor.cn;

public class GuPiaoDeZuiDaLiRunLcof {
    /**
     * 2021-11-01 22:27:32
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(GuPiaoDeZuiDaLiRunLcof.class);
        System.out.println(solution.maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}));
    }
//}

// 第剑指 Offer 63题：股票的最大利润
//假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？ 
//
// 示例 1:
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
//
// 示例 2: 
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 限制： 
// 0 <= 数组长度 <= 10^5
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-
//stock/ 
// Related Topics 数组 动态规划 👍 174 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // 当前最大利润为之前的最大利润+昨天到今天的利润
        int yesterdayMax = Math.max(prices[1] - prices[0], 0);
        int minPrice = Math.min(prices[0], prices[1]);
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                yesterdayMax = Math.max(yesterdayMax, prices[i] - minPrice);
            }
        }
        return yesterdayMax;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
