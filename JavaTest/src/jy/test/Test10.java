package jy.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：BHT
 * @date ：2022/3/9 10:16 PM
 */
public class Test10 {

    static ReentrantLock lock = new ReentrantLock();
    static Condition c2 = lock.newCondition();
    static Condition c3 = lock.newCondition();
    static Condition c4 = lock.newCondition();

    class Thread1 implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(1);
                c2.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    class Thread2 implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                c2.await();
                System.out.println(2);
                c3.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class Thread3 implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                c3.await();
                System.out.println(3);
                c4.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class Thread4 implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                c4.await();
                System.out.println(4);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        new Thread(new Test10().new Thread4()).start();
        new Thread(new Test10().new Thread3()).start();
        new Thread(new Test10().new Thread2()).start();
        new Thread(new Test10().new Thread1()).start();

    }
}
