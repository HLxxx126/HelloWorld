package com.hspedu.chapter12.exception;

/**
 * @author HLxxx
 * @version 1.0
 */
public class TryCatchDetail03 {
    public static void main(String[] args) {
        //没有catch会直接执行finally，然后直接退出程序
        try {
            int n1 = 10;
            int n2 = 0;
            System.out.println(n1 / n2);
        }finally {
            System.out.println("执行了finally。。");
        }
        System.out.println("程序继续执行。。");
    }
}
