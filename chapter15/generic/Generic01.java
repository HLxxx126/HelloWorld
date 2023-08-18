package com.hspedu.chapter15.generic;

import java.util.ArrayList;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Generic01 {//传统方法
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Dog("旺财",10));
        list.add(new Dog("发财",1));
        list.add(new Dog("小黄",5));
        //假如不小心添加了一只猫
        list.add(new Cat("招财猫",8));//加入没有异常
        //遍历
        for (Object o :list) {//需要向下转型为Dog
            Dog dog = (Dog) o;//遍历产生异常
            System.out.println(dog.getName() + "-" + dog.getAge());
        }

    }
}
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Cat{
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}