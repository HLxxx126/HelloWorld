package com.hspedu.chapter19.outputstream_;

import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 */
public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    /**
     * 使用FileOutputStream将数据写到文件中
     * 如果该文件不存在，则创建该文件
     */
    @Test
    public void writeFile(){
        //创建FileOutputStream对象
        String filePath = "src/com/hspedu/chapter19/a.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //得到FileOutputStream对象
            //fileOutputStream = new FileOutputStream(filePath)创建方式，当写入内容时，会覆盖原来的内容
            //fileOutputStream = new FileOutputStream(filePath，true)创建方式，当写入内容时，会追加到文件后面
            fileOutputStream = new FileOutputStream(filePath);
            //写入一个字节
            fileOutputStream.write('a');//char->int
            //写入字符串
            String str = "hello,word!";
            //str.getBytes()可以把一个字符串转成字节数组
            fileOutputStream.write(str.getBytes());
            //写入字符串中部分字符
            fileOutputStream.write(str.getBytes(),0,3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
