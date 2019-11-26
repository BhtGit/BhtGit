package gy.test;

import java.math.BigDecimal;

/**
 * @author ：BHT
 * @date ：2019-11-07 10:07
 */
public class Test05 {

    public static void main(String[] args) {

        Double v = null;
        int scale = 4;
        if (v == null) {
            System.out.println(1);
        } else if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        } else {
            BigDecimal b = new BigDecimal(Double.toString(v));
            BigDecimal one = new BigDecimal("1");
            System.out.println(b.divide(one, scale, 4).doubleValue());
        }

    }

}
