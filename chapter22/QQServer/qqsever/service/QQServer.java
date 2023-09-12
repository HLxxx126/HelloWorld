package com.hspedu.chapter22.QQServer.qqsever.service;

import com.hspedu.chapter22.qqcommom.Message;
import com.hspedu.chapter22.qqcommom.MessageType;
import com.hspedu.chapter22.qqcommom.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author HLxxx
 * @version 1.0
 * 服务器，监听9999端口，等待客户端连接，并保持通讯
 */
public class QQServer {
    private ServerSocket ss = null;
    //创建一个集合，存放多个用户，如果是这些用户登陆，就认为是合法的
    private static HashMap<String,User> validUsers = new HashMap<>();
    static {//在静态代码块，初始化validUsers
        validUsers.put("100",new User("100","123456"));
        validUsers.put("200",new User("200","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("至尊宝",new User("至尊宝","123456"));
        validUsers.put("紫霞仙子",new User("紫霞仙子","123456"));
        validUsers.put("菩提老祖",new User("菩提老祖","123456"));
    }
    //验证用户是否合法的方法
    private boolean checkUser(String userId,String passwd){
        User user = validUsers.get(userId);
        if (user == null){//说明userId不存在
            return false;
        }
        if (!user.getPasswd().equals(passwd)){//用户存在但密码错误
            return false;
        }
        return true;
    }

    public QQServer(){
        try {
            System.out.println("服务器在9999端口监听");
            //启动推送新闻的线程
            new Thread(new SendNewsToAll()).start();
            ss = new ServerSocket(9999);
            while (true){//当和某个客户端连接后，会继续监听，因此使用while循环
                Socket socket = ss.accept();
                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User u = (User) ois.readObject();//读取客户端发送的User对象
                //创建一个Message对象，准备回复客户端
                Message message = new Message();
                //验证用户 方法
                if (checkUser(u.getUserId(),u.getPasswd())){//合法
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复
                    oos.writeObject(message);
                    //创建一个线程，和客户端保存通信
                    SeverConnectClientThread severConnectClientThread =
                            new SeverConnectClientThread(socket, u.getUserId());
                    //启动该线程
                    severConnectClientThread.start();
                    //把该线程对象放入一个集合进行管理
                    ManageClientThreads.addClientThread(u.getUserId(), severConnectClientThread);
                }else{
                    System.out.println("用户 ID= " + u.getUserId() + "验证失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //关闭socket
                    socket.close();
                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //如果服务端退出了while，说明服务器端不再监听，因此关闭SeverSocket
            try {
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
