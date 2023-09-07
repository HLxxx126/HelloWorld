package com.hspedu.chapter21.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author HLxxx
 * @version 1.0
 * 客户端，发送"Hello,server"给服务端
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //连接服务器,即连接本机的9999端口，如果连接成功返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket返回 = " + socket.getClass());
        //连接上后，生成Socket，通过socket.getOutputStream()得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写入数据到数据通道
        outputStream.write("hello,sever".getBytes());
        //必须关闭流对象和socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出。。。");
    }
}
