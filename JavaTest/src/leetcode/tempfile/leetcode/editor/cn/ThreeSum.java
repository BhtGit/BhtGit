package leetcode.tempfile.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2022-03-02 22:45:28
 * @author BHT
 */
public class ThreeSum {
    
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ThreeSum .class);

    }
//}
    
// 第15题：三数之和
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 示例 1：
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
// 示例 2：
//输入：nums = []
//输出：[]
//
// 示例 3： 
//输入：nums = [0]
//输出：[]
//
// 提示： 
// 0 <= nums.length <= 3000
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4395 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return lists;
        }
        int lastI = Integer.MAX_VALUE;
        int lastJ = Integer.MIN_VALUE;
        for (int i = 0; nums[i] <= 0 && i < nums.length - 2; i++) {
            if (nums[i] == lastI) {
                continue;
            }
            lastI = nums[i];
            for (int j = nums.length - 1; nums[j] >= 0 && j > i + 1; j--) {
                if (nums[j] == lastJ) {
                    continue;
                }
                lastJ = nums[j];
                int kl = i;
                int kr = j;
                int k = (kl + kr) / 2;
                for (; k != kl && k != kr; ) {
                    int temp = nums[i] + nums[k] + nums[j];
                    if (temp == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[k]);
                        list.add(nums[j]);
                        lists.add(list);
                        break;
                    } else if (temp > 0) {
                        kr = k;
                    } else {
                        kl = k;
                    }
                    k = (kl + kr) / 2;
                }
            }
            lastJ = Integer.MIN_VALUE;
        }
        return lists;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
