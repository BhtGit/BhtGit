package leetcode.tempfile.leetcode.editor.cn;

/**
 * 2022-02-28 22:14:27
 *
 * @author BHT
 */
public class SearchA2dMatrix {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(SearchA2dMatrix.class);

    }
//}

// 第74题：搜索二维矩阵
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。 
// 
// 示例 1：
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
// 示例 2：
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
//
// 提示： 
// m == matrix.length
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 584 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 先垂直二分，定位到行
        int up = 0, left = 0;
        int down = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (up < down) {
            int mid = up + (down - up) / 2;
            if (matrix[mid][right] == target) {
                return true;
            }
            if (matrix[mid][right] > target) {
                down = mid;
            } else {
                up = mid + 1;
            }
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[up][mid] == target) {
                return true;
            }
            if (matrix[up][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
