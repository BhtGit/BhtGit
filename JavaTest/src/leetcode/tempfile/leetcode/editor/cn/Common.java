package leetcode.tempfile.leetcode.editor.cn;

import java.lang.reflect.Constructor;

/**
 * @author BHT 2021/1/13 17:11
 */
public class Common {

    public static Object getSolution(Class clazz, String className) {
        Object result = null;
        try {
            Object o = clazz.newInstance();
            Class[] declaredClasses = clazz.getDeclaredClasses();
            for (Class declaredClass : declaredClasses) {
                String name = declaredClass.getName();
                if (name.contains(className)) {
                    Constructor con2 = declaredClass.getDeclaredConstructor(clazz);
                    con2.setAccessible(true);
                    result = con2.newInstance(o);
                }
            }
            // 说明不是内部类
            if (result == null) {
                Class c1 = Class.forName(clazz.getName().substring(0, clazz.getName().lastIndexOf('.')) + "." + className);
                result = c1.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Object getSolution(Class clazz) {
        return getSolution(clazz,"Solution");
    }

}
