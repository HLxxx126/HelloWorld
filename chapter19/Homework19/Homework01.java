package com.hspedu.chapter19.Homework19;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "src/com/hspedu/chapter19/mytemp";
        File file = new File(directoryPath);
        if (!file.exists()){
            if (file.mkdirs()){
                System.out.println("文件夹创建成功");
            }else{
                System.out.println("文件夹创建失败");
            }
        }
        String filePath = directoryPath + "/hello.txt";
        file = new File(filePath);
        if (!file.exists()){
            if (file.createNewFile()){
                System.out.println("文件创建成功");
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("hello,world~~");
                bufferedWriter.close();
            }else {
                System.out.println("文件创建失败");
            }
        }else {
            System.out.println("文件已经存在");
        }
    }
}
