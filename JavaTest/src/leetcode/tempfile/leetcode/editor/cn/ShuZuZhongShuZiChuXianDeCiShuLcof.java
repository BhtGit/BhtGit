package leetcode.tempfile.leetcode.editor.cn;

public class ShuZuZhongShuZiChuXianDeCiShuLcof {
    /**
     * 2021-11-14 21:00:53
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ShuZuZhongShuZiChuXianDeCiShuLcof.class);

    }
//}

// 第剑指 Offer 56 - I题：数组中数字出现的次数
//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 示例 1： 
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
//
// 示例 2：
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 限制： 
// 2 <= nums.length <= 10000
// Related Topics 位运算 数组 👍 492 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        // 0、设两个不同的值分别为a,b
        // 1、全部异或得到x=a^b
        // 2、根据异或的特性分析x，如果x的第i位为1，则说明a和b的i位不同
        // 3、以i为根据，将i位为0的和1的分开异或，最后得到a、b两个数字

        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        int i = 1;
        while ((i & x) == 0) {
            i <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & i) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
