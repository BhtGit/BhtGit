package leetcode.tempfile.leetcode.editor.cn;

public class NQueensIi {
    /**
     * 2021-01-20 08:58:49
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(NQueensIi.class);
        int i = solution.totalNQueens(9);
        System.out.println(i);
//        int[] board = new int[]{1,3,0,0};
//
//        boolean available = solution.isAvailable(board,3,2);
    }
}

// 第52题：N皇后 II
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 示例 1： 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 示例 2：
//输入：n = 1
//输出：1
//
// 提示： 
// 1 <= n <= 9
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
//
// Related Topics 回溯算法 
// 👍 225 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int totalNQueens(int n) {
        int[] board = new int[n];
        int ways = 0;
        int half = n >> 1;
        for (int i = 0; i < half; i++) {
            board[0] = 1 << i;
            ways += process(board, 1);
        }
        ways *= 2;
        if ((n & 1) == 1) {
            // 奇数
            board[0] = 1 << half;
            ways += process(board, 1);
        }
        return ways;
    }

    /**
     * 一列一列的来放置
     *
     * @param board 已经放置的棋盘
     * @param line  当前在填写第几列
     * @return 放置方法数
     */
    private int process(int[] board, int line) {
        if (line == board.length) {
            return 1;
        }

        int ways = 0;
        // 遍历当前列  判断是否可用
        for (int i = 0; i < board.length; i++) {
            // 如果当前格子可用
            int row = 1 << i;
//            int row = i;
            if (line == 0 || isAvailable(board, line, row)) {
                board[line] = row;
                ways += process(board, line + 1);
            }
        }
        return ways;
    }

//    public boolean isAvailable(int[] board, int line, int row) {
//        for (int i = 0; i < line; i++) {
//            if (row == board[i]) {
//                return false;
//            }
//            if (board[i] + i - line == row) {
//                return false;
//            }
//            if (board[i] - i + line == row) {
//                return false;
//            }
//        }
//        return true;
//    }

//    private boolean isAvailable(int[] board, int line, int row) {
//        for (int i = 0; i < line; i++) {
//            if (row == board[i]) {
//                return false;
//            }
//            if ((board[i] << (line - i)) == row) {
//                return false;
//            }
//            if ((board[i] >> (line - i)) == row) {
//                return false;
//            }
//        }
//        return true;
//    }

    private boolean isAvailable(int[] board, int line, int row) {
        int temp = 0;
        for (int i = 0; i < line; i++) {
            temp |= board[i];
            temp |= board[i] << (line - i);
            temp |= board[i] >> (line - i);
        }
        return (row & temp) == 0;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
  
