package leetcode.linklist;

import java.math.BigInteger;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 如下面的两个链表：
 * ---a1>a2\
 * --------c1-c2-c3
 * b1>b2>b3/
 * 在节点 c1 开始相交
 * 输入两个链表，输出相交的节点
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author ：BHT
 * @date ：2019-07-25 19:37
 */
public class Test03 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        while (nodeA != null) {
            ListNode nodeB = headB;
            while (nodeB != null) {
                if (nodeA == nodeB) {
                    return nodeA;
                }
                nodeB = nodeB.next;
            }
            nodeA = nodeA.next;
        }
        return null;
    }

    /**
     * 最佳答案
     * 先把较长的链表超出部分削掉
     * 然后顺位往下比较，直至相同或结束
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int a = 0;
        int b = 0;
        while (nodeA != null) {
            a++;
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            b++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        if (a > b) {
            while (a != b) {
                nodeA = nodeA.next;
                a--;
            }
        } else {
            while (a != b) {
                nodeB = nodeB.next;
                b--;
            }
        }
        while (nodeA != null) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return null;
    }

    public static void main(String[] args) {

        BigInteger a = new BigInteger("222");
        BigInteger b = new BigInteger("11");
        BigInteger c = new BigInteger("345");

        ListNode headA = ListNode.numToNode(a);
        ListNode headB = ListNode.numToNode(b);
        ListNode headC = ListNode.numToNode(c);

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (true) {
            if (nodeA.next == null) {
                nodeA.next = headC;
                break;
            }
            nodeA = nodeA.next;
        }
        while (true) {
            if (nodeB.next == null) {
                nodeB.next = headC;
                break;
            }
            nodeB = nodeB.next;
        }

        Test03 t = new Test03();
        ListNode node = t.getIntersectionNode(headA, headB);
        System.out.println(node);
        System.out.println(node == headC);

    }

}
