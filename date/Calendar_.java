package com.hspedu.chapter13.date;

import java.util.Calendar;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Calendar_ {
    public static void main(String[] args) {
        //1.Calendar是一个抽象类，且构造器为私有
        //2.通过getInstance（）来获取实例
        //3.提供大量方法和字段
        Calendar c = Calendar.getInstance();//创建日历对象
        System.out.println("c = " + c);
        //获取日历对象的某个日历字段
        System.out.println("年 ： "+ c.get(Calendar.YEAR));
        System.out.println("月 ： " + (c.get(Calendar.MONTH) + 1));//返回月时从9开始编号，所以要+1
        System.out.println("日 ： " + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时 ： " + c.get(Calendar.HOUR));
        System.out.println("分钟 ： " + c.get(Calendar.MINUTE));
        System.out.println("秒 ： " + c.get(Calendar.SECOND));
        //Calender没有专门的格式化方法，所以需要自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月" +
                           c.get(Calendar.DAY_OF_MONTH) + "日" );
    }
}
