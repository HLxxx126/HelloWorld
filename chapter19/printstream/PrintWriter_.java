package com.hspedu.chapter19.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author HLxxx
 * @version 1.0
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("src/com/hspedu/chapter19/f2.txt"));
        printWriter.print("hi,北京你好～");
        printWriter.close();
    }
}
