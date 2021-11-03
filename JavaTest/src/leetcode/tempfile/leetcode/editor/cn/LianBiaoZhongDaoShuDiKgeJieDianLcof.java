package leetcode.tempfile.leetcode.editor.cn;

import java.util.Stack;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    /**
     * 2021-11-03 21:58:45
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(LianBiaoZhongDaoShuDiKgeJieDianLcof.class);

    }
//}

// 第剑指 Offer 22题：链表中倒数第k个节点
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
// 示例：
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//返回链表 4->5.
// Related Topics 链表 双指针 👍 293 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd1(ListNode head, int k) {
        // 方法1，用一个栈
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        for (int i = 1; i < k; i++) {
            stack.pop();
        }
        return stack.pop();
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        for (temp = head; count > k; count--) {
            temp = temp.next;
        }
        return temp;
    }

    // 双指针，快慢指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
}
//leetcode submit region end(Prohibit modification and deletion)
  
