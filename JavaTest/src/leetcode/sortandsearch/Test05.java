package leetcode.sortandsearch;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @author BHT 2020/11/5 11:07
 */
public class Test05 {

    public static void main(String[] args) {


        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 7;
        int[] ints = new Test05().searchRange(nums, target);

        System.out.println(123);


    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int first = find(nums, target, 0, nums.length - 1, true);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = find(nums, target, first, nums.length - 1, false);

        return new int[]{first, last};
    }

    private int find(int[] nums, int target, int start, int end, boolean isFirst) {

        if (start > end) {
            return -1;
        }
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }

        int result = -1;
        int middle = (start + end) / 2;
        int sonStart;
        int sonEnd;
        if (nums[middle] == target) {
            result = middle;
            if (isFirst) {
                sonStart = start;
                sonEnd = middle - 1;
            } else {
                sonStart = middle + 1;
                sonEnd = end;
            }
        } else if (nums[middle] > target) {
            sonStart = start;
            sonEnd = middle - 1;
        } else {
            sonStart = middle + 1;
            sonEnd = end;
        }
        int sonResult = find(nums, target, sonStart, sonEnd, isFirst);
        if (sonResult != -1) {
            return sonResult;
        } else {
            return result;
        }
    }

    // 升序啊哥，注意看题
    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = -1;
        int last = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (first != -1 && last != -1) {
                break;
            }
            if (first == -1) {
                if (nums[start] == target) {
                    first = start;
                } else {
                    start++;
                }
            }
            if (last == -1) {
                if (nums[end] == target) {
                    last = end;
                } else {
                    end--;
                }
            }
        }
        return new int[]{first, last};
    }
}
