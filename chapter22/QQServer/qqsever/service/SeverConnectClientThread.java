package com.hspedu.chapter22.QQServer.qqsever.service;

import com.hspedu.chapter22.qqcommom.Message;
import com.hspedu.chapter22.qqcommom.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author HLxxx
 * @version 1.0
 * 该类对应的对象和客户端保持通信
 */
public class SeverConnectClientThread extends Thread{
    private Socket socket;
    private String userId;

    public SeverConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("服务端和客户端"+userId+"保持通信，读取数据。。。");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //根据message类型做出相应业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    System.out.println(message.getSender() + "要在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //返回message
                    //构建一个Message对象，返回给客户端
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                }else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                   //需要遍历 管理线程的集合，，把所有线程的socket得到，然后对message进行转发
                    HashMap<String, SeverConnectClientThread> hm = ManageClientThreads.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()){
                        //取出在线用户的id
                        String onLineUserId = iterator.next().toString();
                        if (!onLineUserId.equals(message.getSender())){//排除自己
                            //进行转发
                            ObjectOutputStream oos = new ObjectOutputStream
                                    (hm.get(onLineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    //根据message获取getter id，然后获取对应线程
                    SeverConnectClientThread severConnectClientThread =
                            ManageClientThreads.getSeverConnectClientThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream
                            (severConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                    //根据getterId 获取到对应线程，将message对象转发
                    SeverConnectClientThread severConnectClientThread =
                            ManageClientThreads.getSeverConnectClientThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream
                            (severConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                }else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){//客户端退出
                    System.out.println(message.getSender() + "退出");
                    //将这个客户端对应的线程从集合删除
                    ManageClientThreads.removeSeverConnectClientThread(message.getSender());
                    socket.close();//关闭连接
                    //退出线程
                    break;
                }else {
                    System.out.println("其他message类型");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    public Socket getSocket() {
        return socket;
    }
}
