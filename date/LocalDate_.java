package com.hspedu.chapter13.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.zip.DataFormatException;

/**
 * @author HLxxx
 * @version 1.0
 */
public class LocalDate_ {
    public static void main(String[] args) {
        //使用now（）返回当前日期时间的对象
        LocalDateTime ldt = LocalDateTime.now();//LocalDate.now();//LocalTime.now();
        System.out.println(ldt);
        //使用DateTimeFormatter对象来进行格式化
        //创建DateTimeFormatter对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH：mm：ss");
        String format = dateTimeFormatter.format(ldt);
        System.out.println(format);

        System.out.println("年 ： "+ ldt.getYear());
        System.out.println("月 ： " +ldt.getMonth());//返回月对应的英文
        System.out.println("月 ： " +ldt.getMonthValue());//返回月对应的数字
        System.out.println("日 ： " + ldt.getDayOfMonth());
        System.out.println("时 ： " + ldt.getHour());
        System.out.println("分 ： " + ldt.getMinute());
        System.out.println("秒 ： " + ldt.getSecond());

        LocalDate now = LocalDate.now();//可以获取年月日
        System.out.println(now.getYear());
        LocalTime now2 = LocalTime.now();//可以获取时分秒
        System.out.println(now2.getHour());

        //提供了 plus 和 minus方法可以对当前时间进行加或者减
        //看看890天后，是什么时间
        LocalDateTime localDateTime = ldt.plusDays(890);
        System.out.println("890天后为：" + dateTimeFormatter.format(localDateTime));

        //看看3456分钟前是什么时候
        LocalDateTime localDateTime1 = ldt.minusMinutes(3456);
        System.out.println("3456分钟前为：" + dateTimeFormatter.format(localDateTime1));
    }
}
