package gy.util;

import com.google.common.collect.Lists;
import gy.test.A;
import gy.test.C;
import gy.test.F;
import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BeanMapper {
    private static DozerBeanMapper dozer = new DozerBeanMapper();

    public BeanMapper() {
    }

    public static <T> T map(Object source, Class<T> destinationClass) {
        return source == null ? null : dozer.map(source, destinationClass);
    }

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        List<T> destinationList = Lists.newArrayList();
        if (sourceList != null && !sourceList.isEmpty()) {
            for (Object sourceObject : sourceList) {
                T destinationObject = dozer.map(sourceObject, destinationClass);
                destinationList.add(destinationObject);
            }
        }

        return destinationList;
    }

    public static void copy(Object source, Object destinationObject) {
        if (source != null && destinationObject != null) {
            dozer.map(source, destinationObject);
        }
    }

    public static void main(String[] args) {


        F f = new F();
        f.setF("f");
        List<A> as = new ArrayList<>();
        for (double i = 0; i < 5; i++) {
            A a = new A();
            a.setA(i);
            as.add(a);
        }
        f.setAs(as);
        C c = map(f, C.class);
        System.out.println(c);

    }

}