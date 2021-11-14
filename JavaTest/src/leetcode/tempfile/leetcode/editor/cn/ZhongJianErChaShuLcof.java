package leetcode.tempfile.leetcode.editor.cn;

public class ZhongJianErChaShuLcof {
    /**
     * 2021-11-12 20:37:58
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ZhongJianErChaShuLcof.class);
        TreeNode treeNode = solution.buildTree(new int[]{}, new int[]{});
        System.out.println(treeNode);
    }
//}

// 第剑指 Offer 07题：重建二叉树
//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
// 示例 1:
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
//
// 示例 2: 
//
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
// 限制：
// 0 <= 节点个数 <= 5000
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 614 👎 0

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

    // TODO 先赶紧下一道，这个待会优化，不使用额外空间
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }
        // 查找左右子树
        int[] leftPre = null;
        int[] leftIn = null;
        int[] rightPre = null;
        int[] rightIn = null;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] != root.val) {
                continue;
            }
            // 得出左子树 左子树长度i
            leftPre = new int[i];
            leftIn = new int[i];
            System.arraycopy(preorder, 1, leftPre, 0, i);
            System.arraycopy(inorder, 0, leftIn, 0, i);

            if (i != inorder.length - 1) {
                // 剩下的是右子树
                int rightLength = inorder.length - i - 1;
                rightPre = new int[rightLength];
                rightIn = new int[rightLength];
                System.arraycopy(preorder, i + 1, rightPre, 0, rightLength);
                System.arraycopy(inorder, i + 1, rightIn, 0, rightLength);
            }
            break;
        }
        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);
        return root;
    }

    /*private TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        // 查找左右子树
        int[] leftPre = null;
        int[] leftIn = null;
        int[] rightPre = null;
        int[] rightIn = null;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] != root.val) {
                continue;
            }
            // 得出左子树

            if (i != inorder.length - 1) {
                // 剩下的是右子树
                int rightLength = inorder.length - i - 1;
                rightPre = new int[rightLength];
                rightIn = new int[rightLength];
                System.arraycopy(preorder, i + 1, rightPre, 0, rightLength);
                System.arraycopy(inorder, i + 1, rightIn, 0, rightLength);
            }
        }
        root.left = buildTree(leftPre.toArray(), leftIn.toArray());


    }*/


}
}
//leetcode submit region end(Prohibit modification and deletion)
  
