package leetcode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * .[
 * .  [1,2,3],
 * .  [1,3,2],
 * .  [2,1,3],
 * .  [2,3,1],
 * .  [3,1,2],
 * .  [3,2,1]
 * .]
 *
 * @author ：BHT
 * @date ：2019-08-07 13:20
 */
public class Test03 {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        buildList(list, nums, new ArrayList<>());

        return list;
    }

    private void buildList(List<List<Integer>> list, int[] nums, List<Integer> beforeList) {

        if (nums.length == 0) {
            list.add(beforeList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(beforeList);
            newList.add(nums[i]);
            int[] newNums = new int[nums.length - 1];
            System.arraycopy(nums, 0, newNums, 0, i);
            System.arraycopy(nums, i + 1, newNums, i, newNums.length - i);
            buildList(list, newNums, newList);
        }

    }

    public static void main(String[] args) {
        Test03 t = new Test03();

        int[] nums = {1};
        List<List<Integer>> permute = t.permute(nums);
        System.out.println(permute);

    }

}
