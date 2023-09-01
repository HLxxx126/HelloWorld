package com.hspedu.chapter19.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 * FileInputStream的使用（字节输入流  文件-》 程序）
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }
    //读取文件
    //单个字节的读取，效率比较低
    //-》使用read（byte【】b）
    @Test
    public void readFile01(){
        String filePath = "src/com/hspedu/chapter19/hello.txt";
        int readDate = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建FileInputStream对象，用于读取hello.txt文件
            fileInputStream = new FileInputStream(filePath);
            while((readDate = fileInputStream.read()) != -1){
                System.out.print((char)readDate);//转成char显示
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //使用read（byte【】b）读取文件，提高效率
    @Test
    public void readFile02(){
        String filePath = "src/com/hspedu/chapter19/hello.txt";
        //字节数组
        byte[] buf = new byte[8];//一次读取8个字节
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建FileInputStream对象，用于读取hello.txt文件
            fileInputStream = new FileInputStream(filePath);
            while((readLen = fileInputStream.read(buf)) != -1){
                System.out.print(new String(buf,0,readLen));//转成char显示
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭文件流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


