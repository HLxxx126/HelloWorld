package com.hspedu.chapter15.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 * 泛型的继承和通配符
 */
public class GenericExtends {
    public static void main(String[] args) {
        Object o = new String("xx");
        //List<Object> list = new ArrayList<String>();//错误，泛型没有继承性
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();
        //List<?>表示任意的泛型类型都能接受
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

//        printCollection2(list1);//错误
//        printCollection2(list2);//错误
        printCollection2(list3);//正确
        printCollection2(list4);//正确
        printCollection2(list5);//正确

        printCollection3(list1);//正确
//        printCollection3(list2);//错误
        printCollection3(list3);//正确
//        printCollection3(list4);//错误
//        printCollection3(list5);//错误
    }
    public static void printCollection1(List<?>c){//List<?>表示任意的泛型类型都能接受
        for (Object object : c) {//通配赴，取出时，就是Object
            System.out.println(object);
        }
    }
    //？extends AA表示 上限，可以接受AA或者AA子类
    public static void printCollection2(List<?extends AA> c){
        for (Object object :c) {
            System.out.println(object);
        }
    }
    //?super子类类名AA*支持AA类即AA类的父类，不限于直接父类，规定了泛型的下限
    public static void printCollection3(List<? super AA > c){
        for (Object object :c) {
            System.out.println(object);

        }

    }
}
class AA{}
class BB extends AA{}
class CC extends BB{}