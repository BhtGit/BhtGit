package leetcode.tempfile.leetcode.editor.cn;

public class ZuiXiaoDeKgeShuLcof {
    /**
     * 2021-11-09 23:08:56
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ZuiXiaoDeKgeShuLcof.class);
        int[] leastNumbers = solution.getLeastNumbers(new int[]{0, 1, 1, 2, 4, 4, 1, 3, 3, 2}, 6);
        for (int leastNumber : leastNumbers) {
            System.out.print(leastNumber + "-");
        }
        System.out.println();
    }
//}

// 第剑指 Offer 40题：最小的k个数
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 示例 1：
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//
// 示例 2： 
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 限制：
//
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 324 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 已经写过最大的k个了，再写一次快排加深印象
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    private void quickSort(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        int temp = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= arr[left]) {
                j--;
            }
            while (i < j && arr[i] <= arr[left]) {
                i++;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[i] = arr[left];
        arr[left] = temp;
        if (i + 1 < k) {
            quickSort(arr, i + 1, right, k);
        } else if (i + 1 > k) {
            quickSort(arr, left, i - 1, k);
        }

    }

}
}
//leetcode submit region end(Prohibit modification and deletion)
  
