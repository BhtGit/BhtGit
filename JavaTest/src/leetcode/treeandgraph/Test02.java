package leetcode.treeandgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * .   3
 * .  / \
 * . 9  20
 * .   /  \
 * .  15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * .[
 * .  [3],
 * .  [20,9],
 * .  [15,7]
 * .]
 *
 * @author ：BHT
 * @date ：2019-07-31 10:59
 */
public class Test02 {
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return lists;
        }
        List<TreeNode> parentNodes = new ArrayList<>();
        parentNodes.add(root);
        getList(parentNodes, false);
        return lists;

    }

    private void getList(List<TreeNode> parentNodes, boolean isLeft) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> childNodes = new ArrayList<>();
        for (int i = parentNodes.size() - 1; i >= 0; i--) {
            TreeNode parentNode = parentNodes.get(i);
            if (parentNode != null) {
                list.add(parentNode.val);
                if (isLeft) {
                    childNodes.add(parentNode.right);
                    childNodes.add(parentNode.left);
                } else {
                    childNodes.add(parentNode.left);
                    childNodes.add(parentNode.right);
                }
            }
        }
        if (childNodes.size() > 0) {
            lists.add(list);
            getList(childNodes, !isLeft);
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(5);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        Test02 t = new Test02();
        List<List<Integer>> lists = t.zigzagLevelOrder(root);
        System.out.println(lists);


    }


}
