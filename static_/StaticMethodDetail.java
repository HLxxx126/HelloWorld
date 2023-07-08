package com.hspedu.chapter10.static_;

public class StaticMethodDetail {
    public static void main(String[] args) {
        D.hi();
//        D.say();//错误,需要先创建对象再调用
       new D().say();//可以
    }
}
class D{
    private int n1 = 100;
    private static int n2 = 200;
    public void say(){

    }
    public static void hi(){
    }
    public static void hello(){
        System.out.println(n2);
        System.out.println(D.n2);
        hi();
    }
}
