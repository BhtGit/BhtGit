package thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author ：BHT
 * @date ：7/26/21 9:00 PM
 */
public class Test02 {

    List<Integer> list = new ArrayList<>();

    public void add(Integer i){
        list.add(i);
    }

    public int size(){
        return list.size();
    }
    static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {

        Test01 test = new Test01();
        List list = new ArrayList();
        Map map = new HashMap();


        new Thread(() -> {
            for (int i=0;i<10;i++){
                test.add(i);
                System.out.println("thread1--"+i);
//                if (test.size() == 5){
                    countDownLatch.countDown();
//                    System.out.println(123);
//                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println("thread2 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();



    }


}
