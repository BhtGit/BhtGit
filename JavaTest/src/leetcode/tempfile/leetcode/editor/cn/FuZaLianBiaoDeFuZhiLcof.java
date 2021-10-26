package leetcode.tempfile.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FuZaLianBiaoDeFuZhiLcof {
    /**
     * 2021-10-26 22:27:46
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(FuZaLianBiaoDeFuZhiLcof.class);

    }

// 第剑指 Offer 35题：复杂链表的复制
//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 示例 1：
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//
// 示例 2： 
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
// 示例 3：
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
//
// 示例 4： 
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
// 提示：
// -10000 <= Node.val <= 10000
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-
//pointer/ 
//
// Related Topics 哈希表 链表 👍 327 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// 方法一、用哈希表
class Solution1 {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = cachedNode.get(head.random);
        }
        return cachedNode.get(head);
    }
}

// 迭代+节点拆分，省去hash表空间
// A->B->C  拆分为 A->A'->B->B'->C->C'
// A'->b'->c'就是复制好的链表
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 组装链表
        Node tempHead = head;
        while (tempHead != null) {
            Node nodeNew = new Node(tempHead.val);
            // 把A'串进去
            nodeNew.next = tempHead.next;
            tempHead.next = nodeNew;

            tempHead = nodeNew.next;
        }

        // 计算随机节点
        tempHead = head;
        while (tempHead != null) {
            Node tempNew = tempHead.next;
            tempNew.random = tempHead.random == null ? null : tempHead.random.next;

            tempHead = tempNew.next;
        }

        // 拆分链表
        Node newHead = head.next;
        tempHead = head.next;
        Node pre = head;
        while(tempHead.next != null) {
            pre.next = pre.next.next;
            tempHead.next = tempHead.next.next;
            pre = pre.next;
            tempHead = tempHead.next;
        }
        pre.next = null;

        return newHead;
    }
}
}

//leetcode submit region end(Prohibit modification and deletion)
  
