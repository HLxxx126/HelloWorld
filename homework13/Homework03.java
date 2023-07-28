package com.hspedu.chapter13.homework13;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) {
        String name = "Han shun Ping";
        printName(name);
    }
    public static void printName(String str){
        if (str == null){
            System.out.println("str 不能为空");
            return;
        }
        String[] name = str.split(" ");
        if (name.length != 3){
            System.out.println("输入字符串格式不对");
            return;
        }
        String format = String.format("%s,%s.%c",name[2],name[0],name[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
