package com.hspedu.chapter23.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author HLxxx
 * @version 1.0
 * 通过反射调用方法
 */
public class ReflecAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1.得到boss类对应的class对象
        Class<?> bossCls = Class.forName("com.hspedu.chapter23.reflection.Boss");
        //2.创建对象
        Object o = bossCls.newInstance();
        //3.调用public的hi方法
        //3.1得到hi方法对象
        Method hi = bossCls.getMethod("hi",String.class);
        //3.2调用
        hi.invoke(o,"HLxxx");
        //4.调用private state 方法
        //4.1得到say方法
        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        //4.2调用
        //暴破
        say.setAccessible(true);
        System.out.println(say.invoke(null,100,"张三",'男'));
        //5.在反射中，如果方法有返回值，统一返回Object,但是运行类型和方法定义的类型一致
        Object reVal = say.invoke(null, 300, "王五", '男');
        System.out.println("reVal 的运行类型 = " + reVal.getClass());//String
    }
}
class Boss{
    public int age;
    private static String name;
    public Boss() {
    }
    private static String say(int n, String s, char c){
        return n + " " + s + " " + c;
    }
    public void hi(String s){
        System.out.println("hi " + s);
    }
}
