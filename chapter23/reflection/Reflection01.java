package com.hspedu.chapter23.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Reflection01 {
    public static void main(String[] args) throws Exception {
        //1.使用Properties类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/hspedu/chapter23/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        //3.使用反射机制解决
        //（1）加载类,返回Class类型的对象
        Class cls = Class.forName(classfullpath);
        //（2）通过cls得到你加载的类"src.com.hspedu.chapter23.Cat"的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass());
        //(3)通过cls得到你加载的类src.com.hspedu.chapter23.Cat的methodName“hi”的方法对象
        //即在反射中。可以把方法视为对象
        Method method = cls.getMethod(methodName);
        //（4）通过method调用方法：即通过方法对象来实现调用方法
        System.out.println("-------------------------");
        method.invoke(o);//传统方法 对象.方法（），反射机制方法.invoke（对象）
        //java.lan.reflect.Field:代表类的成员变量，Field对象表示某个类的成员变量
        //得到name字段
        Field nameField = cls.getField("age");//不能得到私有属性
        System.out.println(nameField.get(o));

        //java.lang.reflect.Constructor:代表类的构造方法，Constructor对象表示构造器
        Constructor constructor = cls.getConstructor();//()中可以指定构造器参数类型，这边返回无参构造器
        System.out.println(constructor);

        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);
    }
}

