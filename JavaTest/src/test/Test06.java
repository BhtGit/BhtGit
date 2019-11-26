package test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author ：BHT
 * @date ：2019-07-28 15:51
 */
public class Test06 {


    public void test1(int n, int[] a, int q, int[] ask) {

        for (int i = 0; i < q; i++) {
            int maxNum = findMaxNum(a, ask[i]);
            BigDecimal percent = new BigDecimal(maxNum).divide(new BigDecimal(n), 6, BigDecimal.ROUND_HALF_UP);
            System.out.println(percent.toString());
        }

    }

    private int findMaxNum(int[] a, int index) {
        int num = 0;
        for (int ai : a) {
            if (ai < a[index - 1]) {
                num++;
            }
        }
        return num;
    }


    public void test2(int n, int[] a) {
        if (n <= 2) {
            System.out.println("NO");
            return;
        }

        Arrays.sort(a);

        if (a[n - 1] - a[n - 2] - a[n - 3] > 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }


    public void test4(int n, int[] a, int q, int[] asks) {

        for (int ask : asks) {
            System.out.println(findMaxNumAndSub(a, ask));
        }

    }

    private int findMaxNumAndSub(int[] a, int ask) {
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= ask) {
                a[i]--;
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Test06 t = new Test06();
//        int n = 3;
//        int[] a = {100, 98, 87};
//        int q = 3;
//        int[] ask = {1, 2, 3};
//        t.test1(n, a, q, ask);

//        int n = 3;
//        int[] a = {1, 2, 4};
//        t.test2(n, a);

        int n = 3;
        int q = 2;
        int[] a = {1, 2, 3};
        int[] asks = {3, 3};
        t.test4(n, a, q, asks);

    }

}
