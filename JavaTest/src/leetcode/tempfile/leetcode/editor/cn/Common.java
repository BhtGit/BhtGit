package leetcode.tempfile.leetcode.editor.cn;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Constructor;

/**
 * @author BHT 2021/1/13 17:11
 */
public class Common {

    public static Object getSolution(Class clazz){
        try {
            Object o = clazz.newInstance();
            Class[] declaredClasses = clazz.getDeclaredClasses();
            for (Class declaredClass : declaredClasses){
                String name = declaredClass.getName();
                if (name.contains("Solution")){
                    Constructor con2 = declaredClass.getDeclaredConstructor(clazz);
                    con2.setAccessible(true);
                    return con2.newInstance(o);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
