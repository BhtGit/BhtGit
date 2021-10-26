package leetcode.tempfile.leetcode.editor.cn;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    /**
     * 2021-10-26 15:00:51
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(CongWeiDaoTouDaYinLianBiaoLcof.class);
        ListNode listNodeByArray = ListNode.getListNodeByArray(new int[]{1,2,3,4,5});
        int[] ints = solution.reversePrint(listNodeByArray);
        for (int anInt : ints) {
            System.out.print(anInt);
            System.out.print(",");
        }
        System.out.println();
    }

// 第剑指 Offer 06题：从尾到头打印链表
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 示例 1：
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 限制：
// 0 <= 链表长度 <= 10000
// Related Topics 栈 递归 链表 双指针 👍 196 👎 0
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

    // 计数
    int nodeCount = 0;

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        ListNode node = reverseList(null, head);

        int[] result = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            result[i] = node.val;
            node = node.next;
        }

        return result;
    }

    // 将链表逆序
    private ListNode reverseList(ListNode prefix, ListNode node) {
        if (node == null) {
            return prefix;
        }
        nodeCount++;
        ListNode suffix = node.next;
        node.next = prefix;
        return reverseList(node, suffix);
    }
}
}

//leetcode submit region end(Prohibit modification and deletion)

