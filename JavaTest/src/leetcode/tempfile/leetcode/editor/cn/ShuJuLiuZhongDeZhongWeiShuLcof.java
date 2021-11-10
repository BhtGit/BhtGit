package leetcode.tempfile.leetcode.editor.cn;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShuJuLiuZhongDeZhongWeiShuLcof {
    /**
     * 2021-11-09 23:30:16
     *
     * @author BHT
     */
    public static void main(String[] args) {
        MedianFinder medianFinder = (MedianFinder) Common.getSolution(ShuJuLiuZhongDeZhongWeiShuLcof.class, "MedianFinder");
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());

    }
//}

// 第剑指 Offer 41题：数据流中的中位数
//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
// [2,3,4] 的中位数是 3
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//
// 设计一个支持以下两种操作的数据结构： 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。
// double findMedian() - 返回目前所有元素的中位数。 
//
// 示例 1： 
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
// 示例 2：
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 限制：
// 最多会对 addNum、findMedian 进行 50000 次调用。
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-
//stream/ 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 200 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

    // 小根堆存储较大的一半
    Queue<Integer> smallRoot = new PriorityQueue<>();
    // 大根堆存储较小的一半
    Queue<Integer> bigRoot = new PriorityQueue<>(Collections.reverseOrder());

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum1(int num) {
        if (smallRoot.size() == bigRoot.size()) {
            // 偶数个，往小根堆丢
            bigRoot.offer(num);
            smallRoot.offer(bigRoot.poll());
        } else {
            smallRoot.offer(num);
            bigRoot.offer(smallRoot.poll());
        }
    }

    public double findMedian1() {
        if (smallRoot.isEmpty()) {
            return 0;
        }
        if (smallRoot.size() == bigRoot.size()) {
            // 偶数个
            return (smallRoot.peek() + bigRoot.peek()) / 2.0;
        } else {
            return smallRoot.peek();
        }
    }

    public void addNum(int num) {
        if (smallRoot.isEmpty() || smallRoot.peek() < num) {
            smallRoot.offer(num);
        } else {
            bigRoot.offer(num);
        }

        if (smallRoot.size() > bigRoot.size() + 1) {
            // 相差超过1
            bigRoot.offer(smallRoot.poll());
        } else if (smallRoot.size() + 1 < bigRoot.size()) {
            smallRoot.offer(bigRoot.poll());
        }
    }

    public double findMedian() {
        if (smallRoot.isEmpty()) {
            return 0;
        }
        if (smallRoot.size() == bigRoot.size()) {
            // 偶数个
            return (smallRoot.peek() + bigRoot.peek()) / 2.0;
        } else if (smallRoot.size() > bigRoot.size()) {
            return smallRoot.peek();
        } else {
            return bigRoot.peek();
        }
    }
}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
  
