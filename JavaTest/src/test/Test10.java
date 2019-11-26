package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：BHT
 * @date ：2019-08-11 14:51
 */
public class Test10 {


    private static int process(int m, int t, int m1, int t1, int m2, int t2) {

        // 水量
        int water = 0;
        // 开关
        boolean flag1 = true;
        boolean flag2 = true;
        for (int i = 0; i < t; i++) {
            if (i != 0) {
                flag1 = (i % t1 == 0) != flag1;
                flag2 = (i % t2 == 0) != flag2;
            }
            int change = 0;
            if (flag1 && flag2) {
                change = m1 - m2;
            } else if (flag1) {
                change = m1;
            } else if (flag2) {
                change = -m2;
            }
            water = waterInOut(water, change, m);
        }
        return water;
    }

    /**
     * 计算给排水后水量
     *
     * @param water  初始水量
     * @param change 给排水量 排水为负
     * @param m      最大值
     * @return 给排水后水量
     */
    private static int waterInOut(int water, int change, int m) {
        int count = change + water;
        if (count < 0) {
            return 0;
        }
        if (count > m) {
            return m;
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nn = new int[n];
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int t = sc.nextInt();
            int m1 = sc.nextInt();
            int t1 = sc.nextInt();
            int m2 = sc.nextInt();
            int t2 = sc.nextInt();
            nn[i] = process(m, t, m1, t1, m2, t2);
        }
        Arrays.stream(nn).forEach(System.out::print);

    }
}
