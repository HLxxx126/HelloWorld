package com.hspedu.chapter12.exception.homework;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork02 {
    public static void main(String[] args) {//arg.length = 0;
        //这里发生的是ArrayIndexOutOfBoundsException
        if (args[4].equals("john")) {//可能发生NullPointerException
            System.out.println("AA");
        } else {
            System.out.println("BB");
        }
        Object o = args[2];
        Integer i = (Integer) o;//一定会发生ClassCastException
    }
}
