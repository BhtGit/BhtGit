package leetcode.tempfile.leetcode.editor.cn;

public class JuZhenZhongDeLuJingLcof {
    /**
     * 2021-11-06 09:47:10
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(JuZhenZhongDeLuJingLcof.class);
        System.out.println(solution.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(solution.exist(new char[][]{
                {'a', 'b'},
                {'c', 'd'},
        }, "abcd"));
        System.out.println(solution.exist2(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(solution.exist2(new char[][]{
                {'a', 'b'},
                {'c', 'd'},
        }, "abcd"));
    }
//}

// 第剑指 Offer 12题：矩阵中的路径
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
// 示例 1：
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCCED"
//输出：true
//
// 示例 2： 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
//
// 提示： 
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 446 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == word.charAt(0)) {
                    if (exist(board, word, x, y, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word, int x, int y, int strIndex) {
        if (strIndex >= word.length()) {
            return true;
        }
        char temp = board[x][y];
        board[x][y] = '0';
        boolean exist = false;
        // 上
        if (x > 0 && board[x - 1][y] == word.charAt(strIndex)) {
            exist = exist(board, word, x - 1, y, strIndex + 1);
        }
        // 下
        if (!exist && x < board.length - 1 && board[x + 1][y] == word.charAt(strIndex)) {
            exist = exist(board, word, x + 1, y, strIndex + 1);
        }
        // 左
        if (!exist && y > 0 && board[x][y - 1] == word.charAt(strIndex)) {
            exist = exist(board, word, x, y - 1, strIndex + 1);
        }
        // 右
        if (!exist && y < board[0].length - 1 && board[x][y + 1] == word.charAt(strIndex)) {
            exist = exist(board, word, x, y + 1, strIndex + 1);
        }
        board[x][y] = temp;
        return exist;
    }

    public boolean exist2(char[][] board, String word) {

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (exist2(board, word, x, y, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist2(char[][] board, String word, int x, int y, int strIndex) {
        if (strIndex == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(strIndex)) {
            return false;
        }
        char temp = board[x][y];
        board[x][y] = '0';
        boolean exist = exist2(board, word, x - 1, y, strIndex + 1)
                || exist2(board, word, x + 1, y, strIndex + 1)
                || exist2(board, word, x, y - 1, strIndex + 1)
                || exist2(board, word, x, y + 1, strIndex + 1);
        board[x][y] = temp;
        return exist;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
