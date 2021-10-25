package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：BHT
 * @date ：7/26/21 9:00 PM
 */
public class Test01 {
    List<Integer> list = new ArrayList<>();

    public void add(Integer i){
        list.add(i);
    }

    public int size(){
        return list.size();
    }

    public static void main(String[] args) {

        Test01 test01 = new Test01();


        new Thread(() -> {
            for (int i=0;i<10;i++){
                test01.add(i);
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
                if (test01.size() == 5){
                    break;
                }
//                System.out.print(test01.size());

            }
            System.out.println("thread2 end");
        }).start();

    }
}
