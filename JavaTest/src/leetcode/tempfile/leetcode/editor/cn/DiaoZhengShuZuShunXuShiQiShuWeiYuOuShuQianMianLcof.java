package leetcode.tempfile.leetcode.editor.cn;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    /**
     * 2021-11-06 08:47:51
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof.class);
        for (int i : solution.exchange(new int[]{1, 2, 3, 4})) {
            System.out.print(i + ",");
        }
        System.out.println();

    }
//}

// 第剑指 Offer 21题：调整数组顺序使奇数位于偶数前面
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 👍 171 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) == 1) {
                left++;
            } else if ((nums[right] & 1) == 0) {
                right--;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
