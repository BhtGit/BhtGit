package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author ：BHT
 * @date ：2019-08-11 14:19
 */
public class Test09 {

    /**
     * 统计同一组数字的类数
     *
     * @param nums 同一行样例的数组
     * @return 类数
     */
    public static int test(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(num -> {
            int i = Integer.bitCount(num);
            set.add(i);
        });
        return set.size();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nn = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int[] a = new int[num];
            for (int j = 0; j < num; j++) {
                a[j] = sc.nextInt();
            }
            nn[i] = test(a);
        }
        Arrays.stream(nn).forEach(System.out::print);
    }

}
