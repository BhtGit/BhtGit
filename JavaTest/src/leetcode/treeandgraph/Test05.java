package leetcode.treeandgraph;

/**
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * .      3
 * .     / \
 * .    1   4
 * .     \
 * .      2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * .          5
 * .         / \
 * .        3   6
 * .       / \
 * .      2   4
 * .     /
 * .    1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * @author ：BHT
 * @date ：2019-08-01 15:57
 */
public class Test05 {

    private int index;
    private int min;

    public int kthSmallest(TreeNode root, int k) {
        index = k;
        min(root);
        return min;
    }

    private void min(TreeNode root) {
        if (root == null || index == 0) {
            return;
        }
        min(root.left);
        if (--index == 0) {
            min = root.val;
            return;
        }
        min(root.right);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(6);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        Test05 t = new Test05();
        int i = t.kthSmallest(root, 1);
        System.out.println(i);

    }

}
