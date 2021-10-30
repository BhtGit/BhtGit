package leetcode.tempfile.leetcode.editor.cn;

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    /**
     * 2021-10-30 23:41:23
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(CongShangDaoXiaDaYinErChaShuIiiLcof.class);
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        System.out.println(lists);
    }
//}

// 第剑指 Offer 32 - III题：从上到下打印二叉树 III
//请实现一个函数按照之字形顺序打印二叉树，
// 即第一行按照从左到右的顺序打印，
// 第二层按照从右到左的顺序打印，
// 第三行再按照从左到右的顺序打印，其他行以此类推。
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7], 
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回其层次遍历结果： 
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
// 提示： 
// 节点总数 <= 1000
// Related Topics 树 广度优先搜索 二叉树 👍 151 👎 0

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean lefToRight = true;

        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            res.add(list);
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node;
                if (lefToRight) {
                    node = deque.pollFirst();
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                } else {
                    node = deque.pollLast();
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                }
                list.add(node.val);
            }
            lefToRight = !lefToRight;
        }
        return res;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
