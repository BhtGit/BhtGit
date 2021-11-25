package leetcode.tempfile.leetcode.editor.cn;

/**
 * 2021-11-25 22:15:53
 *
 * @author BHT
 */
public class ShuZiXuLieZhongMouYiWeiDeShuZiLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ShuZiXuLieZhongMouYiWeiDeShuZiLcof.class);
        System.out.println(solution.findNthDigit(1000000000));
    }
//}

// 第剑指 Offer 44题：数字序列中某一位的数字
//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 示例 1：
// 输入：n = 3
//输出：3
// 
// 示例 2：
// 输入：n = 11
//输出：0 
//
// 限制：
// 0 <= n < 2^31
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
// Related Topics 数学 二分查找 👍 180 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        // 一位数占用  9*10^0*1
        // 二位数占用  9*10^1*2
        // 三位数占用  9*10^2*3
        if (n < 10) {
            return n;
        }

        // 计算n所在的数字有多少位
        int digits = 1;
        // n所在数字之前的位数，需要占多少
        long used = 9;
        while (used < n) {
            digits++;
            n -= used;
            // 如果长度超出int限制，则位数到了，直接跳出
            /*if (used > Integer.MAX_VALUE / digits) {
                break;
            }*/
            used = 9 * (long) Math.pow(10, digits - 1) * digits;
        }
        // 计算n处于哪个数
        int thisNum = (int) Math.pow(10, digits - 1) + n / digits;
        // 当前数字的第几位
        int locationInNum = n % digits;
        // 如果正好是一位数的最后一个数字，则上面计算结果需要减1
        if (locationInNum == 0) {
            thisNum--;
        }
        locationInNum = locationInNum == 0 ? digits : locationInNum;
        thisNum /= (int) Math.pow(10, digits - locationInNum);
        return thisNum % 10;

    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
