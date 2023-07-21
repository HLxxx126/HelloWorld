package com.hspedu.chapter12.exception;

/**
 * @author HLxxx
 * @version 1.0
 */
public class NumberFormatException_ {
    public static void main(String[] args) {
        String name = "韩顺平教育";
        //将String转成int
        int num = Integer.parseInt(name);//抛出NumberFormatException
        System.out.println(num);
    }
}
