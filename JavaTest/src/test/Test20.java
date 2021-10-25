package test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：BHT
 * @date ：7/29/21 11:11 PM
 */
public class Test20 {

    private static /*volatile*/ boolean flag = true;

    private static /*volatile*/ long n = 0;

    public static void main(String[] args) throws InterruptedException {

//        new Thread(()->{
//            System.out.println("thread start");
//            while (flag) {
//                n++;
////                System.out.print("1");
//            }
//            System.out.println();
//            System.out.println("thread end n="+n);
//        }).start();
//
//        Thread.sleep(1000);
//        Thread.yield();
//
//        flag = false;

        int i;
        int n = 2;
        System.out.println(n<<2);
        System.out.println(2&2);
        System.out.println(8&2);
        System.out.println(n<<2&2);
        System.out.println((n<<2)&2);
        System.out.println((i=n<<2)&2);
        System.out.println(i);

        Map map = new ConcurrentHashMap();



    }

}
