package com.hspedu.chapter21.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author HLxxx
 * @version 1.0
 * 客户端，发送"Hello,server"给服务端 使用字符流
 */
@SuppressWarnings({"all"})
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //连接服务器,即连接本机的9999端口，如果连接成功返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端socket返回 = " + socket.getClass());
        //连接上后，生成Socket，通过socket.getOutputStream()得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写入数据到数据通道
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,sever 字符流");
        bufferedWriter.newLine();//插入一个换行符，表示写入内容结束，注意，⚠️此时要求对方使用readLine方式读取
        bufferedWriter.flush();//如果使用字符流需要手动刷新，否则数据不会写入数据通道


        //获取和socket相关的输入流并读取
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //必须关闭流对象和socket
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        System.out.println("客户端退出。。。");
    }
}
