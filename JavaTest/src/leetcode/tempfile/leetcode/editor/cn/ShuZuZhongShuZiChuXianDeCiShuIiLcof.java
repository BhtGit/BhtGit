package leetcode.tempfile.leetcode.editor.cn;

public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    /**
     * 2021-11-14 21:32:14
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ShuZuZhongShuZiChuXianDeCiShuIiLcof.class);

    }
//}

// 第剑指 Offer 56 - II题：数组中数字出现的次数 II
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 示例 1： 
// 输入：nums = [3,4,3,3]
//输出：4
// 示例 2：
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
// 限制：
// 1 <= nums.length <= 10000
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 👍 251 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        // 有限状态自动机，真特么牛逼啊
        // 设：有一个长32位的数组arr，该数组内所有值都是0，1，2
        // 将nums中所有位中的1的个数统计，并%3
        // 统计的过程中，每一位的个数都是0、1、2，顺序：0->1->2->0
        // arr中每一位都记录好这个个数
        // 由于只有一个数不是3次，所以最后得出arr中只有0、1，可以拼接成一个整数
        // 牛逼的来了
        // 0、1、2用两位的二进制表示为：00，01，10，顺序表示为：00->01->10
        // 用one来表示第一位的值，two来表示第二位的值
        // 那么就有：
        //  判断one的值：
        //      如果two=1，此时one必为0，再来一位0，不变；来一位1，还是不变 one = one;
        //      如果two=0：来一位0，不变；来一位1，one从1变为0，从0变为1   one = one ^ num;
        //      把two的值带进运算公式中，可得：one = one ^ num & ~two;
        //  two同理（计算完one的基础上）：
        //      如果one=1，则原值为0，two必为0，
        //      如果one=0，则原值为2或1，若two=0（原值1），two变1，two=1（原值2），变0
        int one = 0, two = 0;
        for (int num : nums) {
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one;
    }

    public int singleNumber2(int[] nums) {
        int[] arr = new int[32];
        for (int num : nums) {
            for (int i = arr.length - 1; i >= 0; i--) {
                arr[i] += num & 1;
                num >>= 1;
            }
        }
        int res = 0;
        for (int j : arr) {
            res <<= 1;
            res |= j % 3;
        }
        return res;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
