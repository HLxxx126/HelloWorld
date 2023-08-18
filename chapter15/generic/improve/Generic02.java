package com.hspedu.chapter15.generic.improve;

import java.util.ArrayList;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Generic02 {//使用泛型

    public static void main(String[] args) {
        ArrayList<Dog> list = new ArrayList<Dog>();
        list.add(new Dog("旺财",10));
        list.add(new Dog("发财",1));
        list.add(new Dog("小黄",5));
        //假如不小心添加了一只猫
        //list.add(new Cat("招财猫",8));//使用泛型只能存放Dog，这边编译器会发现错误，报错
        //遍历能直接取出Dog类型而不是Object类更方便
        for (Dog dog :list) {
            System.out.println(dog.getName() + "-" + dog.getAge() );
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
