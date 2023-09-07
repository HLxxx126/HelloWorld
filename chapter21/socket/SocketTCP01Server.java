package com.hspedu.chapter21.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HLxxx
 * @version 1.0
 * 服务端
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //在本机9999端口监听，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);//要求本机的9999端口未被占用
        System.out.println("服务端，在9999端口监听，等待连接");
        Socket socket = serverSocket.accept();//当有对象监听时返回socket对象
        System.out.println("服务器端socket 返回 " + socket.getClass());
        //通过socket.getInputStream（）读取客户端写入数据通道的数据
        InputStream inputStream = socket.getInputStream();
        //IO读取
        byte[] buf = new byte[1024];
        int readLen =0;
        while ((readLen=inputStream.read(buf)) != -1 ){
            System.out.println(new String(buf,0,readLen));
        }
        //关闭相关流
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
