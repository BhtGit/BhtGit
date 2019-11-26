package test;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;

import java.math.BigDecimal;

/**
 * @author ：BHT
 * @date ：2019-09-01 20:12
 */
public class Test14 {

    public static int test01(int[] a, int[] b) {
        int aji = 0;
        int aou = 0;
        int bji = 0;
        int bou = 0;

        for (int aa : a) {
            if (aa % 2 == 1) {
                aji++;
            } else {
                aou++;
            }
        }
        for (int bb : b) {
            if (bb % 2 == 1) {
                bji++;
            } else {
                bou++;
            }
        }

        int num = aji > bou ? bou : aji;
        num += bji > aou ? aou : bji;
        return num;
    }


    public static int test03(int m, int[] a) {
        long total = 0;
        for (int aa : a) {
            total += aa;
        }
        long day = total / m + total % m == 0 ? 0 : 1 + a.length;
        return (int) day;
    }


    class A {
        Double a = null;
        Double b = null;

        public Double getA() {
            return a;
        }

        public void setA(Double a) {
            this.a = a;
        }

        public Double getB() {
            return b;
        }

        public void setB(Double b) {
            this.b = b;
        }
    }

    public class B {
        Double a = null;
//        Double c = null;

        public Double getA() {
            return a;
        }

        public void setA(Double a) {
            this.a = a;
        }

//        public Double getC() {
//            return c;
//        }
//
//        public void setC(Double c) {
//            this.c = c;
//        }
    }

    public static void main(String[] args) {

//        DozerBeanMapper dozer = new DozerBeanMapper();
//
//        A a = new Test14().new A();
//        a.setA(0.0);
//        a.setB(0.1);
//
//        B b = dozer.map(null, Test14.B.class);
//
//        System.out.println(b);


        Boolean b = null;
        System.out.println(Boolean.TRUE.equals(b));

    }

}
