package leetcode.tempfile.leetcode.editor.cn;

import java.math.BigInteger;

/**
 * 2021-11-25 23:08:19
 *
 * @author BHT
 */
public class JianShengZiIiLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(JianShengZiIiLcof.class);

        for (int i = 2;i<1000;i++){
            if (solution.cuttingRope(i)!= solution.cuttingRope2(i)){
                System.out.println(i);
                System.out.println(solution.cuttingRope(i));
                System.out.println(solution.cuttingRope2(i));
                break;
            }
        }
    }
//}

// 第剑指 Offer 14- II题：剪绳子 II
//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1：
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
// 2 <= n <= 1000
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
// Related Topics 数学 动态规划 👍 143 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }

        int segments = n / 3;
        int remainder = n % 3;
        int res;
        if (remainder == 0) {
            res = pow3(segments,"1");
        } else if (remainder == 1) {
            res = pow3(segments - 1,"4");
        } else {
            res = pow3(segments,"2");
        }
        return res;
    }

    public int pow3(int segments,String others) {
        BigInteger res = new BigInteger("1");
        while (segments-- > 0) {
            res = res.multiply(new BigInteger("3"));
        }
        res = res.multiply(new BigInteger(others));
        return Integer.parseInt(res.mod(new BigInteger("1000000007")).toString());
    }
    public int cuttingRope2(int n) {
        //已知n >= 2,当2 <= n <= 4时，结果如下
        if(n == 2)return 1;
        if(n == 3)return 2;
        if(n == 4)return 4;
        //当n > 4时，要剪出来尽可能多长度为3的段,当n <= 4的时候，不再剪段
        long res = 1;//一定要用long类型，否则当n较大时，使用int类型的话res会越界
        int mod = (int)1e9 + 7;
        while(n > 4){
            res = res * 3 % mod;
            n -= 3;
        }
        return (int)(res * n % mod);//这里是乘上最后小于等于4的段
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
