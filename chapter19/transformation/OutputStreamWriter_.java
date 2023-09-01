package com.hspedu.chapter19.transformation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author HLxxx
 * @version 1.0
 * 使用OutputStreamWriter
 * 把FileOutputStream字节流，转成字符流OutputStreamWriter
 * 指定编码方式
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "src/com/hspedu/chapter19/hsp.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath),"gbk");
        osw.write("hi,韩顺平教育");
        osw.close();
        System.out.println("保存文件成功");
    }
}
