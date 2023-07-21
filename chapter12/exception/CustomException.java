package com.hspedu.chapter12.exception;

/**
 * @author HLxxx
 * @version 1.0
 */
public class CustomException {
    public static void main(String[] args) {
        int age = 3;
        if (!(age >= 18 && age <= 120)) {
            throw new AgeException("年龄需要在18-120之间");//可以通过构造器设置提示信息
        }
        System.out.println("年龄范围正确");
    }
}
class AgeException extends RuntimeException{//自定义异常
    //一般自定义异常继承RuntimeException即定义为运行时异常，好处是可以使用默认处理机制，比较方便
    public AgeException(String message) {//构造器
        super(message);
    }
}
