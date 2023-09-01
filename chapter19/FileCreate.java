package com.hspedu.chapter19;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 * 创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }
    //方式一 new File(String pathname)
    @Test
    public void create01(){
        String filePath = "src/com/hspedu/chapter19/news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //方式二 new File (File parent,String child)//根据父目录文件+子路径构建
    @Test
    public void create02(){
        File parentFile = new File(("src/com/hspedu/chapter19/"));
        String fileName = "news2.txt";
        //这里的file对象，在java程序中，只是一个java对象，
        //只有执行了createNewFile()才会真正的在磁盘创建文件
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件2创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //方式三 new File(String parent,String child)//根据父目录+子路径构建
    @Test
    public void create03(){
        String parentPath = "src/com/hspedu/chapter19/";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("文件3创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
