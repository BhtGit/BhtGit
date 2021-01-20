package leetcode.tempfile.leetcode.editor.cn;

public class BinaryTreeMaximumPathSum {
    /**
     * 2021-01-15 10:03:22
     *
     * @author BHT
     */
    public static void main(String[] args) throws ClassNotFoundException {

        Solution solution = (Solution) Common.getSolution(BinaryTreeMaximumPathSum.class);
        Integer[] array = new Integer[]{1,1,1,100,100,1,1};
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(array);
        solution.maxPathSum(treeNode);
        int i = solution.maxPathSum(treeNode);
        System.out.println(i);
    }
// 第124题：二叉树中的最大路径和
//给你一个二叉树的根节点 root ，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径 至少包含一个 节点，且不一定经过根节点。 
//
// 示例 1： 
//输入：root = [1,2,3]
//输出：6
//
// 示例 2：
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
// 
// 提示：
// 树中节点数目范围是 [1, 3 * 104]
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 846 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 每个子节点到另一个子节点的路径是唯一的
 */
class Solution {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         Q：左右孩子贡献为什么要大于等于0？
         A: 因为计算从某一节点出发的路径和的时候，计算公式为： 当前节点值 + 左孩子贡献 + 右孩子贡献，
         而左右孩子贡献是「可选的」，也就是说当某一边贡献小于0的时候，我可以在计算路径和时不算这一边
         这种情况也就相当于其贡献为 0，但是注意路径和至少包含「当前节点的值」。
         **/
        int leftMax  = Math.max(0, dfs(root.left));         // 左孩子贡献
        int rightMax = Math.max(0, dfs(root.right));        // 右孩子贡献
        res = Math.max(res, root.val + leftMax + rightMax); // 更新res 主要是全局变量的功劳
        return root.val + Math.max(leftMax, rightMax);      // 返回当前节点的总贡献
    }


    /**
     * 先算出左子树单边最大和右子树单边最大
     * 如果要当前节点，则取值为左+右+root
     * 如果不要当前节点，则取值为左子树或右子树的值
     *
     * @param root
     * @return
     */
//        public int maxPathSum(TreeNode root) {
//            if (root == null) {
//                return Integer.MIN_VALUE;
//            }
//
//            // 如果要当前节点  左子树单边+右子树单边+root
//            int needRootLeft = calMaxSide(root.left);
//            int needRootRight = calMaxSide(root.right);
//            int needRoot = Math.max(needRootLeft, 0) + Math.max(needRootRight, 0) + root.val;
//
//            // 如果不要当前节点
//            int notRootLeft = maxPathSum(root.left);
//            int notRootRight = maxPathSum(root.right);
//            int notRoot = Math.max(notRootLeft, notRootRight);
//
//            return Math.max(needRoot, notRoot);
//        }
//
//        private int calMaxSide(TreeNode root) {
//            if (root == null) {
//                return Integer.MIN_VALUE;
//            }
//            int left = calMaxSide(root.left);
//            int right = calMaxSide(root.right);
//            return root.val + Math.max(0, Math.max(left, right));
//
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
