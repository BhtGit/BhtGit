package leetcode.tempfile.leetcode.editor.cn;

public class BaoHanMinhanShuDeZhanLcof {
    /**
     * 2021-10-25 23:00:29
     * @author BHT
     */
    public static void main(String[] args) {
        MinStack solution = (MinStack) Common.getSolution(BaoHanMinhanShuDeZhanLcof .class);
    }
}

// 第剑指 Offer 30题：包含min函数的栈
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//
//
//
// 示例:
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// 各函数的调用总次数不超过 20000 次
//
//
//
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
// Related Topics 栈 设计 👍 210 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    // 方法2、用一个链表，每个节点存储当前数据和最小值
    // 方法3、维护两个栈，一个栈存储当前值，一个栈存储最小值
    Integer[] arr = new Integer[20000];
    Integer[] beforeCurrMinIndex = new Integer[20000];

    int currIndex = -1;

    int minValueIndex = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        arr[++currIndex] = x;
        // 在此之前最小的数的下标
        beforeCurrMinIndex[currIndex] = minValueIndex;
        if (arr[minValueIndex] > x) {
            minValueIndex = currIndex;
        }
    }

    public void pop() {
        if (currIndex < 0) {
            return;
        }
        if (currIndex == minValueIndex) {
            minValueIndex = beforeCurrMinIndex[minValueIndex];
        }
        currIndex--;
    }

    public int top() {
        return arr[currIndex];
    }

    public int min() {
        return arr[minValueIndex];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

