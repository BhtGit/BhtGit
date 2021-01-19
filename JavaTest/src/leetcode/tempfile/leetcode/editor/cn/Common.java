package leetcode.tempfile.leetcode.editor.cn;

import java.lang.reflect.Constructor;

/**
 * @author BHT 2021/1/13 17:11
 */
public class Common {

    public static Object getSolution(Class clazz) {
        Object result = null;
        try {
            Object o = clazz.newInstance();
            Class[] declaredClasses = clazz.getDeclaredClasses();
            for (Class declaredClass : declaredClasses) {
                String name = declaredClass.getName();
                if (name.contains("Solution")) {
                    Constructor con2 = declaredClass.getDeclaredConstructor(clazz);
                    con2.setAccessible(true);
                    result = con2.newInstance(o);
                }
            }
            // 说明不是内部类
            if (result == null) {
                Class c1 = Class.forName(clazz.getName().substring(0,clazz.getName().lastIndexOf('.')) + ".Solution");
                result = c1.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
