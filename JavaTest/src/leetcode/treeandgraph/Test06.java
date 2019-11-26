package leetcode.treeandgraph;

/**
 * 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 *
 * @author ：BHT
 * @date ：2019-08-01 16:51
 */
public class Test06 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    search(grid, i, j);
                    nums++;
                }
            }
        }
        return nums;
    }

    public void search(char[][] grid, int i, int j) {
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 0;
        // 搜索上下左右
        int iLength = grid.length;
        int jLength = grid[0].length;
        // up
        if (i > 0) {
            search(grid, i - 1, j);
        }
        // down
        if (i < iLength - 1) {
            search(grid, i + 1, j);
        }
        // left
        if (j > 0) {
            search(grid, i, j - 1);
        }
        if (j < jLength - 1) {
            search(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {
        Test06 t = new Test06();
//        char[][] grid = {
//                {1, 1, 0, 0, 0},
//                {1, 1, 0, 0, 0},
//                {0, 0, 1, 0, 0},
//                {0, 0, 0, 1, 1}
//        };

        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};


        int i = t.numIslands(grid);
        System.out.println(i);

    }

}
