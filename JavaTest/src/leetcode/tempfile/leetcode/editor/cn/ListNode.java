package leetcode.tempfile.leetcode.editor.cn;

/**
 * @author BHT 2021/1/13 14:58
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode getListNodeByArray(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode temp = head;
        for (int i = 1; i < array.length; i++) {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }
        return head;
    }
}
