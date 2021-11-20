package leetcode.tempfile.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2021-11-20 23:21:11
 *
 * @author BHT
 */
public class DuiLieDeZuiDaZhiLcof {

    public static void main(String[] args) {
        MaxQueue solution = (MaxQueue) Common.getSolution(DuiLieDeZuiDaZhiLcof.class, "MaxQueue");

    }
//}

// 第剑指 Offer 59 - II题：队列的最大值
//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 设计 队列 单调队列 👍 294 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class MaxQueue {

    Queue<Integer> queue = new LinkedList<>();
    Deque<Integer> deque = new LinkedList<>();


    public MaxQueue() {

    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (deque.peekFirst().equals(queue.peek())) {
            deque.pollFirst();
        }
        return queue.poll();
    }
}
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)
  
