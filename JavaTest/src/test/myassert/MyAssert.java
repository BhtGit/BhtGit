package test.myassert;

/**
 * @author BHT 2022/4/20 9:59
 */
public interface MyAssert {

    /**
     * 每个实现assert的具体业务断言，都需自定义异常
     * @param message 异常信息
     * @return 异常类
     */
    RuntimeException newException(String message);

    default void isNull(Object obj) {
        isNull(obj, "");
    }

    /**
     * 断言为空则正常
     * @param obj 对象
     * @param message 不为空时的异常信息
     */
    default void isNull(Object obj, String message) {
        if (!judgeNull(obj)) {
            throw newException(message);
        }
    }

    default void notNull(Object obj) {
        notNull(obj, "");
    }

    /**
     * 断言不为空则正常
     * @param obj 对象
     * @param message 为空时的异常信息
     */
    default void notNull(Object obj, String message) {
        if (judgeNull(obj)) {
            throw newException(message);
        }
    }

    default boolean judgeNull(Object obj) {
        return obj == null;
    }

    default void isTrue(boolean bool) {
        isTrue(bool, "");
    }

    /**
     * 断言为true则正常
     * @param bool 布尔值
     * @param message 为false时的异常信息
     */
    default void isTrue(boolean bool, String message) {
        if (!bool) {
            throw newException(message);
        }
    }

    default void isFalse(boolean bool) {
        isFalse(bool, "");
    }

    /**
     * 断言为false则正常
     * @param bool 布尔值
     * @param message 为true时的异常信息
     */
    default void isFalse(boolean bool, String message) {
        if (bool) {
            throw newException(message);
        }
    }

}
