package leetcode.sortandsearch;

/**
 * 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * @author BHT 2020/10/29 8:52
 */
public class Test02 {

    public static void main(String[] args) {

        int[] nums = {5, -3, 9, 1, 7, 7, 9, 10, 2, 2, 10, 10, 3, -1, 3, 7, -9, -1, 3, 3};
        int k = 3;

        int[] ints = new Test02().topKFrequent(nums, k);
        System.out.println(123);

    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[k];
        int[] resultCount = new int[k];
        int[] noRepeat = new int[nums.length];
        int[] noRepeatCount = new int[nums.length];
        int noRepeatNums = 0;

        for (int i = 0; i < nums.length; i++) {
            boolean isExist = false;
            for (int j = 0; j < noRepeatNums; j++) {
                if (noRepeat[j] == nums[i]) {
                    noRepeatCount[j]++;
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                noRepeat[noRepeatNums] = nums[i];
                noRepeatCount[noRepeatNums] = 1;
                noRepeatNums++;
            }
        }

        for (int i = 0; i < noRepeatNums; i++) {
            if (i < k) {
                result[i] = noRepeat[i];
                resultCount[i] = noRepeatCount[i];
                continue;
            }
            for (int j = 0; j < k; j++) {
                if (noRepeatCount[i] > resultCount[j]) {
                    int temp = result[j];
                    result[j] = noRepeat[i];
                    noRepeat[i] = temp;
                    temp = resultCount[j];
                    resultCount[j] = noRepeatCount[i];
                    noRepeatCount[i] = temp;
                }
            }
        }
        return result;
    }
}
