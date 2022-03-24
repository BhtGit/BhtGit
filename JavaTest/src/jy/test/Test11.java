package jy.test;

/**
 * @author ：BHT
 * @date ：2022/3/21 4:25 PM
 */
public class Test11 {

    public static void main(String[] args) {

        String asd = "123,123";
        System.out.println(asd.substring(0,asd.indexOf(',')));
        System.out.println(asd.split(",123").length);

    }

}
