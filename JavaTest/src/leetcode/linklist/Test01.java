package leetcode.linklist;

import java.math.BigInteger;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @author ：BHT
 * @date ：2019-07-25 15:09
 */

public class Test01 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return ListNode.numToNode(ListNode.nodeToNum(l1).add(ListNode.nodeToNum(l2)));
    }

    public static void main(String[] args) {

        Test01 t = new Test01();

        BigInteger a = new BigInteger("5");
        BigInteger b = new BigInteger("5");


        ListNode an = ListNode.numToNode(a);
        ListNode bn = ListNode.numToNode(b);

        System.out.println(t.addTwoNumbers2(an, bn));

    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode node = new ListNode(0);
        ListNode temp = node;
        int a,b;
        int num = 0;

        while (l1!=null || l2!=null || num !=0) {
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            } else {
                a = 0;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            } else {
                b = 0;
            }
            temp.next = new ListNode((a + b + num) % 10);
            temp = temp.next;
            num = (a + b + num) / 10;
        }
        return node.next;
    }

}
