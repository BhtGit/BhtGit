package leetcode.tempfile.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    /**
     * 2021-11-08 19:35:35
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof.class);
        TreeNode root = TreeNodeUtil.arrayToTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        List<List<Integer>> lists = solution.pathSum1(root, 22);
        lists.forEach(list -> {
            list.forEach(item -> {
                System.out.print(item);
                System.out.print("-");
            });
            System.out.println();
        });
    }
//}

// 第剑指 Offer 34题：二叉树中和为某一值的路径
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
//
// 示例 2： 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
//
// 示例 3： 
//输入：root = [1,2], targetSum = 0
//输出：[]
//
// 提示： 
// 树中节点总数在范围 [0, 5000] 内
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 259 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

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

    public List<List<Integer>> pathSum1(TreeNode root, int target) {
        if (root == null) {
            // 递推完毕
            return new LinkedList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> rootList = new LinkedList<>();
        rootList.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            res.add(rootList);
            return res;
        }
        List<List<Integer>> leftList = pathSum1(root.left, target - root.val);
        List<List<Integer>> rightList = pathSum1(root.right, target - root.val);
        for (List<Integer> left : leftList) {
            List<Integer> sub = new LinkedList<>(rootList);
            sub.addAll(left);
            res.add(sub);
        }
        for (List<Integer> right : rightList) {
            List<Integer> sub = new LinkedList<>(rootList);
            sub.addAll(right);
            res.add(sub);
        }
        return res;
    }

    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0){
            res.add(new LinkedList<>(path));
        }
        dfs(root.left,target);
        dfs(root.right,target);
        path.pollLast();
    }

}
}
//leetcode submit region end(Prohibit modification and deletion)
  
