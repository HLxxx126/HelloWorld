package com.hspedu.chapter19.outputstream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author HLxxx
 * @version 1.0
 */
public class FileCopy {
    public static void main(String[] args) {
        //完成 文件拷贝
        //1.创建文件的输入流，将文件读入到程序
        //2.创建文件的输出流，将读取到的文件数据，写入到指定文件
        String srcFilePath ="src/com/hspedu/chapter19/11.jpg";
        String destFilePath ="src/com/hspedu/chapter19/demo/11.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            //定义一个字节数组，提高读取效率
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf))!= -1){
                //读取到后，就写入文件 通过fileOutputStream//即一边读，一边写
                fileOutputStream.write(buf,0,readLen);
            }
            System.out.println("拷贝成功。。");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
                if (fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
