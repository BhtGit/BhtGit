package test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test02 {

    public static void main(String[] args) {
//
//        for (String a : args){
//            System.out.println(a);
//        }

//        Calendar calendar = Calendar.getInstance();
//        int date = calendar.get(Calendar.DATE);
//        calendar.set(Calendar.DATE, date - 18);
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));


//        new Test02().new SuperTest().test();

//        HashMap hashMap = new HashMap<>(8,0.75F);
//        hashMap.put("1",1);
//        hashMap.put("2",2);
//        hashMap.put("3",3);
//        hashMap.put("4",4);
//        hashMap.put("5",5);
//        hashMap.put("6","eee");
//        System.out.println(hashMap);
//        Set<HashMap.Entry<String,Integer>> set = hashMap.entrySet();
//        for (HashMap.Entry<String,Integer> o : set){
//            System.out.println(o);
//        }


//        String format = String.format("//%s/Platformweb/platformweb/", "128.0.0.1:9900");
//        System.out.println(format);


//        String receiverMessage = "bai 18621144954 上海 浦东新区 金蝶软件园";
//        String receiverMessage = "18621144954";
//
//        String mobileRegex = "(86-[1][0-9]{10})|(86[1][0-9]{10})|([1][0-9]{10})";
//        boolean matches = receiverMessage.matches(mobileRegex);
//        System.out.println(matches);



        String a = "bai";
        a = a.trim();
        String[] s = a.split("b");
        for (int i = 0;i<s.length;i++) {
            System.out.print(i+"-"+s[i]);
            System.out.println();
        }
//        System.out.println(a.substring(0,4));

    }

    static class CompareTest implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    class Car extends Vehicle {
        private final void run() {
            System.out.println("Car");
        }
    }

    class Vehicle {
        private final void run() {
            System.out.println("Vehicle");
        }
    }

    static class SuperTest extends Date {
        private static final long serialVersionUID = 1L;

        private void test() {
            System.out.println(super.getClass().getName());
        }

    }

}
