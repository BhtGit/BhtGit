package leetcode.tempfile.leetcode.editor.cn;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {
    /**
     * 2021-02-18 16:29:26
     *
     * @author BHT
     */
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    zeroEvenOdd.zero(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    zeroEvenOdd.odd(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    zeroEvenOdd.even(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }

        Thread.sleep(2000);
        countDownLatch.countDown();


    }
}

// 第1116题：打印零与奇偶数
//假设有这么一个类： 
//
// class ZeroEvenOdd {
//  public ZeroEvenOdd(int n) { ... }      // 构造函数
//  public void zero(printNumber) { ... }  // 仅打印出 0
//  public void even(printNumber) { ... }  // 仅打印出 偶数
//  public void odd(printNumber) { ... }   // 仅打印出 奇数
//}
// 
// 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
// 线程 A 将调用 zero()，它只输出 0 。
// 线程 B 将调用 even()，它只输出偶数。 
// 线程 C 将调用 odd()，它只输出奇数。 
// 
// 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n
//。 
//
// 示例 1： 
// 输入：n = 2
//输出："0102"
//说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
//
// 示例 2： 
// 输入：n = 5
//输出："0102030405"
// 
// 👍 87 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class ZeroEvenOdd {
    private int n;

    private int flag = FLAG_ZERO;
    private int beforeZeroFlag = FLAG_EVEN;
    private static final int FLAG_ZERO = 0;
    private static final int FLAG_ODD = 1;
    private static final int FLAG_EVEN = 2;

    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionZero = lock.newCondition();
    private Condition conditionEven = lock.newCondition();
    private Condition conditionOdd = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag != FLAG_ZERO) {
                    conditionZero.await();
                }
                printNumber.accept(0);
                if (beforeZeroFlag == FLAG_EVEN) {
                    // 上一个是偶数
                    flag = FLAG_ODD;
                    conditionOdd.signal();
                } else {
                    // 上一个是奇数
                    flag = FLAG_EVEN;
                    conditionEven.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            lock.lock();
            try {
                while (flag != FLAG_EVEN) {
                    conditionEven.await();
                }
                printNumber.accept(i);
                beforeZeroFlag = FLAG_EVEN;
                flag = FLAG_ZERO;
                conditionZero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            lock.lock();
            try {
                while (flag != FLAG_ODD) {
                    conditionOdd.await();
                }
                printNumber.accept(i);
                beforeZeroFlag = FLAG_ODD;
                flag = FLAG_ZERO;
                conditionZero.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
