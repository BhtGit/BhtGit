package leetcode.tempfile.leetcode.editor.cn;
// 第24题：两两交换链表中的节点
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
// 示例 1：
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 示例 2：
//输入：head = []
//输出：[]
// 示例 3：
//输入：head = [1]
//输出：[1]
// 提示：
// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100 
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
// Related Topics 递归 链表 
// 👍 779 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

public class SwapNodesInPairs {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode temp = head.next.next;
            ListNode next = head.next;
            head.next = temp;
            next.next = head;
            head = next;
            head.next.next = swapPairs(head.next.next);
            return head;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    /**
     * 2021-01-13 14:02:59
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        ListNode node = new ListNode(1);
        ListNode temp = node;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(1);
        temp = temp.next;
        temp.next = new ListNode(5);
        ListNode node1 = solution.swapPairs(node);
        while (node1 != null) {
            System.out.print(node1.val + "->");
            node1 = node1.next;
        }

    }
}