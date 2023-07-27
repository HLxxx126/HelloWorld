package com.hspedu.chapter13.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Date_ {
    public static void main(String[] args) throws ParseException {
        //这里的date类时在java.util包
        Date d1 = new Date();//获取当前系统时间
        System.out.println("当前日期 = " + d1);//默认输出的日期格式是国外的方式，因此通常需要对格式进行转换
        Date d2 = new Date(9234567);//通过指定毫秒数得到时间
        System.out.println("d2 = " + d2);
        System.out.println(d1.getTime());//获取某个时间对应的毫秒数
        //创建SimpleDateFormat对象，可以指定相应的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");//格式使用的字母是规定好的
        String format = sdf.format(d1);
        System.out.println(format);
        //把一个格式化的字符串转成对应的Date//Date在输出时还是按国外心思，希望按指定格式输出需转换
        //在把String -> Date，使用的sdf格式需和你给的String格式一样，否则会抛出转换异常
        String s = "1996年01月01日 10:20:30 星期一";
        Date parse = sdf.parse(s);
        System.out.println("parse = " + sdf.format(parse));
    }
}
