package com.hspedu.chapter19.printstream;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author HLxxx
 * @version 1.0
 * 字节打印流PrintStream的使用
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        out.println("john,hello");
        //因为print的底层使用的是write，所以可以直接使用write进行打印/输出
        out.write("韩顺平，你好".getBytes());
        out.close();
        //可以修改打印流输出的位置/设备
        System.setOut(new PrintStream("src/com/hspedu/chapter19/f1.txt"));
        System.out.println("hello,韩顺平");
    }
}

