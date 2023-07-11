package com.hspedu.chapter10.single;

import java.util.concurrent.Callable;

public class SingleTon02 {//懒汉式

    public static void main(String[] args) {
        System.out.println(Cat.n1);
       Cat instance = Cat.getInstance();
        System.out.println(instance);
        Cat instance2 = Cat.getInstance();
        System.out.println(instance2);
        System.out.println(instance == instance2);
            }
        }
class Cat{
    private String name;
    public static int n1 = 999;
    private static Cat cat;
    private Cat(String name) {
        this.name = name;
        System.out.println("构造器被调用。。。");
    }
    public static Cat getInstance(){
        if (cat == null){
            cat = new Cat("小可爱");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}