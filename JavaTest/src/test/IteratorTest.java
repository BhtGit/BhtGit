package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：BHT
 * @date ：2019-09-20 20:41
 */
public class IteratorTest {

    class A {
        int a = 0;

        @Override
        public String toString() {
            return "A{" +
                    "a='" + a + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        A a = new IteratorTest().new A();
        A a1 = new IteratorTest().new A();
        A a2 = new IteratorTest().new A();
        A a3 = new IteratorTest().new A();

        List<A> list = new ArrayList<>();
        list.add(a);
        list.add(a1);
        list.add(a2);
        list.add(a3);

        int index = 0;
        Iterator<A> iterator = list.iterator();
        while (iterator.hasNext()) {
            A next = iterator.next();
            if (index == 1){
                iterator.remove();
                index++;
                continue;
            }
            next.a = index;
            index++;
        }
        System.out.println(list);

    }

}
