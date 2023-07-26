package com.hspedu.chapter13.string;

/**
 * @author HLxxx
 * @version 1.0
 */
public class StringMethod01 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "Hello";
        System.out.println(str1.equals(str2));//equals区分大小写判断内容是否相等
        System.out.println(str1.equalsIgnoreCase(str2));//equalsIgnoreCase忽略大小写判断内容是否相等
        System.out.println("韩顺平".length());//length获取字符个数即字符串长度
        String s1 = "wer@terwe@g";
        int index = s1.indexOf('@');//indexOf获取字符串对象中第一次出现的索引，索引从0开始，如果找不到，返回-1
        System.out.println(s1.indexOf("we"));
        System.out.println(index);
        index = s1.lastIndexOf('@');//lastIndexOf获取字符字符串中最后一次出现的索引，索引从0开始，如果找不到，返回-1
        System.out.println(index);
        String name = "hello,张三";
        //substring截取指定范围的字符
        System.out.println(name.substring(6));//从索引6开始截取后面的字符
        System.out.println(name.substring(0,5));//截取索引0-（5-1）的字符

    }
}
