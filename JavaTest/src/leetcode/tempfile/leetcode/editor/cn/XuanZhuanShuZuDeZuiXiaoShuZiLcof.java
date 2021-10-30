package leetcode.tempfile.leetcode.editor.cn;

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    /**
     * 2021-10-28 23:02:00
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(XuanZhuanShuZuDeZuiXiaoShuZiLcof.class);
        System.out.println(solution.minArray(new int[]{1,2,0,0,0,1}));
    }
//}

// 第剑指 Offer 11题：旋转数组的最小数字
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
// 输入：[3,4,5,1,2]
//输出：1
//
// 示例 2：
// 输入：[2,2,2,0,1]
//输出：0
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/ 
// Related Topics 数组 二分查找 👍 431 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 当前最小值是不是numbers的首位
    boolean minFirst = true;

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        return minArray(numbers, 0, numbers.length - 1, numbers[0]);
    }

    /**
     * @param numbers
     * @param left
     * @param right
     * @param min     当前最小值
     * @return 最小值
     */
    private int minArray(int[] numbers, int left, int right, int min) {
        // 如果minFirst被更改过，则说明该分支是在后面"flag"处的right分支，已被废弃
        if (!minFirst) {
            return min;
        }
        while (left <= right) {
            if (numbers[left] < numbers[right]) {
                // 有序数组取最左
                return numbers[left];
            }
            int mid = left + (right - left) / 2;
            if (numbers[mid] > min) {
                // 说明旋转过较小的数在mid右边
                left = mid + 1;
            } else if (numbers[mid] < min) {
                // 说明旋转过较小的数<=mid
                min = numbers[mid];
                right = mid;
                minFirst = false;
            } else {
                // mid与min相等时
                // flag：如果是首位，则分支判断
                if (minFirst) {
                    // minFirst使用全局变量，如果某个分支更改了该变量，说明剩余的分支废了
                    int lMin = minArray(numbers, left, mid - 1, min);
                    int rMin = minArray(numbers, mid + 1, right, min);
                    return Math.min(lMin, rMin);
                } else {
                    // 判断当前min是不是首位，如果不是首位，则和小于做一样的判断
                    min = numbers[mid];
                    right = mid - 1;
                }
            }
        }
        return min;
    }

}
}
//leetcode submit region end(Prohibit modification and deletion)
  
