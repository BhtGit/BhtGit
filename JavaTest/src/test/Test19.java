package test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @author BHT 2021/8/3 11:05
 */
public class Test19 {
    public static void main(String[] args) throws IOException {
        String s = "中国人";
        System.out.println(s);
        for (byte aByte : s.getBytes(StandardCharsets.UTF_8)) {
            System.out.print(aByte + " ");
        }
        System.out.println();
        for (byte aByte : s.getBytes("GBK")) {
            System.out.print(aByte + " ");
        }
        System.out.println();
        for (byte aByte : s.getBytes()) {
            System.out.print(aByte + " ");
        }
        InputStream is =new ByteArrayInputStream(s.getBytes("GBK"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        String str = baos.toString();
        System.out.println(str);
        System.out.println();
        System.out.println(Charset.defaultCharset().name());
        System.out.println();
        System.out.println(new String(s.getBytes(), "UTF-8"));
        System.out.println(new String(s.getBytes("GBK"), "UTF-8"));
        System.out.println(new String(s.getBytes("GBK"), "GBK"));
        System.out.println(new String(s.getBytes("UTF-8"), "UTF-8"));
    }
}
