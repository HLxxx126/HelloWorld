package com.hspedu.chapter23.reflection;

import java.lang.reflect.Field;

/**
 * @author HLxxx
 * @version 1.0
 * 反射操作属性
 */
public class ReflecAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //1.得到Student类对应的Class对象
        Class<?> stuClass = Class.forName("com.hspedu.chapter23.reflection.Student");
        //2.创建对象
        Object o = stuClass.newInstance();//o的运行类型就是Student
        System.out.println(o.getClass());//Student
        //3.使用反射得到age 属性对象
        Field age = stuClass.getField("age");
        age.set(o,88);//通过反射操作属性
        System.out.println(o);
        System.out.println(age.get(o));//直接返回age属性的值
        //4.使用反射操作name属性
        Field name = stuClass.getDeclaredField("name");
        //对name进行暴破
        name.setAccessible(true);
        //name.set(o,"HLxxx");
        name.set(null,"HLxxx");//因为name是static属性，因此o也可以写成null
        System.out.println(o);
        System.out.println(name.get(o));//获取属性值
        System.out.println(name.get(null));//获取属性值，要求name是静态属性
    }
}
class Student{
    public int age;
    private static String name;
    public Student(){
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}