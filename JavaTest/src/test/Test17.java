package test;

/**
 * @author ：BHT
 * @date ：2019-11-29 00:23
 */
public class Test17 {

    public static void main(String[] args) {

        String str = "wo\rc\tao le\ncao le\\x0bvzhendecao le";
        System.out.println(str);

        str = str.replaceAll("[ \\x0b\t\r]","");

        str.substring(0,2);

        System.out.println(str);
    }

}
