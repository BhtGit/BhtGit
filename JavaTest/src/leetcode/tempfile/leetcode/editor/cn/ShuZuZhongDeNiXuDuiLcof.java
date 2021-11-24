package leetcode.tempfile.leetcode.editor.cn;

/**
 * 2021-11-24 22:03:10
 *
 * @author BHT
 */
public class ShuZuZhongDeNiXuDuiLcof {

    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ShuZuZhongDeNiXuDuiLcof.class);
        System.out.println(solution.reversePairs(new int[]{5, 4, 3, 2, 1}));
    }
//}

// 第剑指 Offer 51题：数组中的逆序对
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 559 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        oriNums = nums;
        temp = new int[nums.length];
        return cal(0, nums.length - 1);
    }

    int[] temp;
    int[] oriNums;

    public int cal(int start, int end) {
        if (end == start) {
            return 0;
        }
        int res = 0;
        int mid = start + (end - start) / 2;
        res += cal(start, mid);
        int right = mid + 1;
        res += cal(right, end);
        // 完全排序
        if (oriNums[mid] <= oriNums[right]) {
            return res;
        }
        System.arraycopy(oriNums, start, temp, start, end - start + 1);
        int i = start;
        while (start <= mid && right <= end) {
            if (temp[start] <= temp[right]) {
                oriNums[i++] = temp[start++];
            } else {
                res += mid - start + 1;
                oriNums[i++] = temp[right++];
            }
        }
        if (right > end) {
            // 左边剩余没统计的
            while (start <= mid) {
                oriNums[i++] = temp[start++];
            }
        }

        return res;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
