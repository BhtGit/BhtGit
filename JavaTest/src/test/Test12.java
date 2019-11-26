package test;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author ：BHT
 * @date ：2019-08-12 20:12
 */
public class Test12 {

    class A {
        Boolean a;

        public Boolean getA() {
            return a;
        }

        public void setA(Boolean a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {

        int total = 101;
        int pageSize = 20;
        double pageTotalD = (double) total / (double) pageSize;
        System.out.println(pageTotalD);

        StringBuilder sb = new StringBuilder();
        sb.append(",");
        sb.append("2111111");
        System.out.println(sb.substring(1));

    }
}
