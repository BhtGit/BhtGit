package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：BHT
 * @date ：2019-08-11 15:34
 */
public class Test11 {

    private static int process(int[] a, int q) {

        StringBuilder sb = new StringBuilder();
        for (int ai : a) {
            if (ai <= q) {
                sb.append(" ");
            } else {
                sb.append("1");
            }
        }
        String str = sb.toString().trim();
        if ("".equals(str)) {
            return 0;
        }
        return str.replaceAll(" +", " ").split(" ").length;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int an = sc.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = sc.nextInt();
        }
        int qn = sc.nextInt();
        int[] q = new int[qn];
        for (int i = 0; i < qn; i++) {
            q[i] = sc.nextInt();
        }
        Arrays.stream(q).forEach(qq -> System.out.println(process(a, qq)));
    }
}
