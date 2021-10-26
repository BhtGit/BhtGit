package leetcode.tempfile.leetcode.editor.cn;

public class FanZhuanLianBiaoLcof {
    /**
     * 2021-10-26 17:00:12
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(FanZhuanLianBiaoLcof.class);
        ListNode node = ListNode.getListNodeByArray(new int[]{1, 2, 3, 4, 5});
        node = solution.reverseList(node);
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }

// 第剑指 Offer 24题：反转链表
//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 👍 322 👎 0

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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head.next;
        head.next  = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = head;
            head = curr;
            curr = temp;
        }
        return head;
    }

}
}

//leetcode submit region end(Prohibit modification and deletion)

