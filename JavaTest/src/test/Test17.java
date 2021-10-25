package test;

/**
 * @author ：BHT
 * @date ：2019-11-29 00:23
 */
public class Test17 {

    public static void main(String[] args) {
        String str = "";
        String[] split = str.split("-");
        System.out.println();


        String s = "123123-";
        String s1 = s.substring(0,s.indexOf('-'));
        String s2 = s.substring(s.indexOf('-') + 1);
        System.out.println(s1);
        System.out.println(s2);

        String str = "wo\rc\tao le\ncao le\\x0bvzhendecao le";
        System.out.println(str);

        str = str.replaceAll("[ \\x0b\t\r]","");

        str.substring(0,2);

        System.out.println(str);
    }

}
