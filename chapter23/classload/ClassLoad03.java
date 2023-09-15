package com.hspedu.chapter23.classload;

/**
 * @author HLxxx
 * @version 1.0
 * 类加载初始化阶段
 */
public class ClassLoad03 {
    public static void main(String[] args) {
        //1.加载B类，并生成B的class对象
        //2.链接  num = 0
        //3.初始化阶段，一次自动收集类中所有静态变量的赋值动作和静态代码块中的语句，并合并
         new B();//类加载
        //4.B（）构造器被执行
        System.out.println(B.num);
    }
}
class B {
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }
    static int num = 100;
    public B(){
        System.out.println("B 构造器被执行");
    }
}