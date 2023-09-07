package com.hspedu.chapter21.homework21;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HLxxx
 * @version 1.0
 * 文件下载服务端
 */
public class Homework03Server {
    public static void main(String[] args) throws Exception {
        //监听9999端口，等待客户端连接,读取客户端发送的下载文件的名字
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int length = 0;
        String downLoadFileName = "";
        while ((length = inputStream.read(b)) != -1){
            downLoadFileName = new String(b,0,length);
        }
        System.out.println("客户端希望下载的文件名 = " + downLoadFileName);

        String resFileName = "";
        if ("高山流水".equals(downLoadFileName)){
            resFileName = "src/com/hspedu/chapter21/高山流水.mp3";
        }else {
            resFileName = "src/com/hspedu/chapter21/无名.mp3";
        }
        //创建输入流读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));

        //使用工具类StreamUtilStreamUtilsStreamUtils读取文件到一个字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //得到socket关联的输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //写入数据通道，返回给客户端
        bos.write(bytes);
        socket.shutdownOutput();
        //关闭相关流
        bis.close();
        bos.close();
        socket.close();
        serverSocket.close();
        inputStream.close();
        System.out.println("服务端退出。。  ");
    }
}
