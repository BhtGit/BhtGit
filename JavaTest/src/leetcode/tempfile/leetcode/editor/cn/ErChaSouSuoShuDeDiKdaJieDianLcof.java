package leetcode.tempfile.leetcode.editor.cn;

public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    /**
     * 2021-11-08 22:07:45
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ErChaSouSuoShuDeDiKdaJieDianLcof.class);
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(new Integer[]{5,3,6,2,4,null,null,1});
        int i = solution.kthLargest(treeNode, 3);
        System.out.println(i);
    }
//}

// 第剑指 Offer 54题：二叉搜索树的第k大节点
//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 示例 1: 
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 218 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    int maxK;
    int count;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return maxK;
    }

    public void dfs(TreeNode node) {
        if (node == null || count == 0) {
            return;
        }
        dfs(node.right);
        if (count-- == 1) {
            maxK = node.val;
            count = 0;
            return;
        }
        dfs(node.left);
    }

}
}
//leetcode submit region end(Prohibit modification and deletion)
  
