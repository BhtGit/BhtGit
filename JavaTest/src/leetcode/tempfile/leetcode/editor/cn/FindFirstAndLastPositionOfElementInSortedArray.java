package leetcode.tempfile.leetcode.editor.cn;

import org.apache.solr.highlight.SolrEncoder;

/**
 * 2022-02-28 20:44:43
 *
 * @author BHT
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(FindFirstAndLastPositionOfElementInSortedArray.class);
        int[] nums = new int[]{1,2,3,3,3,3,4,5,9};
        int[] ints = solution.searchRange(nums, 3);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
//}

// 第34题：在排序数组中查找元素的第一个和最后一个位置
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
// 示例 1：
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2：
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 提示： 
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1485 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
}
//leetcode submit region end(Prohibit modification and deletion)
  
