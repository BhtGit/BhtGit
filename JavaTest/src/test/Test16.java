package test;

import java.util.Scanner;

/**
 * 岛屿数量
 *
 * @author ：BHT
 * @date ：2019-11-27 21:33
 */
public class Test16 {

    /**
     * 海陆信息
     *
     * @param arr 二维数组
     * @param m   行数
     * @param n   列数
     * @return 岛屿个数
     */
    public int solution(int[][] arr, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        int islandNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    // 查找周围有没有1，并覆盖为0
                    findSurround(i, j, arr);
                    islandNum++;
                }
            }
        }

        return islandNum;
    }

    /**
     * 查找周围有没有1
     *
     * @param i   当前纵坐标
     * @param j   当前横坐标
     * @param arr 剩余岛屿信息
     */
    private void findSurround(int i, int j, int[][] arr) {
        arr[i][j] = 0;
        findUp(i, j, arr);
        findDown(i, j, arr);
        findLeft(i, j, arr);
        findRight(i, j, arr);
    }

    private void findUp(int i, int j, int[][] arr) {
        // 上边界
        if (i == 0) {
            return;
        }
        i--;
        if (arr[i][j] == 1) {
            findSurround(i, j, arr);
        }
    }

    private void findDown(int i, int j, int[][] arr) {
        // 下边界
        if (i == arr.length - 1) {
            return;
        }
        i++;
        if (arr[i][j] == 1) {
            findSurround(i, j, arr);
        }
    }

    private void findLeft(int i, int j, int[][] arr) {
        // 左边界
        if (j == 0) {
            return;
        }
        j--;
        if (arr[i][j] == 1) {
            findSurround(i, j, arr);
        }
    }

    private void findRight(int i, int j, int[][] arr) {
        // 右边界
        if (j == arr[0].length - 1) {
            return;
        }
        j++;
        if (arr[i][j] == 1) {
            findSurround(i, j, arr);
        }
    }

    // 寻找下一块岛屿的开始坐标？
    // 遍历上下左右是否有值为1的元素
    // 遍历过的元素统统置为0

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int solution = new Test16().solution(arr, m, n);
        System.out.println(solution);

    }

}
