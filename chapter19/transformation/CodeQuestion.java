package com.hspedu.chapter19.transformation;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        //读取a.txt文件到程序
        //创建字符输入流 BufferedReader【处理流】
        //使用BufferedReader对象读取a.txt
        //默认情况下，读取文件时按照utf-8编码
        String filePath = "src/com/hspedu/chapter19/a.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String s = br.readLine();
        System.out.println("读到的内容：" + s);
        br.close();
    }
}
