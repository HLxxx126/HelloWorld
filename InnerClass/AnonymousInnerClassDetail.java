package com.hspedu.chapter10.InnerClass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
    }
}
class Outer05{
    private int n1 = 99;
    public void f1(){
        //创建一个基于类的匿名内部类
        Person p = new Person(){
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了hi方法" + n1);
            }
        };
        p.hi();//动态绑定，运行类型是Outer05$1
        //也可以直接调用
        new Person(){
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了hi方法hhh");
            }

            @Override
            public void ok(String str) {
                super.ok(str);
            }
        }.ok("jack");
    }
}
class Person{//类
    public void hi(){
        System.out.println("Person hi()");
    }
    public void ok(String str){
        System.out.println("Person ok() " + str );
    }
}