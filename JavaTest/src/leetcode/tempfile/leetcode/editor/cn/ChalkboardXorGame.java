package leetcode.tempfile.leetcode.editor.cn;

public class ChalkboardXorGame {
    /**
     * 2021-07-01 09:38:42
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ChalkboardXorGame.class);
        int[] nums = {1, 1, 2};
        System.out.println(solution.duishuqi(nums));
    }

// 第810题：黑板异或游戏
//黑板上写着一个非负整数数组 nums[i] 。Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。如果擦除一个数字后，剩余的所有数字按位异或
//运算得出的结果等于 0 的话，当前玩家游戏失败。 (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。） 
//
// 并且，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。 
//
// 假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。 
//
// 示例：
//输入: nums = [1, 1, 2]
//输出: false
//解释: 
//Alice 有两个选择: 擦掉数字 1 或 2。
//如果擦掉 1, 数组变成 [1, 2]。剩余数字按位异或得到 1 XOR 2 = 3。那么 Bob 可以擦掉任意数字，因为 Alice 会成为擦掉最后一个数
//字的人，她总是会输。
//如果 Alice 擦掉 2，那么数组变成[1, 1]。剩余数字按位异或得到 1 XOR 1 = 0。Alice 仍然会输掉游戏。
// 
// 提示：
// 1 <= N <= 1000
// 0 <= nums[i] <= 2^16 
// 
// Related Topics 位运算 脑筋急转弯 数组 数学 博弈 
// 👍 121 👎 0

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean duishuqi(int[] nums) {
            if (nums.length == 0) {
                return true;
            }
            int index = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != -1) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                return true;
            }
            int result = nums[index];
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] == -1) {
                    continue;
                }
                result ^= nums[i];
            }
            if (result == 0) {
                return true;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == -1) {
                    continue;
                }
                int temp = nums[i];
                nums[i] = -1;
                boolean tempResult = duishuqi(nums);
                nums[i] = temp;
                if (!tempResult) {
                    return true;
                }
            }
            return false;
        }

        public boolean xorGame(int[] nums) {
            return duishuqi(nums);
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
  
