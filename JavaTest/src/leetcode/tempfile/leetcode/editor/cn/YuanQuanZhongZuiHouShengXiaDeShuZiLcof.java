package leetcode.tempfile.leetcode.editor.cn;

/**
 * 2021-11-17 22:20:11
 *
 * @author BHT
 */
public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(YuanQuanZhongZuiHouShengXiaDeShuZiLcof.class);
        System.out.println(solution.lastRemaining(5,3));
    }
//}

// 第剑指 Offer 62题：圆圈中最后剩下的数字
//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
//
// 示例 1：
//输入: n = 5, m = 3
//输出: 3
//
// 示例 2： 
//输入: n = 10, m = 17
//输出: 2
//
// 限制： 
// 1 <= n <= 10^5
// 1 <= m <= 10^6 
// 
// Related Topics 递归 数学 👍 477 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {
        // 倒推
        // 假设每一轮删除之后，序号都重新标
        // 那么最后一轮剩下的编号必然为0
        // 求这个人上一轮是多少号
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

}
}
//leetcode submit region end(Prohibit modification and deletion)
  
