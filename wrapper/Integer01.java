package com.hspedu.chapter13.wrapper;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Integer01 {
    public static void main(String[] args) {
        //演示int--Integer的拆箱和装箱
        //手动装箱
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);
        //手动拆箱
        int i = integer.intValue();
        //jdk5后可以自动装箱和拆箱
        int n2 = 200;
        //自动装箱
        Integer integer2 = n2;//底层使用的是Integer.valueOf(n2)
        //自动拆箱
        int n3 = integer2;//底层仍是intValue()方法

    }
}
