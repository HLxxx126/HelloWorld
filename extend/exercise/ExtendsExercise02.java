package com.hspedu.extend.exercise;

public class ExtendsExercise02 {
    public static void main(String[] args) {
        E e = new E();
    }
}
class C{
    public C(){
        System.out.println("我是C类");
    }
}
class D extends C{
    public D(){
        System.out.println("我是D类的无参构造器");
    }
    public D(String name){
        System.out.println(name + "我是D类的有参构造器");
    }
}
class E extends D{
    public E(){
        this("hello");
        System.out.println("我是E类的无参构造器");
    }
    public E(String name){
        super("hahah");
        System.out.println("我是E类的有参构造器");
    }
}
