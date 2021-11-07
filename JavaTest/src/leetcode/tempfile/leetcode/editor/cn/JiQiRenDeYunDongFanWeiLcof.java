package leetcode.tempfile.leetcode.editor.cn;

public class JiQiRenDeYunDongFanWeiLcof {
    /**
     * 2021-11-06 10:36:33
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(JiQiRenDeYunDongFanWeiLcof.class);
        System.out.println(solution.movingCount(3,1,0));
    }
//}

// 第剑指 Offer 13题：机器人的运动范围
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 示例 1： 
// 输入：m = 2, n = 3, k = 1
//输出：3
//
// 示例 2： 
// 输入：m = 3, n = 1, k = 0
//输出：1
//
// 提示： 
// 1 <= n,m <= 100
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 376 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        // 先用比较low的办法，二维数组
        boolean[][] arr = new boolean[n][m];
        return count(arr, k, 0, 0);
    }

    private int count(boolean[][] arr, int k, int x, int y) {
        if (x >= arr.length || y >= arr[0].length || arr[x][y]   || add(x) + add(y) > k) {
            return 0;
        }
        arr[x][y] = true;
        return 1 + count(arr, k, x + 1, y)
                + count(arr, k, x, y + 1);
    }

    private int add(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + add(n / 10);
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
