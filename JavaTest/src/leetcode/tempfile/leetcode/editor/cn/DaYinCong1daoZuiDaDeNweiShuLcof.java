package leetcode.tempfile.leetcode.editor.cn;

/**
 * 2021-11-24 21:54:24
 *
 * @author BHT
 */
public class DaYinCong1daoZuiDaDeNweiShuLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(DaYinCong1daoZuiDaDeNweiShuLcof.class);

    }
//}

// 第剑指 Offer 17题：打印从1到最大的n位数
//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
//
// 说明： 
// 用返回一个整数列表来代替打印
// n 为正整数 
// 
// Related Topics 数组 数学 👍 163 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] printNumbers(int n) {
        int[] res = new int[(int) Math.pow(10, n) - 1];

        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }

        return res;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
