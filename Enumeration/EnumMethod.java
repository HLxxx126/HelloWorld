package com.hspedu.chapter11.Enumeration;

/**
 * @author HLxxx
 * @version 1.0
 *演示Enum类的各种方法的使用
 *
 */

public class EnumMethod {
    public static void main(String[] args) {
//使用Season2枚举类，来演示各种方法
        Season2 autumn = Season2.AUTUMN;
        //输出枚举对象的名字
        System.out.println(autumn.name());
        //ordinal（）输出的是该枚举对象的次序/编号，（从0开始编号）
        //AUTUMN枚举对象是第四个，因此输出3
        System.out.println(autumn.ordinal());
        //values()返回Season2【】，含有定义的所有枚举对象
        Season2[] values = Season2.values();
        for (Season2 season: values) {//增强for循环
            System.out.println(season);
        }
        //valueOf查找
        Season2 autumn1 = Season2.valueOf("AUTUMN");
        System.out.println("autumn1 = " + autumn1);
        System.out.println(autumn == autumn1);
        //compareTo：比较两个枚举常量，比较的就是编号//Season2.AUTUMN的编号- Season.SUMMER的编号3-2
        System.out.println(Season2.AUTUMN.compareTo(Season2.SUMMER));
    }
}
