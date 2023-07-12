package com.hspedu.chapter10.abstract_;

public class Abstract01 {
}

abstract class Animal {//当一个类中存在抽象方法时，需将该类声明为抽象类
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    //    public void eat(){
//        System.out.println("这是一个动物，但是不知道吃什么。。");
//    }
    public abstract void eat();
}