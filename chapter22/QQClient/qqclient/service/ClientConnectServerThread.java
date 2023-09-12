package com.hspedu.chapter22.QQClient.qqclient.service;

import com.hspedu.chapter22.qqcommom.Message;
import com.hspedu.chapter22.qqcommom.MessageType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ClientConnectServerThread extends Thread {
    //该线程需要持有Socket
    private Socket socket;
    public ClientConnectServerThread(Socket socket){//构造器可以接收一个socket对象
        this.socket = socket;
    }

    @Override
    public void run() {//因为Thread需要在后台和服务器通信，因此用while循环
        while (true){
            try {
                System.out.println("客户端线程，等待读取从服务器端发送的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message mes = (Message)ois.readObject();
                //判断这个mes类型，然后做相应的业务处理
                if (mes.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND) ){
                    //取出在线信息并显示
                    String[] onlineUsers = mes.getContent().split(" ");
                    System.out.println("\n======当前在线用户列表======");
                    for (int i = 0; i < onlineUsers.length; i++) {
                        System.out.println("用户：" + onlineUsers[i]);
                    }
                    System.out.println();
                }else if (mes.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    System.out.println("\n" + mes.getSender() + " 对大家说： " + mes.getContent());
                }else if (mes.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    //显示服务器端转发的消息
                    System.out.println("\n" + mes.getSender() +" 对 " + mes.getGetter() + " 说: " + mes.getContent());
                }else if (mes.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    System.out.println("\n" + mes.getSender() +" 给 " + mes.getGetter() + " 发送文件: " + mes.getSrc()
                    + "到我的：" + mes.getDest());
                    //取出message的文字字节数组，通过文件输出流写出到磁盘
                    FileOutputStream fileOutputStream = new FileOutputStream(mes.getDest());
                    fileOutputStream.write(mes.getFileBytes());
                    fileOutputStream.close();
                    System.out.println("\n保存文件成功");

                }else {
                    System.out.println("是其他类型");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    //为了更方便得到socket
    public Socket getSocket() {
        return socket;
    }
}
