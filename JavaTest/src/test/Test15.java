package test;

/**
 * @author ：BHT
 * @date ：2019-09-15 20:01
 */
public class Test15 {

    private static int A;
    private static int B;
    private static int C;
    private static int[] ARR;

    public static int test(int[] arr, int a, int b, int c) {
        A = a;
        B = b;
        C = c;
        ARR = arr;

        int x = find(ARR.length, 0);
        int y = find(ARR.length, 1);
        int z = find(ARR.length, -1);

        if (x < y) {
            return x < z ? x : z;
        } else {
            return y < z ? y : z;
        }

    }

    /**
     * 需要找的数字
     * 0/==  1/+  -1/-
     *
     * @return
     */
    private static int find(int n, int flag) {
        int cost = A;
        if (flag == -1 && n > 1) {
            cost += C;
            n--;
        } else if (flag == 1 && n < ARR.length - 1) {
            cost += B;
            n++;
        }

        int nextCost = Integer.MAX_VALUE;

        for (int i = 0; i < ARR.length; i++) {
            int a = ARR[i];
            if (a != ARR.length && a == n) {
                if (i == 0){
                    return cost;
                }
                int x = find(i + 1, 0);
                int y = find(i + 1, 1);
                int z = find(i + 1, -1);
                if (x < y) {
                    nextCost = x < z ? x : z;
                } else {
                    nextCost = y < z ? y : z;
                }
                break;
            }
        }

        return cost + nextCost;

    }


    public static void main(String[] args) {

        int[] arr = {3, 6, 4, 3, 4, 5, 6};
        int test = test(arr, 1, 1, 1);
        System.out.println(test);


    }


}
