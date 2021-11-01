package leetcode.tempfile.leetcode.editor.cn;

public class LiWuDeZuiDaJieZhiLcof {
    /**
     * 2021-11-01 23:18:08
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(LiWuDeZuiDaJieZhiLcof.class);
        int[][] arr = new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(solution.maxValue(arr));

    }
//}

// 第剑指 Offer 47题：礼物的最大价值
//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 示例 1:
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 提示： 
// 0 < grid.length <= 200
// 0 < grid[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 👍 207 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int[][] grid) {

        // 截止到当前位置的最大价值礼物
        // 一层一层计算
        int[] layer = new int[grid[0].length];
        layer[0] = grid[0][0];
        for (int i = 1; i < layer.length; i++) {
            layer[i] = layer[i - 1] + grid[0][i];
        }

        for (int rows = 1; rows < grid.length; rows++) {
            layer[0] += grid[rows][0];
            for (int cols = 1; cols < grid[rows].length; cols++) {
                layer[cols] = Math.max(layer[cols - 1], layer[cols]) + grid[rows][cols];
            }
        }
        return layer[layer.length - 1];
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
