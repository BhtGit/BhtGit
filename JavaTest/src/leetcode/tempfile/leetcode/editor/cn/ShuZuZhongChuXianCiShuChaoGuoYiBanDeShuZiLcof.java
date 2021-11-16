package leetcode.tempfile.leetcode.editor.cn;

import java.util.Stack;

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    /**
     * 2021-11-15 22:16:31
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof.class);

    }
//}

// 第剑指 Offer 39题：数组中出现次数超过一半的数字
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
// 示例 1:
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 限制：
// 1 <= 数组长度 <= 50000

// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
// Related Topics 数组 哈希表 分治 计数 排序 👍 217 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (stack.isEmpty() || stack.peek() == num) {
                stack.add(num);
            } else {
                stack.pop();
            }
        }
        return stack.pop();

    }

    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += res == num ? 1 : -1;
        }
        return res;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
