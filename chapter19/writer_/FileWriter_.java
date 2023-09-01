package com.hspedu.chapter19.writer_;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "src/com/hspedu/chapter19/note.txt";
        FileWriter fileWriter = null;
        char[] chars = {'a','b','c'};
        //创建FileWriter对象

        try {
            fileWriter = new FileWriter(filePath);//默认是覆盖方式
            //1.write(int):写入单个字符
            fileWriter.write('H');
            //2.write(char[]):写入指定数组
            fileWriter.write(chars);
            //3.write（char【】，off，len）：写入指定数组的指定部分
            fileWriter.write("韩顺平教育".toCharArray(),0,3);
            //4.write(String):写入整个字符串
            fileWriter.write(" 你好，北京～");
            //5.write（String，off，len）：写入字符串的指定部分
            fileWriter.write("上海天津",0,2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //对于FileWriter一定要关闭流，或者flush，才能真正把数据写入到文件
        }
        System.out.println("程序结束。。。。");
    }
}
