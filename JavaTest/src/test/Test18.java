package test;

import java.util.Calendar;

/**
 * @author ：BHT
 * @date ：2020-03-09 10:08
 */
public class Test18 {
    public static void main(String[] args){
        //获取上月的第一天
        Calendar lastMonthFirst = Calendar.getInstance();
        lastMonthFirst.add(Calendar.MONTH, -1);
        lastMonthFirst.set(Calendar.DAY_OF_MONTH, 1);
        //获取上月的最后一天
        Calendar lastMonthLast = Calendar.getInstance();
        lastMonthLast.set(Calendar.DAY_OF_MONTH, 0);
        //获取本月第一天：
        Calendar currentMonthFirst = Calendar.getInstance();
        currentMonthFirst.set(Calendar.DAY_OF_MONTH, 1);
        //获取当前月最后一天
        Calendar currentMonthLast = Calendar.getInstance();
        currentMonthLast.set(Calendar.DAY_OF_MONTH, currentMonthLast.getActualMaximum(Calendar.DAY_OF_MONTH));
        lastMonthFirst.set(lastMonthFirst.get(Calendar.YEAR), lastMonthFirst.get(Calendar.MONTH), lastMonthFirst.get(Calendar.DATE), 0, 0, 0);
        lastMonthLast.set(lastMonthLast.get(Calendar.YEAR), lastMonthLast.get(Calendar.MONTH), lastMonthLast.get(Calendar.DATE), 0, 0, 0);
        currentMonthFirst.set(currentMonthFirst.get(Calendar.YEAR), currentMonthFirst.get(Calendar.MONTH), currentMonthFirst.get(Calendar.DATE), 0, 0, 0);
        currentMonthLast.set(currentMonthLast.get(Calendar.YEAR), currentMonthLast.get(Calendar.MONTH), currentMonthLast.get(Calendar.DATE), 0, 0, 0);

        System.out.println(lastMonthFirst.getTime());
        System.out.println(lastMonthLast.getTime());
        System.out.println(currentMonthFirst.getTime());
        System.out.println(currentMonthLast.getTime());
    }
}
