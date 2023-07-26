package com.hspedu.chapter13.string;

/**
 * @author HLxxx
 * @version 1.0
 */
public class String01 {
    public static void main(String[] args) {
        String name = "jack";//"jack"是字符串常量
        //String有很多构造器，构成了重载
        //5个常用构造器
       /* String s1 = new String();
        String s2 = new String(String original);
        String s3 = new String(char[] a);
        String s4 = new String(char[] a,int startIndex,int count);
        String s5 = new String(byte[] b);*/
        //String类实现了接口Serializable 【String 可以串行化：可以在网络传输】
        //             接口Comparable 【String 对象可以比较大小】
        //String 是final类，不能被其他类继承
        //String 有属性 private final char value【】；用于存放字符串内容
        //value是一个final类型，不可以修改，即value】不能指向新的地址，但单个字符内容可以改变
        final char[] value = {'a','b','c'};
        value[0] = 'H';
        char[] v2 = {'t','o','m'};
//        value = v2;//不能修改地址

    }
}
