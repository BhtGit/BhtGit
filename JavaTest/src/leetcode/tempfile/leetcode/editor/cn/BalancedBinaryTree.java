package leetcode.tempfile.leetcode.editor.cn;

public class BalancedBinaryTree {
    /**
     * 2021-01-13 15:39:04
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(BalancedBinaryTree.class);
        Integer[] array = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(array);
        boolean balanced = solution.isBalanced(treeNode);
        System.out.println(balanced);

    }
    //leetcode submit region begin(Prohibit modification and deletion)


// 第110题：平衡二叉树
//给定一个二叉树，判断它是否是高度平衡的二叉树。
// 本题中，一棵高度平衡二叉树定义为：
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
// 示例 1：
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 示例 2：
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 示例 3：
//输入：root = []
//输出：true
// 提示：
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索 递归
// 👍 562 👎 0


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
 class Solution {
    public boolean isBalanced(TreeNode root) {
        int ints = calculateDeep(root, 0);
        return ints != Integer.MAX_VALUE;
    }

    /**
     * 计算树深度
     *
     * @param root 树
     * @param deep 当前树深度
     * @return 返回子树深度，如果子树深度为Integer.MAX_VALUE则证明该树不是高度平衡二叉树
     */
    private int calculateDeep(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        deep++;
        int left = calculateDeep(root.left, deep);
        if (left == Integer.MAX_VALUE) {
            return left;
        }
        int right = calculateDeep(root.right, deep);
        return Math.abs(left - right) > 1 ? Integer.MAX_VALUE : Math.max(left, right);
    }

    /**
     * 计算树的最深子节点和最浅子节点
     *
     * @param root 树
     * @param deep 当前节点深度
     * @return 0为子树的最深位置，1为子树的高度差
     */
    private int[] calculateDeep1(TreeNode root, int deep) {
        if (root == null) {
            return new int[]{deep, 0};
        }
        deep++;
        int[] left = calculateDeep1(root.left, deep);
        if (left[1] > 1) {
            return left;
        }
        int[] right = calculateDeep1(root.right, deep);
        if (right[1] > 1) {
            return right;
        }
        return new int[]{Math.max(left[0], right[0]), Math.abs(left[0] - right[0])};
    }

    /**
     * 计算树的最深子节点和最浅子节点
     * 算错了，这个是算的树最深节点和最浅节点之间的差
     *
     * @param root 树
     * @param deep 当前节点深度
     * @return 0为深，1为浅
     */
    private int[] calculateDeepAbandon(TreeNode root, int deep) {
        if (root == null) {
            return new int[]{deep, deep};
        }
        deep++;
        int[] left = calculateDeepAbandon(root.left, deep);
        int[] right = calculateDeepAbandon(root.right, deep);

        if (left[0] < right[0]) {
            left[0] = left[0] + right[0];
            right[0] = left[0] - right[0];
            left[0] = left[0] - right[0];
        }
        if (left[1] > right[1]) {
            left[1] = left[1] + right[1];
            right[1] = left[1] - right[1];
            left[1] = left[1] - right[1];
        }
        return left;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
}

