package com.hspedu.chapter21.upload;

import com.hspedu.upload.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author HLxxx
 * @version 1.0
 * 文件上传 客户端
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //客户端连接服务端，得到socket
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建读取磁盘文件的输入流
        String filePath = "src/com/hspedu/chapter21/11.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //通过socket获取到输出流，将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//将文件对应的字节数组写入数据通道
        bis.close();
        socket.shutdownOutput();//设置结束标志
        //接收数据通道中的信息
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = reader.readLine();
        System.out.println(s);


        //关闭相关流
        reader.close();
        bos.close();
        socket.close();


    }
}
