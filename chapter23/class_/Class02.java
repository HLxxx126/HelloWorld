package com.hspedu.chapter23.class_;

import com.hspedu.chapter23.Car;

import java.lang.reflect.Field;

/**
 * @author HLxxx
 * @version 1.0
 * Class类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classAllPath = "com.hspedu.chapter23.Car";
        //获取到Car类 对应的Class对象
        Class cls = Class.forName(classAllPath);
        //输出cls
        System.out.println(cls);//显示cls对象，是哪个类的class对象
        System.out.println(cls.getClass());//输出cls运行类型 java.lang.Class
        //得到包名
        System.out.println(cls.getPackage().getName());//包名
        //得到全类名
        System.out.println(cls.getName());
        //通过cls创建对象实例
        Car car = (Car)cls.newInstance();
        System.out.println(car);//car.toString
        //通过反射获取属性brand
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));//不能为私有属性//宝马
        //通过反射给属性赋值
        brand.set(car,"奔驰");
        System.out.println(brand.get(car));//奔驰
        //得到所有属性(字段）
        System.out.println("-------所有字段属性-------");
        Field[] fields = cls.getFields();
        for (Field f :fields) {
            System.out.println(f.getName());
        }

    }
}
