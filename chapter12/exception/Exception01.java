package com.hspedu.chapter12.exception;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        //如果认为一段代码可能出现异常/问题，可以使用try-catch异常处理机制来处理
        //快捷键：选中 command+option+t 选6
        try {
            int res = num1 / num2;
        } catch (Exception e) {
            System.out.println("出现异常的原因 ： " +e.getMessage());
        }
        System.out.println("程序继续运行。。。");
    }
}
