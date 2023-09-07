package com.hspedu.chapter21.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author HLxxx
 * @version 1.0
 * UDP接收端
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象，准备在9999端口接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //构建一个DatagramPacket对象，准备接收数据
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        //调用接收方法
        System.out.println("接收端A 等待接收数据。。");
        socket.receive(packet);
        //把packet进行拆包，取出数据并显示
        int length = packet.getLength();//实际接收到的数据长度
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);
        //回复信息给B端
        byte[] bytes = "好的，明天见".getBytes();
        DatagramPacket packet1 = new DatagramPacket
                (bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 9998);
        socket.send(packet1);
        //关闭资源
        socket.close();
        System.out.println("A端退出");
    }
}
