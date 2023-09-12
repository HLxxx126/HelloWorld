package com.hspedu.chapter22.QQClient.qqclient.service;

import com.hspedu.chapter22.qqcommom.Message;
import com.hspedu.chapter22.qqcommom.MessageType;
import com.hspedu.chapter22.qqcommom.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author HLxxx
 * @version 1.0
 * 该类完成用户登陆验证和用户注册等功能
 */
public class UserClientService {
    private User u = new User();
    private Socket socket;
    //根据userId和pwd到服务器验证该用户是否合法
    public boolean checkUser(String userId,String pwd){
        //创建User对象
        boolean b = false;
        u.setUserId(userId);
        u.setPasswd(pwd);
        //连接到服务端，发送u对象
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //得到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送user对象

            //读取从服务器回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message)ois.readObject();
            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){//登录成功
                //创建一个和服务器端保持通信的线程-》创建一个类ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动客户端的线程
                clientConnectServerThread.start();
                //将线程放入到集合中管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
                b = true;
            }else {//如果登录失败，关闭socket
                socket.close();

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return b;
    }
    //向服务器端请求在线用户列表
    public void onlineFriendList(){
        //发送一个Message，类型MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        //发送给服务器
        try {//得到当前线程的Socket对应的ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).
                            getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //编写方法退出客户端，并给服务端发送一个退出系统的message对象
    public void logout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());
        //发送message
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + "退出了系统");
            System.exit(0);//结束进程
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
