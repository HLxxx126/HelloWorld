package com.hspedu.chapter14.set;

import java.util.HashSet;

/**
 * @author HLxxx
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class HashSet01 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        //在执行add方法后，会返回一个boolean值，添加成功返回true，添加失败返回false
        System.out.println(set.add("john"));
        System.out.println(set.add("lucy"));
        System.out.println(set.add("john"));//false
        System.out.println(set.add("jack"));
        System.out.println(set.add("Rose"));
        set.remove("john");
        System.out.println("set = " + set);

        //不能添加相同的元素？数据？
        set = new HashSet();
        set.add("lucy");//添加成功
        set.add("lucy");//加入不了
        set.add(new Dog("tom"));//添加成功
        set.add(new Dog("tom"));//添加成功//这两个为不同对象
        System.out.println("set = " + set);

        //再加深一下，非常经典的面试题。
        set.add(new String("hsp"));//ok
        set.add(new String("hsp"));//X加入不了
        System.out.println("set = " + set);
    }
}
class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}