package jy.test;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Test06 {
    public static void main(String[] args) {
        BASE64Encoder encoder = new BASE64Encoder();
        String encodedText = null;
        try {
            encodedText = encoder.encode("金宝".getBytes("GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(encodedText);
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            System.out.println(new String(base64Decoder.decodeBuffer(encodedText),"GBK"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
