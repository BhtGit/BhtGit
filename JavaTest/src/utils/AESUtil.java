package utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * AES加密
 * 使用固定的密钥
 * 单例使用cipher  加密解密时会加锁
 * @author BHT 2021/2/3 10:18
 */
public class AESUtil {

    private AESUtil(){
        init();
    }

    private static volatile AESUtil instance;
    private static AESUtil getInstance(){
        if (instance == null) {
            synchronized (AESUtil.class) {
                if (instance == null) {
                    instance = new AESUtil();
                }
            }
        }
        return instance;
    }

    private static final IvParameterSpec IV_PARAMETER_SPEC = new IvParameterSpec("0000000000000000".getBytes());
    /**
     * 默认的加密算法
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/NoPadding";

    /**
     * 加减密各用一个cipher  饿汉单例
     */
    private static Cipher cipherEncrypt;
    private static Cipher cipherDecrypt;
    private static boolean isSuccessCipher = false;

    /**
     * 这里不使用静态构造块
     * 引用key可能会从common类的static值中获取
     * 防止初始化化早于common类导致获取key异常
     */
    private void init(){
        try {
//            String key = AppCommon.getAesKey();
            String key = "1234561234567890";
            cipherEncrypt = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipherDecrypt = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipherEncrypt.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"), IV_PARAMETER_SPEC);
            cipherDecrypt.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"), IV_PARAMETER_SPEC);
            isSuccessCipher = true;
        } catch (Exception e) {
            isSuccessCipher = false;
            e.printStackTrace();
            System.out.println("【ERROR】【ERROR】【ERROR】AES加密cipher初始化异常，将无法正常登陆OA，请重新启动应用！");
            System.out.println("【ERROR】【ERROR】【ERROR】AES加密cipher初始化异常，将无法正常登陆OA，请重新启动应用！");
            System.out.println("【ERROR】【ERROR】【ERROR】AES加密cipher初始化异常，将无法正常登陆OA，请重新启动应用！");
        }
    }

    /**
     * 判断是否初始化成功，如果没有初始化成功，重新初始化
     */
    private void judgeInit(){
        if (!isSuccessCipher) {
            init();
        }
    }

    /**
     * 加密成十六进制字符串
     *
     * <p>
     * 使用AES加密，并将Cipher加密后的byte数组转换成16进制字符串
     * </p>
     *
     */
    public static String encrypt(String data) {
        getInstance().judgeInit();
        return getInstance().encryptIntoHexString(data);
    }

    /**
     * 将加密后的十六进制字符串进行解密
     *
     **/
    public static String decrypt(String data) {
        getInstance().judgeInit();
        return getInstance().decryptByHexString(data);
    }

    /**
     * 加密成十六进制字符串
     *
     * <p>
     * 使用AES加密，并将Cipher加密后的byte数组转换成16进制字符串
     * </p>
     * 加锁，同时只能由一个加密或解密操作
     */
    private synchronized String encryptIntoHexString(String data) {
        try {
            int i = 16 * (data.getBytes().length / 16 + 1);
            // Arrays.copyOf 这里后面补了0，所以导致最后解码会多出空格来
            byte[] bytes1 = Arrays.copyOf(data.getBytes(), i);
            byte[] bytes = cipherEncrypt.doFinal(bytes1);
            return bytesConvertHexString(bytes).trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将加密后的十六进制字符串进行解密
     * 加锁，同时只能由一个加密或解密操作
     **/
    private synchronized String decryptByHexString(String data) {
        try {
            return new String(cipherDecrypt.doFinal(hexStringConvertBytes(data.toLowerCase())), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * byte数组转换成十六进制字符串
     *
     * <p>
     * 先对每个byte数值补码成十进制,
     * 然后在将十进制转换成对应的十六进制.
     * 如果单次转换, 十六进制只有一位时， 将在前面追加0变成两位.
     * </p>
     *
     */
    private static String bytesConvertHexString(byte[] data) {
        StringBuilder result = new StringBuilder();
        for (byte b : data) {
            // 补码成正十进制后转换成16进制
            String hexString = Integer.toHexString(b & 255);
            result.append(hexString.length() == 1 ? "0" + hexString : hexString);
        }
        return result.toString().toUpperCase();
    }

    /**
     * 十六进制字符串转换成byte数组
     *
     * <p>
     * 在加密时, 十六进制数值和byte字节的对应关系 是:  2个十六进制数值对应  1个byte字节  (2: 1)
     * 所以byte数组的长度应该是十六进制字符串的一半, 并且在转换时
     * 应是两个十六进制数值转换成一个byte字节  (2个2个十六进制数值进行转换)
     * 这也是为什么可以*2的原因， 例如: 0, 2, 4, 6, 8, 10, 12 依次遍历
     * </p>
     *
     */
    private static byte[] hexStringConvertBytes(String data) {
        int length = data.length() / 2;
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            int first = Integer.parseInt(data.substring(i * 2, i * 2 + 1), 16);
            int second = Integer.parseInt(data.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (first * 16 + second);
        }
        return result;
    }

    public static void main(String[] args) {

        test1("1612339478281");


    }

    private static void test1(String data){
        System.out.println("加密前: " + data + "===");
        String encode = encrypt(data);
        System.out.println("加密后: " + encode + "===");
//        encode = "AF792AA3D917671AAE7DDC06266D2887";
        String decode = decrypt(encode);
        System.out.println("解密后: " + decode + "===");
    }
    private static void test2(final String str){
        for (int i = 0; i < 1000; i++) {
            final int n = i;
            Thread thread = new Thread(() -> {
                String data = str + n;
                System.out.println("加密前: " + data + "===");
                String encode = encrypt(data);
                System.out.println("加密后: " + encode + "===");
                String decode = decrypt(encode);
                System.out.println("解密后: " + decode + "===");
            });
            thread.start();
        }
    }

}
