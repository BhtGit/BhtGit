package leetcode.arrayandstring;

/**
 * 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [5,4,3,2,1]
 * 输出: false
 */
public class Test06 {

    public boolean increasingTriplet(int[] nums) {

        if (nums == null || nums.length < 3) {
            return false;
        }

        int a = nums[0];
        int b = nums[0];
        int temp = nums[0];

        for (int n : nums) {
            if (b == a) {
                a = n < a ? n : a;
                temp = a;
                b = n;
            } else if (n > b) {
                return true;
            } else if (n > a) {
                b = n;
            } else if (n > temp) {
                a = temp;
                b = n;
            } else {
                temp = n;
            }
        }

        return false;
    }


    public boolean increasingTriplet2(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num < secondMin) {
                secondMin = num;
            } else if (num > secondMin) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, -100, -99,};
        boolean b = new Test06().increasingTriplet(nums);
        boolean b2 = new Test06().increasingTriplet2(nums);
        System.out.println(b);
        System.out.println(b2);
    }

}
