package leetcode.tempfile.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ShuDeZiJieGouLcof {
    /**
     * 2021-10-31 20:55:48
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ShuDeZiJieGouLcof.class);
        TreeNode A = TreeNodeUtil.arrayToTreeNode(new Integer[]{1, 0, 1, -4, -3});
        TreeNode B = TreeNodeUtil.arrayToTreeNode(new Integer[]{1, -4});
        System.out.println(solution.isSubStructure(A, B));

    }

// 第剑指 Offer 26题：树的子结构
//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
// 3
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
// 4
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
// 输入：A = [1,2,3], B = [3,1]
//输出：false
//
// 示例 2： 
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
// 0 <= 节点个数 <= 10000
// Related Topics 树 深度优先搜索 二叉树 👍 383 👎 0

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

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 不进行先序遍历
        if (A.val == B.val&&isSub(A.left,B.left)&&isSub(A.right,B.right)) {
            return true;
        }
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        // 先序遍历，中左右
        List<TreeNode> treeA = preOrderTree(A);
        for (TreeNode node : treeA) {
            if (isSub(node, B)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断B是否能完全贴合到A中
     *
     * @param A
     * @param B
     * @return
     */
    private boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return isSub(A.left, B.left) && isSub(A.right, B.right);

    }


    public List<TreeNode> preOrderTree(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        setPreOrderTreeToList(root, res);
        return res;
    }

    private void setPreOrderTreeToList(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        list.addAll(preOrderTree(node.left));
        list.addAll(preOrderTree(node.right));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}

