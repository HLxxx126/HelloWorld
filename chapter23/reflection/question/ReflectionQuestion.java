package com.hspedu.chapter23.reflection.question;

import com.hspedu.chapter23.Cat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author HLxxx
 * @version 1.0
 * 引入反射问题
 */
@SuppressWarnings({"all"})
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //根据配置文件re.properties指定信息，创建Cat对象并调用方法hi

        //传统方式new 对象-》调用方法
//        Cat cat = new Cat();
//        cat.hi();
        //1.使用Properties类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/hspedu/chapter23/re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath = " + classfullpath );
        System.out.println("method = " + methodName);
        //2.创建对象，传统方法行不通-》反射机制
        //new classfullpath();

        //3.使用反射机制解决
        //（1）加载类,返回Class类型的对象
        Class cls = Class.forName(classfullpath);
        //（2）通过cls得到你加载的类"src.com.hspedu.chapter23.Cat"的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型="+o.getClass());
        //(3)通过cls得到你加载的类src.com.hspedu.chapter23.Cat的methodName“hi”的方法对象
        //即在反射中。可以把方法视为对象
        Method method = cls.getMethod(methodName);
        //（4）通过method调用方法：即通过方法对象来实现调用方法
        System.out.println("-------------------------");
        method.invoke(o);//传统方法 对象.方法（），反射机制方法.invoke（对象）
    }
}
