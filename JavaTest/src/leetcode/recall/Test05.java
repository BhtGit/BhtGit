package leetcode.recall;

/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * @author ：BHT
 * @date ：2019-11-13 10:22
 */
public class Test05 {

    public static void main(String[] args) {
        char[][] borad = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S', 'D'},
                {'A', 'D', 'E', 'E'}};
        String word = "ESD";

        boolean exist = new Test05().exist(borad, word);
        System.out.println(exist);

    }

    public boolean exist(char[][] board, String word) {
        if (word == null || "".equals(word)) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        char[] wordChars = word.toCharArray();

        for (int yIndex = 0; yIndex < board.length; yIndex++) {
            for (int xIndex = 0; xIndex < board[0].length; xIndex++) {
                if (board[yIndex][xIndex] != wordChars[0]) {
                    continue;
                }
                board[yIndex][xIndex] += 100;
                if (judgeExist(board, yIndex, xIndex, wordChars, 1)) {
                    return true;
                }
                board[yIndex][xIndex] -= 100;
            }
        }
        return false;
    }

    private boolean judgeExist(char[][] board, int yIndex, int xIndex, char[] wordChars, int currentWordIndex) {
        return judgeNext(board, yIndex, xIndex - 1, wordChars, currentWordIndex)
                || judgeNext(board, yIndex, xIndex + 1, wordChars, currentWordIndex)
                || judgeNext(board, yIndex - 1, xIndex, wordChars, currentWordIndex)
                || judgeNext(board, yIndex + 1, xIndex, wordChars, currentWordIndex);
    }

    private boolean judgeNext(char[][] board, int yIndex, int xIndex, char[] wordChars, int currentWordIndex) {
        if (wordChars.length == currentWordIndex) {
            // 已查询到最后
            return true;
        }
        if (xIndex == -1 || yIndex == -1 || yIndex == board.length || xIndex == board[yIndex].length) {
            // 越界
            return false;
        }
        if (board[yIndex][xIndex] != wordChars[currentWordIndex]) {
            return false;
        }
        // +100后可确保字符不重复
        board[yIndex][xIndex] += 100;
        currentWordIndex++;
        if (judgeExist(board, yIndex, xIndex, wordChars, currentWordIndex)) {
            return true;
        }
        board[yIndex][xIndex] -= 100;
        return false;
    }

}
