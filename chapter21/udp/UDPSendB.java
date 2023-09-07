package com.hspedu.chapter21.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author HLxxx
 * @version 1.0
 * UDP发送端---->也可以接收数据
 */
public class UDPSendB {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket对象，准备在9998端口接收数据
        DatagramSocket socket = new DatagramSocket(9998);
        //将需要发送的数据，封装到DatagramPacket对象
        byte[] data = "hello，明天吃火锅～".getBytes();
        DatagramPacket packet = new DatagramPacket
                (data, data.length, InetAddress.getByName("127.0.0.1"), 9999);
        socket.send(packet);
        //接收A端的回复并拆包读取
        byte[] buf = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf,buf.length);
        socket.receive(packet1);
        int length = packet1.getLength();
        byte[] data1 = packet1.getData();
        String s = new String(data1, 0, length);
        System.out.println(s);

        //关闭资源
        socket.close();
        System.out.println("B端退出");
    }
}
