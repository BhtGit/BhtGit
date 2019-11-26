package leetcode.linklist;

import java.math.BigInteger;

/**
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @author ：BHT
 * @date ：2019-07-25 16:19
 */
public class Test02 {
    public ListNode oddEvenList(ListNode head) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode temp = head;
        ListNode tempH = node1;
        ListNode tempN = node2;
        for (int i = 0;;) {
            if (i % 2 != 0) {
                tempN.next = temp;
                tempN = tempN.next;
                tempH.next = null;
            }
            if (temp.next == null){
                tempH.next = node2.next;
                break;
            }
            i++;
            temp = temp.next;
        }
        head = node1.next;
        return head;
    }
    public ListNode oddEvenList2(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode temp = head;
        ListNode tempN = node;
        for (int i = 0;;) {
            if (i % 2 != 0) {
                tempN.next = temp;
                tempN = tempN.next;
                temp.next = temp.next.next;
            }
            if (temp.next == null){
                temp.next = node.next;
                break;
            }
            i++;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        BigInteger a = new BigInteger("12345");
        ListNode listNode = ListNode.numToNode(a);
        Test02 t = new Test02();
        t.oddEvenList2(listNode);
        while (listNode!=null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }

    }

}
