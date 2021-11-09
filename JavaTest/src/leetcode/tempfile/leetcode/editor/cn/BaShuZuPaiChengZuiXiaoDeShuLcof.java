package leetcode.tempfile.leetcode.editor.cn;

public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    /**
     * 2021-11-09 22:01:25
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(BaShuZuPaiChengZuiXiaoDeShuLcof.class);
        System.out.println(solution.minNumber(new int[]{3, 30, 34, 5, 9}));
    }
//}

// 第剑指 Offer 45题：把数组排成最小的数
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 示例 1:
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 提示: 
// 0 < nums.length <= 100
// 说明:
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 316 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        //快排
        quickSort(strs, 0, strs.length - 1);

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    private void quickSort(String[] strs, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        String temp = strs[l];
        while (l < r) {
            while (l < r && (strs[r] + strs[left]).compareTo(strs[left] + strs[r]) >= 0) {
                r--;
            }
            while (l < r && (strs[l] + strs[left]).compareTo(strs[left] + strs[l]) <= 0) {
                l++;
            }
            temp = strs[l];
            strs[l] = strs[r];
            strs[r] = temp;
        }
        strs[l] = strs[left];
        strs[left] = temp;
        quickSort(strs, left, l - 1);
        quickSort(strs, l + 1, right);

    }

}
}
//leetcode submit region end(Prohibit modification and deletion)
  
