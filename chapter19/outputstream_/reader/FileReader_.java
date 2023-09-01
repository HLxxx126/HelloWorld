package com.hspedu.chapter19.outputstream_.reader;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 */
public class FileReader_ {
    public static void main(String[] args) {
        String filePath ="src/com/hspedu/chapter19/story.txt";
        FileReader fileReader = null;
        int date = 0;
        //1.创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read,单个字符读取
            while ((date = fileReader.read())!= -1){
                System.out.print((char) date);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    //使用字符数组读取文件
    @Test
    public void readFile01(){
        System.out.println("~~~~~~readFile01~~~~~~");
        String filePath ="src/com/hspedu/chapter19/story.txt";
        FileReader fileReader = null;
        int readLen = 0;
        char[] buf = new char[8];
        //1.创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read(buf),返回的是实际读取到的字符数，如果返回-1，说明文件结束
            while ((readLen = fileReader.read(buf))!= -1){
                System.out.print(new String(buf,0,readLen));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
