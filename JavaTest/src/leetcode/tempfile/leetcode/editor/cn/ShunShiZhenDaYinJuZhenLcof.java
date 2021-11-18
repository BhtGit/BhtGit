package leetcode.tempfile.leetcode.editor.cn;

/**
 * 2021-11-17 22:38:14
 *
 * @author BHT
 */
public class ShunShiZhenDaYinJuZhenLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ShunShiZhenDaYinJuZhenLcof.class);
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] ints = solution.spiralOrder(arr);
    }
//}

// 第剑指 Offer 29题：顺时针打印矩阵
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 312 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int up = 0, left = -1;
        int down = matrix.length - 1, right = matrix[0].length - 1;
        int x = 0;
        while (true) {
            for (int i = ++left; i <= right; i++) {
                res[x++] = matrix[up][i];
            }
            if (x >= res.length) {
                break;
            }
            for (int i = ++up; i <= down; i++) {
                res[x++] = matrix[i][right];
            }
            if (x >= res.length) {
                break;
            }
            for (int i = --right; i >= left; i--) {
                res[x++] = matrix[down][i];
            }
            if (x >= res.length) {
                break;
            }
            for (int i = --down; i >= up; i--) {
                res[x++] = matrix[i][left];
            }
            if (x >= res.length) {
                break;
            }
        }

        return res;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
