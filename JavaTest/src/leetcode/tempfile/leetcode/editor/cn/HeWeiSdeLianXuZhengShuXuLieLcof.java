package leetcode.tempfile.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021-11-17 20:35:20
 *
 * @author BHT
 */
public class HeWeiSdeLianXuZhengShuXuLieLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(HeWeiSdeLianXuZhengShuXuLieLcof.class);
        int[][] continuousSequence = solution.findContinuousSequence(15);
        for (int[] ints : continuousSequence) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }
//}

// 第剑指 Offer 57 - II题：和为s的连续正数序列
//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 示例 1：
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
//
// 示例 2： 
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
//
// 限制：
// 1 <= target <= 10^5
//
// Related Topics 数学 双指针 枚举 👍 342 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        // 还是用双指针吧，数学法下次就又不会了
        int left = 1, right = 2;
        while (left < right) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum < target) {
                right++;
            } else if (sum > target) {
                left++;
            } else {
                int[] arr = new int[right - left + 1];
                for (int i = 0; i <= right - left; i++) {
                    arr[i] = left + i;
                }
                res.add(arr);
                left++;
                right++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
