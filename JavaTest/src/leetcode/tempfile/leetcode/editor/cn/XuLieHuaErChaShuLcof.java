package leetcode.tempfile.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2021-11-21 20:40:04
 *
 * @author BHT
 */
public class XuLieHuaErChaShuLcof {

    public static void main(String[] args) {
        Codec solution = (Codec) Common.getSolution(XuLieHuaErChaShuLcof.class, "Codec");
        TreeNode treeNode = TreeNodeUtil.arrayToTreeNode(new Integer[]{1, 2, 3, null, null, 4, 5});
        String serialize = solution.serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = solution.deserialize(serialize);
        System.out.println(deserialize);
    }
//}

// 第剑指 Offer 37题：序列化二叉树
//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 示例： 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 245 👎 0

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
 class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null");
            } else {
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            sb.append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return arrayToTreeNode(data);
    }

    /**
     * 层次遍历数组还原二叉树
     */
    public  TreeNode arrayToTreeNode(String data) {
        if (data == null) {
            return null;
        }
        String[] array = data.split(",");
        if (array.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode treeNode = new TreeNode(Integer.parseInt(array[0]));
        queue.offer(treeNode);
        // 是否要插入左子树
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++, isLeft = !isLeft) {
            if ("null".equals(array[i])) {
                if (!isLeft) {
                    // 右节点操作过后将节点弹出
                    queue.poll();
                }
                continue;
            }
            TreeNode tempNode = new TreeNode(Integer.parseInt(array[i]));
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
}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
  
