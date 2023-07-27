package com.hspedu.chapter13.date;

import java.time.Instant;
import java.util.Date;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Instant_ {
    public static void main(String[] args) {
        //通过静态方法now（）获取表示当前时间戳的对象
        Instant now = Instant.now();
        System.out.println(now);
        //通过from 可以把Instant转成Date
        Date date = Date.from(now);
        //通过date的toInstant（）可以把date转成Instant对象
        Instant instant = date.toInstant();
    }
}
