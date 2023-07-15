package com.hspedu.chapter10.InnerClass;

public class StaticInnerClass01 {
    public static void main(String[] args) {
        Outer09 outer09 = new Outer09();
        outer09.m1();
        //外部其他类使用静态内部类
        //方法1
        Outer09.Inner09 inner09 = new Outer09.Inner09();
        inner09.say();
        //方法2 编写方法返回静态内部类
        Outer09.Inner09 getInner09 = outer09.getInner09();
        getInner09.say();
        Outer09.Inner09 getInner09_ = Outer09.getInner09_();
        getInner09_.say();

    }
}
class Outer09{//外部类
    private int n1 = 10;
    private static String name = "张三";
    private static void cry(){}
    public static class Inner09{//静态内部类，放在外部成员位置//可以添加任意访问修饰符
        public void say(){//可以直接访问外部类的所有静态成员包括私有的，不能直接访问非静态成员
            System.out.println(name);
            cry();
        }
    }
    public Inner09 getInner09(){
        return new Inner09();
    }
    public static Inner09 getInner09_(){
        return new Inner09();
    }
public void m1(){
    Inner09 inner09 = new Inner09();
    inner09.say();
}
}