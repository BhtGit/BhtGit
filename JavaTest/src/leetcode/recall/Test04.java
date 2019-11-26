package leetcode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * .[
 * .  [3],
 * .  [1],
 * .  [2],
 * .  [1,2,3],
 * .  [1,3],
 * .  [2,3],
 * .  [1,2],
 * .  []
 * .]
 *
 * @author ：BHT
 * @date ：2019-08-07 14:45
 */
public class Test04 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        cal(nums, 0, list, new ArrayList<>());
        return list;
    }

    private void cal(int[] nums, int index, List<List<Integer>> list, List<Integer> basic) {
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(basic);
            newList.add(nums[i]);
            list.add(newList);
            cal(nums, i + 1, list, newList);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = new Test04().subsets(nums);
        System.out.println(subsets);
    }

}
