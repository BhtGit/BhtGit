package leetcode.tempfile.leetcode.editor.cn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintFoobarAlternately {
    /**
     * 2021-02-18 16:08:51
     *
     * @author BHT
     */
    public static void main(String[] args) {
        Solution solution = (Solution) Common.getSolution(PrintFoobarAlternately.class);

    }
}

// 第1115题：交替打印FooBar
//我们提供一个类： 
//
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
//
// 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。 
// 请设计修改程序，以确保 "foobar" 被输出 n 次。
//
// 示例 1: 
//输入: n = 1
//输出: "foobar"
//解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
//
// 示例 2: 
//输入: n = 2
//输出: "foobarfoobar"
//解释: "foobar" 将被输出两次。
// 
// 👍 92 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class FooBar {
    private int n;

//    private final Object lock = new Object();
    /**
     * 当前线程运行的信号值
     */
    private int flag = FLAG_FOO;
    /**
     * foo线程可运行的信号值
     */
    private static final int FLAG_FOO = 0;
    /**
     * bar线程可运行的信号值
     */
    private static final int FLAG_BAR = 1;

    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionFoo = lock.newCondition();
    private Condition conditionBar = lock.newCondition();


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag != FLAG_FOO) {
                    conditionFoo.await();
                }
                printFoo.run();
                flag = FLAG_BAR;
                conditionBar.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag != FLAG_BAR) {
                    conditionBar.await();
                }
                printBar.run();
                flag = FLAG_FOO;
                conditionFoo.signal();
            } finally {
                lock.unlock();
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
