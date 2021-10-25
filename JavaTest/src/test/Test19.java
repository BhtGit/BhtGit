package test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author ：BHT
 * @date ：7/12/21 8:29 PM
 */
public class Test19 {

    List<Integer> list = new ArrayList<>();

    public void add(Integer i){
        list.add(i);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {

        Test19 test19 = new Test19();


        new Thread(() -> {
            for (int i=0;i<10;i++){
                test19.add(i);
                System.out.println("thread1--"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true){
                if (test19.size() == 5){
                    break;
                }
//                System.out.print(test19.size());

            }
            System.out.println("thread2 end");
        }).start();

        ReferenceQueue<String> queue = new ReferenceQueue<>();
        PhantomReference<String> phantomReference = new PhantomReference<>("",queue);
        phantomReference.get();

    }
}
