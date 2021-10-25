package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 时间工具类
 */
public class DateUtils {

    /**
     * 存放各种格式的DateTimeFormatter对象
     */
    private static ConcurrentMap<String, DateTimeFormatter> formatMap = new ConcurrentHashMap<>();

    /**
     * 常用的时间格式
     */
    public interface Format {
        String yyyy = "yyyy";
        String yyyyMM = "yyyyMM";
        String yyyyMMdd = "yyyyMMdd";
        String yyyy_MM_dd = "yyyy-MM-dd";
        String yyyyMMddHHmmss = "yyyyMMddHHmmss";
        String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    }

    /**
     * 获取 DateTimeFormatter 格式化时间 基本不浪费
     *
     * @param format 指定格式
     * @return DateTimeFormatter
     */
    private static DateTimeFormatter getDateTimeFormatter(String format) {
        if (!formatMap.containsKey(format)) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
            formatMap.put(format, dateTimeFormatter);
        }
        return formatMap.get(format);
    }

    /**
     * 将日期对象转换为指定格式的字符串-线程安全、节省资源
     *
     * @param str    日期字符串
     * @param format 指定格式
     * @return 返回转换后的日期对象
     */
    public static Date strToDateSafe(String str, String format) {
        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(format);
        TemporalAccessor accessor = dateTimeFormatter.parse(str);
        Calendar calendar = Calendar.getInstance();
        // 初始化为19700101 00:00:00:000
        calendar.setTimeInMillis(0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        if (accessor.isSupported(ChronoField.YEAR)) {
            calendar.set(Calendar.YEAR, accessor.get(ChronoField.YEAR));
        }
        if (accessor.isSupported(ChronoField.MONTH_OF_YEAR)) {
            calendar.set(Calendar.MONTH, accessor.get(ChronoField.MONTH_OF_YEAR) - 1);
        }
        if (accessor.isSupported(ChronoField.DAY_OF_MONTH)) {
            calendar.set(Calendar.DAY_OF_MONTH, accessor.get(ChronoField.DAY_OF_MONTH));
        }
        if (accessor.isSupported(ChronoField.HOUR_OF_DAY)) {
            calendar.set(Calendar.HOUR_OF_DAY, accessor.get(ChronoField.HOUR_OF_DAY));
        }
        if (accessor.isSupported(ChronoField.MINUTE_OF_HOUR)) {
            calendar.set(Calendar.MINUTE, accessor.get(ChronoField.MINUTE_OF_HOUR));
        }
        if (accessor.isSupported(ChronoField.SECOND_OF_MINUTE)) {
            calendar.set(Calendar.SECOND, accessor.get(ChronoField.SECOND_OF_MINUTE));
        }
        if (accessor.isSupported(ChronoField.MILLI_OF_SECOND)) {
            calendar.set(Calendar.MILLISECOND, accessor.get(ChronoField.MILLI_OF_SECOND));
        }
        return calendar.getTime();
    }

    /**
     * 将日期对象转换为指定格式的字符串
     *
     * @param date   日期对象
     * @param format 指定格式
     * @return 返回转换后的字符串
     */
    public static String dateToStrSafe(Date date, String format) {
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(format);
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * 获取本季度第一个月和最后一个月
     * yyyyMM
     *
     * @return 第一个月、最后一个月
     */
    public static Tuple.Tuple2<String, String> getCurrQuarterFirstAndLastMonth() {
        Calendar calendarFirst = Calendar.getInstance();
        Calendar calendarLast = Calendar.getInstance();
        int calendarMonth = calendarFirst.get(Calendar.MONTH);
        if (calendarMonth <= Calendar.MARCH) {
            calendarFirst.set(Calendar.MONTH, Calendar.JANUARY);
            calendarLast.set(Calendar.MONTH, Calendar.MARCH);
        } else if (calendarMonth <= Calendar.JUNE) {
            calendarFirst.set(Calendar.MONTH, Calendar.APRIL);
            calendarLast.set(Calendar.MONTH, Calendar.JUNE);
        } else if (calendarMonth <= Calendar.SEPTEMBER) {
            calendarFirst.set(Calendar.MONTH, Calendar.JULY);
            calendarLast.set(Calendar.MONTH, Calendar.SEPTEMBER);
        } else {
            calendarFirst.set(Calendar.MONTH, Calendar.OCTOBER);
            calendarLast.set(Calendar.MONTH, Calendar.DECEMBER);
        }
        String firstMonth = dateToStrSafe(calendarFirst.getTime(), Format.yyyyMM);
        String lastMonth = dateToStrSafe(calendarLast.getTime(), Format.yyyyMM);
        return Tuple.tuple2(firstMonth, lastMonth);
    }

    /**
     * 获取本年度第一个月和最后一个月
     * yyyyMM
     *
     * @return 第一个月、最后一个月
     */
    public static Tuple.Tuple2<String, String> getCurrYearFirstAndLastMonth() {
        String yyyy = dateToStrSafe(new Date(), Format.yyyy);
        return Tuple.tuple2(yyyy + "01", yyyy + "12");
    }

    /**
     * 获取当前月
     *
     * @return yyyyMM 当前月
     */
    public static String getCurrMonth() {
        return dateToStrSafe(new Date(), Format.yyyyMM);
    }

    /**
     * 获取上一月
     *
     * @return yyyyMM 上月
     */
    public static String getLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(strToDateSafe("202101", "yyyyMM"));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        return dateToStrSafe(calendar.getTime(), Format.yyyyMM);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(strToDateSafe("00", "MM"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
    }

}
