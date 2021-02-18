package leetcode.tempfile.leetcode.editor.cn;

import java.util.concurrent.CountDownLatch;

public class PrintInOrder {
    /**
     * 2021-02-18 15:32:35
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(PrintInOrder.class);

    }
}

// 第1114题：按序打印
// 我们提供了一个类：
//
// public class Foo {
//   public void first() { print("first"); }
//   public void second() { print("second"); }
//   public void third() { print("third"); }
// }
//
// 三个不同的线程 A、B、C 将会共用一个 Foo 实例。 
//
// 一个将会调用 first() 方法
// 一个将会调用 second() 方法 
// 还有一个将会调用 third() 方法 
// 
//
// 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。 
//
// 示例 1:
// 输入: [1,2,3]
// 输出: "firstsecondthird"
// 解释:
// 有三个线程会被异步启动。
// 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
// 正确的输出是 "firstsecondthird"。
// 
// 示例 2:
// 输入: [1,3,2]
// 输出: "firstsecondthird"
// 解释:
// 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
// 正确的输出是 "firstsecondthird"。
//
// 提示：
// 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
// 你看到的输入格式主要是为了确保测试的全面性。 
// 
// 👍 238 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/*class Foo {

    //    private CountDownLatch countDownLatchFirst;
    private CountDownLatch countDownLatchSecond;
    private CountDownLatch countDownLatchThird;

    public Foo() {
//        countDownLatchFirst = new CountDownLatch(1);
        countDownLatchSecond = new CountDownLatch(1);
        countDownLatchThird = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
//        countDownLatchFirst.await();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatchSecond.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatchSecond.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatchThird.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatchThird.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
//        countDownLatchFirst.countDown();
    }
}*/
class Foo {

    private final Object lock = new Object();
    /**
     * 当前线程运行的信号值
     */
    private int flag = FLAG_FIRST;
    /**
     * first线程可运行的信号值
     */
    private static final int FLAG_FIRST = 1;
    /**
     * second线程可运行的信号值
     */
    private static final int FLAG_SECOND = 2;
    /**
     * third线程可运行的信号值
     */
    private static final int FLAG_THIRD = 3;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (flag != FLAG_FIRST) {
                lock.wait();
            }
            printFirst.run();
            flag = FLAG_SECOND;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (flag != FLAG_SECOND) {
                lock.wait();
            }
            printSecond.run();
            flag = FLAG_THIRD;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (flag != FLAG_THIRD) {
                lock.wait();
            }
            printThird.run();
            flag = FLAG_FIRST;
            lock.notifyAll();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
