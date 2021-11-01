package leetcode.tempfile.leetcode.editor.cn;

public class LianXuZiShuZuDeZuiDaHeLcof {
    /**
     * 2021-11-01 23:09:45
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(LianXuZiShuZuDeZuiDaHeLcof.class);
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
//}

// 第剑指 Offer 42题：连续子数组的最大和
//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
// 要求时间复杂度为O(n)。

// 示例1:
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 提示： 
// 1 <= arr.length <= 10^5
// -100 <= arr[i] <= 100 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
// Related Topics 数组 分治 动态规划 👍 415 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {

        // 截止到当前，最大子数组和
        int currMax = -101;
        // 截止到当前，必须包含当前，最大子数组和
        int includeCurrMax = currMax;
        for (int num : nums) {
            includeCurrMax = Math.max(num + includeCurrMax, num);
            currMax = Math.max(currMax, includeCurrMax);
        }
        return currMax;

    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
