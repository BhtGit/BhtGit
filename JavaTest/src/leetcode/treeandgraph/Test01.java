package leetcode.treeandgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 树和图
 * 树是图的简单表示形式，所以我们常用的两种图的遍历方法同样适用于树。
 * <p>
 * 我们推荐以下题目：中序遍历二叉树，每个节点的右向指针 和 岛屿的个数。
 * <p>
 * 请注意，很多树的问题会以n-array tree的形式出现，所以请确保你了解什么是n-array tree。
 * <p>
 * 说明：岛屿的个数这道题并不是一个树的问题，它可以用图的形式呈现，因此我们将它归类为图的问题。
 * <p>
 * 中序遍历二叉树
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * .  1
 * .   \
 * .    2
 * .   /
 * .  3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author ：BHT
 * @date ：2019-07-31 10:45
 */
public class Test01 {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
