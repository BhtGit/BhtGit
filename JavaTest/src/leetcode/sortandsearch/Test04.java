package leetcode.sortandsearch;

/**
 * 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 * <p>
 * 你的解法应该是 O(logN) 时间复杂度的。
 *
 * @author BHT 2020/11/5 8:58
 */
public class Test04 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Test04().findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        if (nums == null) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((i == 0 && (i == nums.length - 1 || nums[i] > nums[i + 1]))
                    || (i != 0 && i == nums.length - 1 && nums[i] > nums[i - 1])
                    || (i != 0 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1])) {
                return i;
            }
        }
        return -1;
    }
}
