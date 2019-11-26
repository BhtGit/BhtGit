package leetcode.linklist;

import java.math.BigInteger;

/**
 * @author ：BHT
 * @date ：2019-07-25 16:20
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    // 倒序
    public static BigInteger nodeToNum(ListNode node) {
        BigInteger num = BigInteger.ZERO;
        BigInteger index = BigInteger.ONE;
        while (node != null) {
            num = num.add(new BigInteger(Integer.toString(node.val)).multiply(index));
            index = index.multiply(BigInteger.TEN);
            node = node.next;
        }
        return num;
    }

    // 倒序
    public static ListNode numToNode(BigInteger num) {
        ListNode node = new ListNode(0);
        if (num.compareTo(BigInteger.ZERO) == 0) {
            return node;
        }
        ListNode temp = node;
        while (num.compareTo(new BigInteger("0")) != 0) {
            ListNode n = new ListNode(num.mod(BigInteger.TEN).intValue());
            num = num.divide(BigInteger.TEN);
            temp.next = n;
            temp = n;
        }
        return node.next;
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }
}
