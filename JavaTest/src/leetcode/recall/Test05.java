package leetcode.recall;

import org.apache.commons.lang3.StringUtils;

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
 *
 * @author ：BHT
 * @date ：2019-11-13 10:22
 */
public class Test05 {

    // 写的什么jb，回溯算法！

    public static void main(String[] args) {
        char[][] borad = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ASFBC";

        boolean exist = new Test05().exist(borad, word);
        System.out.println(exist);

    }

    public boolean exist(char[][] board, String word) {

        if (board.length == 0 || board[0].length == 0 || StringUtils.isBlank(word)) {
            return false;
        }

        char[] chars = word.toCharArray();
        int[] index;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                index = selectFirstChar(board, chars[0], i, j);
                if (index == null) {
                    return false;
                }
                boolean exist = exist(board, chars, index);
                if (exist) {
                    return true;
                }
            }
        }

        return false;

    }

    public boolean exist(char[][] board, char[] chars, int[] index) {

        int[][] flag = new int[board.length][board[0].length];
        flag[index[0]][index[1]] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (!isExist(board, flag, chars[i], index)) {
                return false;
            }
        }
        return true;

    }

    private int[] selectFirstChar(char[][] board, char firstChar, int startX, int startY) {
        int[] index = new int[2];
        for (int i = startX; i < board.length; i++) {
            for (int j = startY; j < board[i].length; j++) {
                if (board[i][j] == firstChar) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return null;
    }

    /**
     * 周围是否存在该目标
     */
    private boolean isExist(char[][] board, int[][] flag, char ch, int[] index) {
        if (isExistUp(board, flag, ch, index[0], index[1])) {
            return true;
        }
        if (isExistDown(board, flag, ch, index[0], index[1])) {
            return true;
        }
        if (isExistLeft(board, flag, ch, index[0], index[1])) {
            return true;
        }
        if (isExistRight(board, flag, ch, index[0], index[1])) {
            return true;
        }
        return false;
    }


    private boolean isExistUp(char[][] board, int[][] flag, char ch, int x, int y) {
        if (x > 0 && board[x - 1][y] == ch && flag[x - 1][y] == 0) {
            flag[x - 1][y] = 1;
            return true;
        }
        return false;

    }

    private boolean isExistDown(char[][] board, int[][] flag, char ch, int x, int y) {
        if (x < board.length - 1 && board[x + 1][y] == ch && flag[x + 1][y] == 0) {
            flag[x + 1][y] = 1;
            return true;
        }
        return false;
    }

    private boolean isExistLeft(char[][] board, int[][] flag, char ch, int x, int y) {
        if (y > 0 && board[x][y - 1] == ch && flag[x][y - 1] == 0) {
            flag[x][y - 1] = 1;
            return true;
        }
        return false;
    }

    private boolean isExistRight(char[][] board, int[][] flag, char ch, int x, int y) {
        if (y < board[x].length - 1 && board[x][y + 1] == ch && flag[x][y + 1] == 0) {
            flag[x][y + 1] = 1;
            return true;
        }
        return false;
    }

}
