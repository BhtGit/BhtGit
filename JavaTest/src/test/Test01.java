package test;

import java.net.URLDecoder;
import java.util.*;
import java.util.function.Predicate;

public class Test01 {
    public static Test01 t1 = new Test01();
    public static int i = 0;
    private int a = 0;
    private static int b = 0;

    {
        System.out.println("blockA");
    }

    static {
        System.out.println("blockB");
    }

    public static void main(String[] args) throws Exception {


//        System.out.println(123);
//        Test01 t2 = new Test01();

//        int a = 630;
//        double b = a;
//        System.out.println(Double.toString(b/100));

//        String decode = URLDecoder.decode("%E8%90%BD%E5%8F%B6%E7%A7%8B%E9%A3%8E%E6%89%AB%E8%90%BD%E5%8F%B6", "utf-8");
//        System.out.println(decode);

//        Test01 test01 = new Test01();
//        int a$w = 1;

//        String decode = URLDecoder.decode("%E6%88%91%E6%98%AF%E6%88%91","utf-8");
//        System.out.println(decode);
//
//        System.out.println(~-1);

//        System.out.println(qualityFactor(707829217));
//        System.out.println(qualityFactor(86627));
//        System.out.println(qualityFactor(12));


//        String aaa = "123.000000000";
//        double bbb = Double.parseDouble(aaa);
//        System.out.println(""+bbb);


//        int x = 0;
//        int y = x++ + ++ x;
//        int n = 0;
//        int z = n++ + n++;
//        System.out.println(y);
//        System.out.println(z);


//        JSONObject a = new JSONObject();
//        a.fluentRemove("");


//        Server server = new Server();
//        String response = server.receive(JSONObject.toJSONString(request));

//        String aaa = "{\"bizData\":\"hJKjAFnjUTnMlLb55Aa8lM+sRegIzQZwoJdri8Nqvo8=\\r\\n\",\"channelId\":\"CHANNEL_ID\",\"interfaceId\":\"UTF8\",\"randomKeyEncrypted\":\"QTWm+f4rhIVkVFcW1lU4gNRTN04KIEhoz8s2lekDld7rj9QMuzCZnEClfbgsP0gZ4r5Ty+1Qn2dr\\r\\n8T6BmLmZncpgC+LJkcaG7QjZyMILwnunAd1JgvzmS3p2lfY0uNKne/e6aIryVhQ3yEe+CG+4u8Qq\\r\\nNuyN/OOfBTd7UXdnqN9L1CBlIJOV0Nrbah9k1PgM0oNPbGT0aAbnei0h1e3G2IilBMzt33MB5ES6\\r\\niy/3vUYJaBlNbbdbDh9prugzRUl4dc/elvC95UpoOA9SH63X+zsj5JjqAvk66IWFQE9hchdNh6ox\\r\\nq3vYsBwai6ioYFRsoANUhPcBMZAdmhnlyxHt+A==\\r\\n\",\"requestId\":\"20190506105134477c93f689c935948799aed144d2e42ace7\",\"signature\":\"eRUlmNUzhqrTB+cnFbCnCPRWkQc4BQ4hRNjX4qPtHiMLgvynDgLQ76+f6KJtm9LSYPEd01oJm08v\\r\\nWtLxBsuNRraRDYNrYVxbBJe+cLddcOBQpdNrt661kWZPQD/r8vM+OxBfBtdNNgtY8vSVuCu68AH1\\r\\n6uv8jGk5E8RSMvc6HyeN1jyo91ybkBjWmq4s0ts7Ef7PlmWR96d96c72OfYD8/f8hMVDYBDWH0CT\\r\\nPa5owEmBKtFIcGxVrBmIt0CuBLJg6urv6ZwC/VWuh85fUVe5QotPfoFC5v5BHhIXCZWlXP3SYCIn\\r\\nGAbbtKZNKVPQNQ7/uRAQVSr1lJdwEPWbmsW7fQ==\\r\\n\",\"timestamp\":\"20190506105134\"}";
//        new Test01().test(aaa);


//        Test01 test01 = new Test01();
//        JSONObject jsonObject = test01.test2();
//        test01.test(jsonObject.toJSONString());


//        try {
//            Object a = new Double(1);
//            Long b = (Long)a;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println(e.getCause());
//            System.out.println(e.getStackTrace());
//            System.out.println(e);
//        }

//        Base64.Decoder decoder = Base64.getDecoder();
//        String s = new String(decoder.decode("6ZO+5o6lOiBodHRwczovL3Bhbi5iYWlkdS5jb20vcy8xbWlPS0lDQyDlr4bnoIE6IHQ1dGQ="));
//        System.out.println(s);

//        short aa = 1;
//        byte a = (byte) aa;
//        final byte b = 1;
//        final byte c = 1;
//        byte d = b+c;


//        System.out.println("111222333".substring(0,4));

//        Date parse = new SimpleDateFormat("yyyyMMdd").parse("20180808");
//        int i = parse.compareTo(new Date());
//        System.out.println(i);


//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        Date sDate = null, eDate = null;
//        try {
//            sDate = sdf.parse("20180808");
//            eDate = sdf.parse("20180909");
//        } catch (ParseException e) {
//        }
//
//        long diff = eDate.getTime() - sDate.getTime();
//
//        int dayNum = (int) (diff / (1000 * 60 * 60 * 24));
//        System.out.println(dayNum);
//
//
//        long remainingAmount = Long.parseLong("-1");
//        System.out.println(remainingAmount);


//        List<String> list = new ArrayList<>();
//        try {
//            FileReader fr = new FileReader(Test01.class.getResource("/fuxing.txt").getPath());
//            BufferedReader br = new BufferedReader(fr);
//            String s = null;
//            while (null != (s = br.readLine())) {
//                list.add(s);
//            }
//        } catch (Exception e) {
//            System.out.println("初始化复姓列表失败" + e);
//        }
//
//        System.out.println(111);

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.forEach(Test01::test3);
//
//        test4("",(str)->{
//            System.out.println(123);
//            return true;
//        });


        String a = "%E6%88%91%E6%98%AF%E6%88%91";
        String decode = URLDecoder.decode(a);
        System.out.println(decode);


//        long l = Long.parseLong("7FFFFFFFFFFFFFFF", 16);
//        long l2 = Long.parseLong("-1", 16);
//        String s = Long.toString(l, 2);
//        System.out.println(s);
//        System.out.println(l+l2);

//        String a ="tao"+"bao";
//        String b="tao";
//        String c="bao";
//        System.out.println(a==MESSAGE);
//        System.out.println((b+c)==MESSAGE);

//        short a = 128;
//        byte b = (byte) a;
//        System.out.println(a);
//        System.out.println(b);

//        Integer a = 128;
//        Integer b = 128;
//        System.out.println(a==b);

//        int [][]a = new int[3][4];
//        System.out.println(a.length);

//        Hashtable hashtable = new Hashtable();
//        hashtable.put(1,1);
//        short a = 128; byte b = (byte) a;
//        System.out.println(a);
//        System.out.println(b);

//        StringBuffer sb = new StringBuffer();
//        sb.append("");


//        int i = 0;
//        i = i++;
//        System.out.println(i);

    }


    enum AAA {
        A, B, C
    }

    private void test0001(AAA a) {
        switch (a) {
            case A:
                System.out.println("a");
                break;
            case B:
                System.out.println("b");
                break;
            case C:
                System.out.println("c");
                break;
        }
    }

    public Test01() {
    }

    public Test01(int i) {
        this();
    }

    private static String MESSAGE = "taobao";

    private static void test4(String i, Predicate<String> predicate) {
        boolean test = predicate.and(predicate).test(i);
        System.out.println(test);
    }

    private static void test3(int i) {
        System.out.println(i);
    }

//    private void test(String request) throws Exception {
//
//        Server server = new Server();
//        String response = server.receive(JSONObject.toJSONString(request));
//
//        JSONObject json = JSONObject.parseObject(response);
//        //验证签名
//        String serverSignData = json.getString("signature");
//        JSONObject orderedJo = SortUtil.getNatureSortedJSONObject(json);
//        orderedJo = orderedJo.fluentRemove("signature");
//        try {
//            boolean sign = AlgorithmUtil.verify(orderedJo.toJSONString(), publicKey2, serverSignData);
//            if (sign) {
//                System.out.println("3.client验证签名成功");
//            } else {
//                System.out.println("3.client验证签名失败");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return;
//        }
//
//        //处理数据
//        String randomKeyEncrypted = json.getString("randomKeyEncrypted");
//        String randomKey = AlgorithmUtil.decryptWithRSA(randomKeyEncrypted, privateKey1);
//        String busData = AlgorithmUtil.decryptWithAES(json.getString("bizData"), randomKey);
//        System.out.println("4.client收到server的业务数据：" + busData);
//    }


//    private JSONObject test2() {
//        JSONObject data = new JSONObject();
//        data.put("client", "sx");
//        data.put("name", "sx");
//
//        // 签名/加密
//        JSONObject reqJson;
//        try {
//            reqJson = SignUtil.sign(data);
//        } catch (Exception e) {
////            logger.error("签名失败", e);
//            System.out.println(e);
//            return null;
//        }
//
//        String datetime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        String qxsRequestId = datetime + uuid;
//
//        String reqTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//
////        JSONObject reqJson = new JSONObject();
//        String channelId = SXConstants.getChannelId();
//        reqJson.put("channelId", channelId);
//        reqJson.put("interfaceId", "UTF8");
//        reqJson.put("timestamp", reqTime);
//        reqJson.put("requestId", qxsRequestId);
//        System.out.println(reqJson.toJSONString());
//        return reqJson;
//    }

    private static String qualityFactor(int num) {
        if (num == 1) return "1";
        if (num == 2) return "2";
        if (num == 3) return "3";
        if (num == 4) return "2*2";
        int i = 2;
        int handle = num;
        List<Integer> arr = new ArrayList<Integer>();
        int result;
        int count = 0;
        while (i < handle) {     //i小于num则一直循环下去，直到i=num为止
            count++;
            result = handle % i;
            if (result == 0) { //除2结果为整数
                arr.add(i);
                handle = handle / i;
                i = 2;
            } else {
                i++;
            }
            if (i == handle - 1) {  //判断是否要结尾
                arr.add(handle);
                break;
            }
        }
        //打印结果
        String str = "";
        for (i = 0; i < arr.size(); i++) {
            str += arr.get(i);
            if (i != arr.size() - 1)
                str += '*';
        }
        System.out.println(count);
        return str;
    }
}
