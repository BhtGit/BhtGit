package gy.test;

import java.util.List;

/**
 * @author ：BHT
 * @date ：2019-11-07 10:36
 */
public class F {
    private String f;
    private List<A> as;

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public List<A> getAs() {
        return as;
    }

    public void setAs(List<A> as) {
        this.as = as;
    }

    @Override
    public String toString() {
        return "F{" +
                "f='" + f + '\'' +
                ", as=" + as +
                '}';
    }
}
