package com.hspedu.chapter19.outputstream_;

import java.io.*;

/**
 * @author HLxxx
 * @version 1.0
 * 使用BufferedInputStream和BufferedOutputStream进行拷贝
 * 可以完成二进制文件的拷贝
 */
public class BufferedCopy02 {
    public static void main(String[] args) {
        String srcFilePath = "src/com/hspedu/chapter19/11.jpg";
        String destFilePath = "src/com/hspedu/chapter19/new11.jpg";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
            byte[] buff = new byte[1024];
            int readLen = 0;
            while ((readLen = bis.read(buff)) != -1){
                bos.write(buff,0,readLen);
            }
            System.out.println("文件拷贝完毕。。");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bis != null){
                    bis.close();
                }
                if ((bos != null)){
                    bos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
