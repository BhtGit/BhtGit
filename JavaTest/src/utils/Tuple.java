package utils;

import java.io.Serializable;

/**
 * 元组-用来返回多个返回结果
 *
 * @author ：BHT
 * @date ：2019-09-06 14:46
 */
public class Tuple implements Serializable {
    private static final long serialVersionUID = 3007639201920588694L;

    public static <One extends Serializable, Two extends Serializable> Tuple2<One, Two> tuple2(One one, Two two) {
        return new Tuple2<>(one, two);
    }

    public static <One extends Serializable, Two extends Serializable, Three extends Serializable> Tuple3<One, Two, Three> tuple3(One one, Two two, Three three) {
        return new Tuple3<>(one, two, three);
    }

    public static class Tuple2<One extends Serializable, Two extends Serializable> implements Serializable {

        private static final long serialVersionUID = -1817150653740317498L;

        public final One one;
        public final Two two;

        private Tuple2(One one, Two two) {
            this.one = one;
            this.two = two;
        }

    }

    public static class Tuple3<One extends Serializable, Two extends Serializable, Three extends Serializable> implements Serializable {

        private static final long serialVersionUID = 8367648833985772479L;

        public final One one;
        public final Two two;
        public final Three three;

        private Tuple3(One one, Two two, Three three) {
            this.one = one;
            this.two = two;
            this.three = three;
        }
    }

}
