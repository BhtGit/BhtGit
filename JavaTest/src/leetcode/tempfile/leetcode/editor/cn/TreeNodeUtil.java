package leetcode.tempfile.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author BHT 2021/1/13 16:03
 */
public class TreeNodeUtil {

    /**
     * 层次遍历数组还原二叉树
     */
    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode treeNode = new TreeNode(array[0]);
        queue.offer(treeNode);
        // 是否要插入左子树
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++, isLeft = !isLeft) {
            if (array[i] == null) {
                if (!isLeft) {
                    // 右节点操作过后将节点弹出
                    queue.poll();
                }
                continue;
            }
            TreeNode tempNode = new TreeNode(array[i]);
            // 有效的子节点都放进队列中
            queue.offer(tempNode);
            if (isLeft) {
                queue.peek().left = tempNode;
            } else {
                queue.poll().right = tempNode;
            }
        }
        return treeNode;
    }

    /**
     * 先序遍历
     */
    public static List<TreeNode> preOrderTree(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        setPreOrderTreeToList(root, res);
        return res;
    }

    private static void setPreOrderTreeToList(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        list.addAll(preOrderTree(node.left));
        list.addAll(preOrderTree(node.right));
    }


    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, 2, null, 15, 7};
        TreeNode treeNode = arrayToTreeNode(array);
        System.out.println(treeNode);
        List<TreeNode> treeNodes = preOrderTree(treeNode);
        treeNodes.forEach(node-> System.out.print(node.val+","));
        System.out.println();
    }

}
