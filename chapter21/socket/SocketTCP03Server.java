package com.hspedu.chapter21.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HLxxx
 * @version 1.0
 * 服务端 使用字符流
 */
@SuppressWarnings({"all"})
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //在本机9999端口监听，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);//要求本机的9999端口未被占用
        System.out.println("服务端，在9999端口监听，等待连接");
        Socket socket = serverSocket.accept();//当有对象监听时返回socket对象
        System.out.println("服务器端socket 返回 " + socket.getClass());
        //通过socket.getInputStream（）读取客户端写入数据通道的数据
        InputStream inputStream = socket.getInputStream();
        //IO读取，使用字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //获取socket相关连的输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        //关闭相关流
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();

    }
}
