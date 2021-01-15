package leetcode.sortandsearch;

/**
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * 输入: intervals = {{1,3},{2,6},{8,10},{15,18}}
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * <p>
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 * 。。。。不是按顺序从小到大的，不能挨个比较，只能两个循环
 *
 * @author BHT 2020/11/6 10:27
 */
public class Test06 {

    public static void main(String[] args) {

        int[][] merge = {{1,4},{4,5}};

        int[][] merge1 = new Test06().merge(merge);
        System.out.println(123);
    }

    public int[][] merge(int[][] intervals) {

        int[] record = new int[intervals.length];
        // 合并后的数组数量
        int nums = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (i == intervals.length - 1 ) {
                if (record[i] == 0) {
                    record[i] = 1;
                    nums++;
                }
                break;
            }
            // merge
            if (intervals[i][1] >= intervals[i + 1][0]) {
                int[] temp = {
                        intervals[i][0], intervals[i + 1][1]
                };
                intervals[i + 1] = temp;
                record[i + 1] = 1;
                if (record[i] == 1) {
                    record[i] = 0;
                } else {
                    nums++;
                }
            } else if (record[i] == 0) {
                record[i] = 1;
                nums++;
            }
        }

        int[][] merge = new int[nums][2];
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 1) {
                merge[merge.length - nums] = intervals[i];
                nums--;
                if (nums == 0) {
                    break;
                }
            }
        }
        return merge;
    }
}
