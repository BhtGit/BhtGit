package leetcode.tempfile.leetcode.editor.cn;

public class BaShuZiFanYiChengZiFuChuanLcof {
    /**
     * 2021-11-02 22:51:41
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(BaShuZiFanYiChengZiFuChuanLcof.class);
        System.out.println(solution.translateNum(18822));
    }
//}

// 第剑指 Offer 46题：把数字翻译成字符串
//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 示例 1: 
// 输入: 1225
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccf", "bwf", "bcz", "mcf"和"mz"
//                               1225   1 22 5  12 25  12 2 5   12 22 5
// 提示： 
// 0 <= num < 2³¹
// Related Topics 字符串 动态规划 👍 320 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        // 截止到当前总共多少种方式
        char[] chars = String.valueOf(num).toCharArray();

        int lastCount = 1;
        int currCount = 1;
        if ((chars[0] < '2' && chars[0] > '0') || (chars[0] == '2' && chars[1] <= '5')) {
            currCount = 2;
        }

        for (int i = 2; i < chars.length; i++) {
            if ((chars[i - 1] < '2' && chars[i - 1] > '0') || (chars[i - 1] == '2' && chars[i] <= '5')) {
                currCount += lastCount;
                lastCount = currCount - lastCount;
            } else {
                lastCount = currCount;
            }

        }

        return currCount;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
