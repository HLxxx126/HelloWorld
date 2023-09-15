package com.hspedu.chapter23.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author HLxxx
 * @version 1.0
 * 通过反射机制创建实例
 */
public class ReflecCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1.获取User类的Class对象
        Class userClass = Class.forName("com.hspedu.chapter23.reflection.User");

        //2.通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //3.通过public的有参构造器创建实例
        //3.1先得到对应构造器
        Constructor constructor = userClass.getConstructor(String.class);//该对象就是public有参构造器
        //3.2创建实例并传入实参
        Object skm = constructor.newInstance("skm");
        System.out.println(skm);
        //4.通过非public的有参构造器创建实例
        //4.1先得到对应构造器
        Constructor constructor1 = userClass.getDeclaredConstructor(int.class, String.class);
        //4.2 创建实例
        constructor1.setAccessible(true);//暴破（暴力破解），使用反射可以访问private构造器
        Object zuo = constructor1.newInstance(20, "zuo");
        System.out.println(zuo);


    }
}
class User{
    private int age = 10;
    private String name = "HLxxx";
    public User(){}
    public User(String name){
        this.name = name;
    }
    private User(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


