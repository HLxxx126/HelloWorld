package com.hspedu.chapter23.class_;

import com.hspedu.chapter23.Cat;

/**
 * @author HLxxx
 * @version 1.0
 * 对Class类特点的梳理
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class也是类，因此也继承Object类
        //2.Class类对象不是new出来的，而是系统创建的
        //（1）传统new对象
        Cat cat = new Cat();
        //(2)反射方式
        Class cls1 = Class.forName("com.hspedu.chapter23.Cat");
        //3.对某个类的class类对象，在内存中只有一份，因为类只加载一次
        Class cls2 = Class.forName("com.hspedu.chapter23.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());

    }
}
