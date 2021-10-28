package leetcode.tempfile.leetcode.editor.cn;

public class ErWeiShuZuZhongDeChaZhaoLcof {
    /**
     * 2021-10-28 10:53:19
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ErWeiShuZuZhongDeChaZhaoLcof.class);
        System.out.println(solution.findNumberIn2DArray(new int[][]{{-1,3}},-1));

    }
//}

// 第剑指 Offer 04题：二维数组中的查找
//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 示例:
// 现有矩阵 matrix 如下：
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 给定 target = 5，返回 true。
// 给定 target = 20，返回 false。
//
// 限制：
// 0 <= n <= 1000
// 0 <= m <= 1000
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 二分查找 分治 矩阵 👍 474 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 从第一行的最后一个开始判断
    // 如果小，则查找下一行；如果大，则二分查找本行

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                // 在本行二分查找
                int left = 0, right = col - 1;
                int[] tempArr = matrix[row];
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (tempArr[mid] == target) {
                        return true;
                    }
                    if (tempArr[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            row++;
        }

        return false;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)

