package com.hspedu.chapter21.upload;

import com.hspedu.upload.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HLxxx
 * @version 1.0
 * 文件上传服务端
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器端在8888端口监听。。。。。");
        //等待连接
        Socket socket = serverSocket.accept();
        //读取客户端发送的数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //将得到的bytes数组，写入到指定的路径
        String destFilePath = "src/com/hspedu/chapter21/12.jpg";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();
        //向客户端回复“收到图片”
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.newLine();
        writer.flush();
        //关闭其他流
        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();



    }
}
