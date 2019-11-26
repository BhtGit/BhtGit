package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ：BHT
 * @date ：2019-08-25 17:04
 */
public class Test13 {


    public void test1(String str){

    }


    private static Map<Character, Integer> map = new HashMap<>();

    public void test2(String str) {
        char[] chars = str.toCharArray();

        for (char ch : chars) {
            if (map.containsKey(ch)) {
                Integer integer = map.get(ch);
                integer++;
                map.put(ch, integer);
            } else {
                map.put(ch, 1);
            }
        }

    }


    public static int test4(String str1, String str2) {
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        if (a.length < b.length) {
            char[] temp = a;
            a = b;
            b = temp;
        }

        int al = a.length;
        int bl = b.length;

        int nums = 0;
        for (int i = 0, j = 0; i < a.length; ) {
            if (j == bl - 1) {
                nums += al - bl;
                break;
            }
            if (a[i] == b[j]) {
                i++;
                j++;
            } else if (al == bl) {
                nums++;
                i++;
                j++;
            } else if (al < bl) {
                bl--;
                nums++;
                j++;
            } else {
                al--;
                nums++;
                i++;
            }
        }

        return nums;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        int i = test4(split[0], split[1]);
        System.out.println(i);
    }

}
