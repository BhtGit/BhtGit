package leetcode.tempfile.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ShuZuZhongZhongFuDeShuZiLcof {
    /**
     * 2021-10-27 22:40:53
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ShuZuZhongZhongFuDeShuZiLcof.class);

    }

// 第剑指 Offer 03题：数组中重复的数字
//找出数组中重复的数字。 
//
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
//
// 限制： 
// 2 <= n <= 100000
// Related Topics 数组 哈希表 排序 👍 589 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 注意！！！数字范围是0~n-1
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == i) {
                continue;
            }
            if (nums[num] == num) {
                return num;
            }
            // 目的地
            int des = num;
            while (nums[des] != des) {
                int temp = nums[des];
                nums[des] = nums[num];
                nums[num] = temp;
                des = num;
                num = temp;
            }

        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
