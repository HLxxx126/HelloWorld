package com.hspedu.chapter23.classload;

/**
 * @author HLxxx
 * @version 1.0
 * 类加载的链接阶段-准备
 */
public class ClassLoad02 {
    public static void main(String[] args) {

    }
}
class A {
    public int n1 = 10;//n1是实例属性，不是静态变量，因此在准备阶段，不会分配内存
    public static int n2 = 20;//n2是静态变量，分配内存 n2 是默认初始化0，而不是20
    public static final int n3 = 30;//n3是常量，他和静态变量不一样，因为一旦赋值就不变 分配内存n3 = 30
}