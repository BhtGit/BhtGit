package leetcode.tempfile.leetcode.editor.cn;

/**
 * @author ：BHT
 * @date ：2021/10/26 10:28 下午
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node left;
    public Node right;
    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
