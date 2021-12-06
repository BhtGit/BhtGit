package leetcode.tempfile.leetcode.editor.cn;

/**
 * 2021-11-29 21:46:34
 *
 * @author BHT
 */
public class OneNzhengShuZhong1chuXianDeCiShuLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(OneNzhengShuZhong1chuXianDeCiShuLcof.class);

    }
//}

// 第剑指 Offer 43题：1～n 整数中 1 出现的次数
//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 示例 1：
//输入：n = 12
//输出：5
//
// 示例 2： 
//输入：n = 13
//输出：6 
//
// 限制： 
// 1 <= n < 2^31
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 递归 数学 动态规划 👍 250 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        int digit = 1;
        int high = n / 10;
        int low = 0;
        int curr = n % 10;

        while (high != 0 || curr != 0) {
            if (curr == 0) {
                res += high * digit;
            } else if (curr == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += curr * digit;
            curr = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
