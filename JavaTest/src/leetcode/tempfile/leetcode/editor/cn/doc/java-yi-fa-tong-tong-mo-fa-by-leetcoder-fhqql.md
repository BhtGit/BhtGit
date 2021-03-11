### 解题思路
牢记套路模板：
> 1、AtomicInteger 标记量
> 2、锁资源
> 3、wait、notify/notifyAll 的使用(变种就是本文中的 await 和 singal)
> 4、条件阻塞
> 5、循环条件（一般都是最外层）

### 代码

```java
class FooBar {
    private int n;
    private AtomicInteger flag = new AtomicInteger(0);
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag.get() != 0) {
                    condition1.await();
                }

                printFoo.run();
                flag.set(1);
                condition2.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag.get() != 1) {
                    condition2.await();
                }

                printBar.run();
                flag.set(0);
                condition1.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
```
打卡第...记不得了😂，加油就vans了！
之前看到这样的面试题自己也不会做，就慌得🦆批
后来就来逛相关题解的题解区，本来觉得换种问法就不会了
结果昨日，忽然想起几年前玩的赛尔号，看了一两篇攻略，竟然用回归送的精灵，用同样的套路单刷了所有谱尼
![image.png](https://pic.leetcode-cn.com/1608343871-vdnnPR-image.png)
![image.png](https://pic.leetcode-cn.com/1608343881-gNkdoi-image.png)
十一年半啊，这么久了，之前氪金的精灵都被秒杀的份，现在就被一个送的精灵单刷了？
于是心有所悟，想起了看到的这个套路，最为朴实，不需要JUC的工具类(ReentrantLock和Condition也能实现)就真能解决大部分的多线程算法
希望看到本题解的同学们也能有所悟😉

