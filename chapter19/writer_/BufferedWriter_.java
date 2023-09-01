package com.hspedu.chapter19.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 * BufferedWriter的使用
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "src/com/hspedu/chapter19/ok.txt";
        //创建BufferedWriter
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("hello,韩顺平教育！");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("hello2,韩顺平教育！");
        bufferedWriter.newLine();
        bufferedWriter.write("hello3,韩顺平教育！");
        bufferedWriter.newLine();
        //关闭外层流即可
        bufferedWriter.close();
    }
}
