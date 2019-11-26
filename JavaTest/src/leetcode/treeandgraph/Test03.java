package leetcode.treeandgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * .    3
 * .   / \
 * .  9  20
 * .    /  \
 * .   15   7
 *
 * @author ：BHT
 * @date ：2019-07-31 13:28
 */
public class Test03 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null) {
            return null;
        }

        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();

        Arrays.stream(preorder).forEach(preorderList::add);
        Arrays.stream(inorder).forEach(inorderList::add);

        return childTree(preorderList, inorderList);
    }

    private TreeNode childTree(List<Integer> preorderList, List<Integer> inorderList) {
        if (preorderList.size() == 0) {
            return null;
        }
        if (preorderList.size() == 1) {
            return new TreeNode(preorderList.get(0));
        }
        List<Integer> leftPreList = new ArrayList<>();
        List<Integer> rightPreList = new ArrayList<>();
        List<Integer> leftInList = new ArrayList<>();
        List<Integer> rightInList = new ArrayList<>();

        TreeNode root = new TreeNode(preorderList.get(0));
        boolean isLeft = true;
        for (int node : inorderList) {
            if (node == root.val) {
                isLeft = false;
                continue;
            }
            if (isLeft) {
                leftInList.add(node);
            } else {
                rightInList.add(node);
            }
        }
        for (int i = 1; i < preorderList.size(); i++) {
            if (i <= leftInList.size()) {
                leftPreList.add(preorderList.get(i));
            } else {
                rightPreList.add(preorderList.get(i));
            }
        }

        root.left = childTree(leftPreList, leftInList);
        root.right = childTree(rightPreList, rightInList);

        return root;
    }

    public static void main(String[] args) {
        int[] a = {3, 9, 20, 15, 7};
        int[] b = {9, 3, 15, 20, 7};

        Test03 t = new Test03();
        TreeNode treeNode = t.buildTree(a, b);
        System.out.println(treeNode);
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTree(preorder.length, preorder, 0, inorder, 0);
    }

    // 从前序和中序构造二叉树，前序和中序是大数组中的一段[start, start + count)
    private TreeNode buildTree(int count, int[] preOrder, int preStart, int[] inOrder, int inStart) {
        if (count <= 0) {
            return null;
        }

        int rootValue = preOrder[preStart];
        TreeNode root = new TreeNode(rootValue);

        // 从inorder中找到root值，(inorder)左边就是左子树，(inorder)右边就是右子树
        // 然后在preorder中，数出与inorder中相同的个数即可
        int pos = inStart + count - 1;
        for (; pos >= inStart; --pos) {
            if (inOrder[pos] == rootValue) {
                break;
            }
        }
        int leftCount = pos - inStart;
        int rightCount = inStart + count - pos - 1;

        if (leftCount > 0) {
            int leftInStart = inStart;
            int leftPreStart = preStart + 1;
            root.left = buildTree(leftCount, preOrder, leftPreStart, inOrder, leftInStart);
        }

        if (rightCount > 0) {
            int rightInStart = pos + 1;
            int rightPreStart = preStart + 1 + leftCount;
            root.right = buildTree(rightCount, preOrder, rightPreStart, inOrder, rightInStart);
        }

        return root;
    }


}
