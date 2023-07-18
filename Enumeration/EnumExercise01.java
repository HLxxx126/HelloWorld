package com.hspedu.chapter11.Enumeration;

/**
 * @author HLxxx
 * @version 1.0
 */
public class EnumExercise01 {
    public static void main(String[] args) {
        Gender2 boy = Gender2.BOY;
        Gender2 boy2 = Gender2.BOY;
        System.out.println(boy);//本质是调用Gender2的父类Enum的toString（）
        //即public String toString(){return name;}//输出BOY
        System.out.println(boy2 == boy);
    }
}
enum Gender2{
    BOY,GIRL;


}