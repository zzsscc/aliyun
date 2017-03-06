/**
 * Copyright (c) 2016. Paputy Co, Ltd. All rights reserved.
 * Filename: DateUtil
 * Creator:  wanggao
 * Create-Date: 上午11:38
 **/
package com.eshutech.biz.util;

/**
 *
 * @author: Kim
 * @date: 16/11/3
 * @time: 上午11:38
 *
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    public static final long SECOND = 1000L;
    public static final long MINUTE = 60000L;
    public static final long HOUR = 3600000L;
    public static final long DAY = 86400000L;
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HHMM = "HHmm";
    public static final String TIME_BEGIN = " 00:00:00";
    public static final String TIME_END = " 23:59:59";
    public static final String MONTH_PATTERN = "yyyy-MM";
    public static final String DEFAULT_PATTERN = "yyyyMMdd";
    public static final String FULL_PATTERN = "yyyyMMddHHmmss";
    public static final String FULL_STANDARD_PATTERN = "yyyyMMdd HH:mm:ss";
    public static final String TRADITION_PATTERN = "yyyy-MM-dd";
    public static final String FULL_TRADITION_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public DateUtil() {
    }

    public static String getShortNow() {
        return formatDate("yyyy-MM-dd");
    }

    public static String getDayBegin() {
        return formatDate("yyyy-MM-dd") + " 00:00:00";
    }

    public static String getDayEnd() {
        return formatDate("yyyy-MM-dd") + " 23:59:59";
    }

    public static Date getDayBegin(Date date) {
        return parseDate(formatDate(date, "yyyy-MM-dd 00:00:00"), "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getDayEnd(Date date) {
        return parseDate(formatDate(date, "yyyy-MM-dd 23:59:59"), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getTimeBykm() {
        return formatDate("H:mm");
    }

    public static String getMonth() {
        return formatDate("MM");
    }

    public static String getDay() {
        return formatDate("dd");
    }

    public static String formatDate(Date date) {
        return formatDate(date, "yyyyMMdd");
    }

    public static String formatDate(Date date, String format) {
        if(null != date && !StringUtil.isEmpty(format)) {
            try {
                return (new SimpleDateFormat(format)).format(date);
            } catch (Exception var3) {
                var3.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static String formatDate(String format) {
        return formatDate(new Date(), format);
    }

    public static Date parseDate(Long date) {
        return new Date(date.longValue());
    }

    public static Date parseDate(String date) {
        return parseDate(date, "yyyyMMdd", (Date)null);
    }

    public static Date parseDate(String date, String df) {
        return parseDate(date, df, (Date)null);
    }

    public static Date parseDate(String date, String df, Date defaultValue) {
        if(date != null && !StringUtil.isEmpty(df)) {
            SimpleDateFormat formatter = new SimpleDateFormat(df);

            try {
                return formatter.parse(date);
            } catch (ParseException var5) {
                var5.printStackTrace();
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    public static Date currentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return new Date(calendar.getTimeInMillis());
    }

    public static Date getStartOfDate(Date date) {
        if(date == null) {
            return null;
        } else {
            Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(date);
            cal.set(11, 0);
            cal.set(12, 0);
            cal.set(13, 0);
            cal.set(14, 0);
            return new Date(cal.getTime().getTime());
        }
    }

    public static Date getPreviousMonday() {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(7) - 1;
        Date date;
        if(dayOfWeek == 1) {
            date = addDays(cd.getTime(), -7);
        } else {
            date = addDays(cd.getTime(), -6 - dayOfWeek);
        }

        return getStartOfDate(date);
    }

    public static Date getMondayBefore4Week() {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(7) - 1;
        Date date;
        if(dayOfWeek == 1) {
            date = addDays(cd.getTime(), -28);
        } else {
            date = addDays(cd.getTime(), -27 - dayOfWeek);
        }

        return getStartOfDate(date);
    }

    public static Date getCurrentMonday() {
        Calendar cd = Calendar.getInstance();
        int dayOfWeek = cd.get(7) - 1;
        Date date;
        if(dayOfWeek == 1) {
            date = cd.getTime();
        } else {
            date = addDays(cd.getTime(), 1 - dayOfWeek);
        }

        return getStartOfDate(date);
    }

    public static boolean beforeDay(Date date1, Date date2) {
        return date1 == null?true:getStartOfDate(date1).before(getStartOfDate(date2));
    }

    public static boolean afterDay(Date date1, Date date2) {
        return date1 == null?false:getStartOfDate(date1).after(getStartOfDate(date2));
    }

    public static Date addMonths(Date date, int months) {
        if(months == 0) {
            return date;
        } else if(date == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(2, months);
            return cal.getTime();
        }
    }

    public static Date addDays(Date date, int days) {
        if(days == 0) {
            return date;
        } else if(date == null) {
            return null;
        } else {
            Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(date);
            cal.add(5, days);
            return new Date(cal.getTime().getTime());
        }
    }

    public static Date addMins(Date date, int mins) {
        if(mins == 0) {
            return date;
        } else if(date == null) {
            return null;
        } else {
            Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(date);
            cal.add(12, mins);
            return new Date(cal.getTime().getTime());
        }
    }

    public static Date addSeconds(Date date, int seconds) {
        if(seconds == 0) {
            return date;
        } else if(date == null) {
            return null;
        } else {
            Calendar cal = GregorianCalendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.SECOND, seconds);
            return new Date(cal.getTime().getTime());
        }
    }

    public static boolean isSameMonth(Date date1, Date date2) {
        if(date1 == null && date2 == null) {
            return true;
        } else if(date1 != null && date2 != null) {
            Calendar cal1 = GregorianCalendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = GregorianCalendar.getInstance();
            cal2.setTime(date2);
            return isSameMonth(cal1, cal2);
        } else {
            return false;
        }
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if(date1 == null && date2 == null) {
            return true;
        } else if(date1 != null && date2 != null) {
            Calendar cal1 = GregorianCalendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = GregorianCalendar.getInstance();
            cal2.setTime(date2);
            return cal1.get(1) == cal2.get(1) && cal1.get(2) == cal2.get(2) && cal1.get(5) == cal2.get(5);
        } else {
            return false;
        }
    }

    public static boolean isSameMonth(Calendar cal1, Calendar cal2) {
        return cal1 == null && cal2 == null?true:(cal1 != null && cal2 != null?cal1.get(1) == cal2.get(1) && cal1.get(2) == cal2.get(2):false);
    }

    public static Date getEndOfMonth(Date date) {
        if(date == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(2, calendar.get(2) + 1);
            calendar.set(5, 0);
            calendar.set(11, 12);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return new Date(calendar.getTimeInMillis());
        }
    }

    public static Date getFirstOfMonth(Date date) {
        Date lastMonth = addMonths(date, -1);
        lastMonth = getEndOfMonth(lastMonth);
        return addDays(lastMonth, 1);
    }

    public static boolean inFormat(String sourceDate, String format) {
        if(sourceDate != null && !StringUtil.isEmpty(format)) {
            try {
                SimpleDateFormat e = new SimpleDateFormat(format);
                e.setLenient(false);
                e.parse(sourceDate);
                return true;
            } catch (Exception var3) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String now() {
        return formatDate(new Date(), "yyyyMMddHHmmss");
    }

    public static String formatShortDateC(Date gstrDate) {
        if(gstrDate == null) {
            return null;
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
            String pid = formatter.format(gstrDate);
            return pid;
        }
    }

    public static String getNow() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        Date nowc = new Date();
        String pid = formatter.format(nowc);
        return pid;
    }

    public static String formatShort(String strDate) {
        String ret = "";
        if(strDate != null && !"1900-01-01 00:00:00.0".equals(strDate) && strDate.indexOf("-") > 0) {
            ret = strDate;
            if(strDate.indexOf(" ") > -1) {
                ret = strDate.substring(0, strDate.indexOf(" "));
            }
        }

        return ret;
    }

    public static int getNumberOfSecondsBetween(double d1, double d2) {
        return d1 != 0.0D && d2 != 0.0D?(int)(Math.abs(d1 - d2) / 1000.0D):-1;
    }

    public static int getNumberOfMonthsBetween(Date before, Date end) {
        if(before != null && end != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(before);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(end);
            return (cal2.get(1) - cal1.get(1)) * 12 + (cal2.get(2) - cal1.get(2));
        } else {
            return -1;
        }
    }

    public static long getNumberOfMinuteBetween(Date before, Date end) {
        if(before != null && end != null) {
            long millisec = end.getTime() - before.getTime();
            return millisec / 60000L;
        } else {
            return -1L;
        }
    }

    public static long getNumberOfHoursBetween(Date before, Date end) {
        if(before != null && end != null) {
            long millisec = end.getTime() - before.getTime() + 1L;
            return millisec / 3600000L;
        } else {
            return -1L;
        }
    }

    public static String formatMonthAndDay(Date srcDate) {
        return formatDate("MM月dd日");
    }

    public static long getNumberOfDaysBetween(Date before) {
        return getNumberOfDaysBetween(before, new Date());
    }

    public static long getNumberOfDaysBetween(Date before, Date end) {
        if(before != null && end != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(before);
            Calendar endCal = Calendar.getInstance();
            endCal.setTime(end);
            return getNumberOfDaysBetween(cal, endCal);
        } else {
            return -1L;
        }
    }

    public static long getNumberOfDaysBetween(Calendar cal1, Calendar cal2) {
        if(cal1 != null && cal2 != null) {
            cal1.clear(14);
            cal1.clear(13);
            cal1.clear(12);
            cal1.clear(11);
            cal2.clear(14);
            cal2.clear(13);
            cal2.clear(12);
            cal2.clear(11);
            long elapsed = cal2.getTime().getTime() - cal1.getTime().getTime();
            return elapsed / 86400000L;
        } else {
            return -1L;
        }
    }

    public static Calendar getCurrentCalendar() {
        return Calendar.getInstance();
    }

    public static Timestamp getCurrentDateTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    public static final int getYear(Date date) {
        if(date == null) {
            return -1;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(1);
        }
    }

    public static final int getYear(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(1);
    }

    public static final int getMonth(Date date) {
        if(date == null) {
            return -1;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(2) + 1;
        }
    }

    public static final int getMonth(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(2) + 1;
    }

    public static final int getDate(Date date) {
        if(date == null) {
            return -1;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(5);
        }
    }

    public static final int getDate(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(5);
    }

    public static final int getHour(Date date) {
        if(date == null) {
            return -1;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(11);
        }
    }

    public static final int getHour(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(11);
    }

    public static Date getDateByUrl(String url) {
        try {
            URLConnection e = (new URL(url)).openConnection();
            e.connect();
            return new Date(e.getDate());
        } catch (MalformedURLException var2) {
            var2.printStackTrace();
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        return null;
    }

    public static String getWeekOfDate(Date dt) {
        String[] weekDays = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(7) - 1;
        if(w < 0) {
            w = 0;
        }

        return weekDays[w];
    }

    public static boolean sameSecond(long oldTime, long newTime) {
        Calendar calendarOld = Calendar.getInstance();
        calendarOld.setTimeInMillis(oldTime);
        Calendar calendarNew = Calendar.getInstance();
        calendarNew.setTimeInMillis(newTime);
        return calendarOld.get(13) == calendarNew.get(13);
    }

    public static String getCurrentTime(String format) {
        return (new SimpleDateFormat(format)).format(Calendar.getInstance().getTime());
    }

    public static String getCurrentYear() {
        return (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
    }

    public static String getCurrentMonth() {
        return (new SimpleDateFormat("yyyyMM")).format(Calendar.getInstance().getTime());
    }

    public static String getCurrentDay() {
        return (new SimpleDateFormat("yyyyMMdd")).format(Calendar.getInstance().getTime());
    }

    public static int getCurrentHour() {
        return Calendar.getInstance().get(11);
    }

    public static String getCurrentTime() {
        return (new SimpleDateFormat("yyMMddHHmmss")).format(Calendar.getInstance().getTime());
    }
}
