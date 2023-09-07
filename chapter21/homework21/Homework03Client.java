package com.hspedu.chapter21.homework21;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author HLxxx
 * @version 1.0
 * 文件下载的客户端
 */
public class Homework03Client {
    public static void main(String[] args) throws Exception {
        //接收用户输入，指定下载文件名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名");
        String downloadFileName = scanner.next();
        //连接服务端，发送
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //获取和socket关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        socket.shutdownOutput();
        //读取服务端返回的文件（字节数组）
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //得到一个输出流，准备将bytes写入磁盘文件
        String filePath = "src/com/hspedu/chapter21/download/" + downloadFileName +".mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);
        //关闭相关流
        outputStream.close();
        bis.close();
        bos.close();
        socket.close();


    }
}
