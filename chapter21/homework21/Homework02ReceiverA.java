package com.hspedu.chapter21.homework21;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author HLxxx
 * @version 1.0
 * UDP接收端
 */
@SuppressWarnings({"all"})
public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象，准备在8888端口接收数据
        DatagramSocket socket = new DatagramSocket(8888);
        //构建一个DatagramPacket对象，准备接收数据
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        //调用接收方法
        socket.receive(packet);
        //把packet进行拆包，取出数据并显示
        int length = packet.getLength();//实际接收到的数据长度
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        //判断接收到的信息是什么
        String answer = "";
        if ("四大名著是哪些".equals(s)){
            answer = "《红楼梦》、《三国演义》、《水浒传》、《西游记》";
        }else {
            answer = "what?";
        }
        System.out.println(s);
        //回复信息给B端
        byte[] bytes = answer.getBytes();
        DatagramPacket packet1 = new DatagramPacket
                (bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 9998);
        socket.send(packet1);
        //关闭资源
        socket.close();
        System.out.println("A端退出");
    }
}
