package test;

import com.alibaba.fastjson.JSONObject;
import gy.test.JsonUtil;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * @author ：BHT
 * @date ：2019-07-19 16:11
 */
public class Test03 {

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


    public static void main(String[] args) {

        Test03 t = new Test03();
//
//        t.setStr("");
//
//
//        System.out.println("" == t.getStr());

//        Double a = 1.0;
//        System.out.println(a == 1);

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("aaa",1);
//
//
//        ItemCombineInfo ItemCombineInfo = JsonUtil.readObject(jsonObject.toJSONString(), ItemCombineInfo.class);
//
//        System.out.println(ItemCombineInfo);


//        Double v = new BigDecimal("0.9166").setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println(v);
//        double v1 = new BigDecimal("1").subtract(new BigDecimal(v.toString())).doubleValue();
//        System.out.println(v1);
//
//        ItemCombineInfo info = t.new ItemCombineInfo();
//        info.setAaa(v1);
//        System.out.println(info.getAaa());

//        int a = 9/10;
//        System.out.println(a);


        P p = t.new P();
        p.setName("123");
        C c = t.new C();
        BeanUtils.copyProperties(p,c);
        System.out.println(c);

    }

    class P{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "P{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    class C extends P{
        private String cName;

        public String getcName() {
            return cName;
        }

        public void setcName(String cName) {
            this.cName = cName;
        }

        @Override
        public String toString() {
            return "C{" +
                    "name='" + getName() + '\'' +
                    ", cName='" + cName + '\'' +
                    '}';
        }
    }



    class ItemCombineInfo{
        private Double aaa;


        public Double getAaa() {
            return aaa;
        }

        public void setAaa(Double aaa) {
            this.aaa = aaa;
        }

        @Override
        public String toString() {
            return "ItemCombineInfo{" +
                    "aaa=" + aaa +
                    '}';
        }
    }


//    Class tt = Test03.class;
//
//    Class<? extends Test03> t3 = getClass();

}
