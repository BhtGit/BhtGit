package leetcode.tempfile.leetcode.editor.cn;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    /**
     * 2021-10-27 22:58:03
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ZaiPaiXuShuZuZhongChaZhaoShuZiLcof.class);
        System.out.println(solution.search(new int[]{5, 7, 7, 8, 8, 10}, 11));
    }
//}

// 第剑指 Offer 53 - I题：在排序数组中查找数字 I
//统计一个数字在排序数组中出现的次数。 
//
// 示例 1:
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 提示： 
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 216 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
                continue;
            }
            if (nums[mid] < target) {
                left = mid + 1;
                continue;
            }
            left = mid;
            while (left >= 0 && nums[left] == target) {
                left--;
                count++;
            }
            right = mid + 1;
            while (right < nums.length && nums[right] == target) {
                right++;
                count++;
            }
            break;

        }
        return count;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
