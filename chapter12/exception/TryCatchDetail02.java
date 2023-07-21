package com.hspedu.chapter12.exception;

/**
 * @author HLxxx
 * @version 1.0
 */
public class TryCatchDetail02 {
    public static void main(String[] args) {
        //1.如果try代码块可能有多个异常，可以使用多个catch分别捕获不同的异常，相应处理
        //要求子类异常写在前面，父类异常写在后面
        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName());//NullPointerException
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;//ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class Person {
    private String name = "jack";

    public String getName() {
        return name;
    }
}