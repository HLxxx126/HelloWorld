package com.hspedu.chapter19.transformation;

import java.io.*;

/**
 * @author HLxxx
 * @version 1.0
 * 使用derInputStreamReader转换流解决中文乱码问题
 * 将字节流FileInputStream转换为字符流InputStreamReader，指定编码gbk/utf-8
 */
public class derInputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "src/com/hspedu/chapter19/a.txt";
        //把FileInputStream转成InputStreamReader
        //指定编码gbk
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //把InputStreamReader传入BufferedReader
        BufferedReader br = new BufferedReader(isr);
        //读取
        String s = br.readLine();
        System.out.println("读取内容 = " + s);
        //关闭外层流
        br.close();

    }
}
