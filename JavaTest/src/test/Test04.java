package test;

import java.util.Arrays;

/**
 * @author ：BHT
 * @date ：2019-07-28 14:45
 */
public class Test04 {


    public int[] test(int[] a, int[] b) {

        if (a == null || a.length <= 1) {
            return a;
        }

        int index = -1;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("NO");
            System.exit(0);
        }

        min = a[index];
        if (index < a.length - 1) {
            max = a[index + 1];
        }

        boolean flag = false;

        for (int x : b) {
            if (x > min && x < max) {
                a[index] = x;
                flag = true;
            }
        }

        if (!flag) {
            System.out.println("NO");
            System.exit(0);
        }

        return a;
    }


    public static void main(String[] args) {

        int[] a = {1, 3, 7, 4, 10};
        int[] b = {2, 1, 5, 8, 9, 11};


        int[] test = new Test04().test(a, b);
        for (int x : test) {
            System.out.print(x + "-");
        }

    }

}
