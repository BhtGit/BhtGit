package leetcode.treeandgraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 示例：
 * .        1                           1----->null
 * .      /   \                       /   \
 * .     2     3                     2---->3----->null
 * .    / \   / \                   / \   / \
 * .   4  5  6  7                  4->5->6->7----->null
 * .
 * .
 * .            0
 * .            /\
 * .       0         0
 * .      /\         /\
 * .     0  0      0    0
 * .   /\   /\    /\    /\
 * .  8 9 10 11 12 13 14 15
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * <p>
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * <p>
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * @author ：BHT
 * @date ：2019-08-01 15:13
 */
public class Test04 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> parentNodes = new ArrayList<>();
        parentNodes.add(root);
        connect(parentNodes);
        return root;
    }

    private void connect(List<Node> parentNodes) {
        List<Node> childNodes = new ArrayList<>();
        for (int i = 0; i < parentNodes.size(); i++) {
            Node parentNode = parentNodes.get(i);
            if (i == parentNodes.size() - 1) {
                parentNode.next = null;
            } else {
                parentNode.next = parentNodes.get(i + 1);
            }
            if (parentNode.left != null) {
                childNodes.add(parentNode.left);
                childNodes.add(parentNode.right);
            }
        }
        if (childNodes.size() > 0) {
            connect(childNodes);
        }
    }

}
