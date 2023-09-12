package com.hspedu.chapter22.QQServer.qqsever.service;

import com.hspedu.chapter22.QQClient.qqclient.utils.Utility;
import com.hspedu.chapter22.qqcommom.Message;
import com.hspedu.chapter22.qqcommom.MessageType;


import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * @author HLxxx
 * @version 1.0
 */
public class SendNewsToAll implements Runnable {
    @Override
    public void run() {
        //为了可以推送多次，使用while循环
        while (true) {
            System.out.print("请输入服务器要推送的消息(输入exit退出推送服务）：");
            String news = Utility.readString(1000);
            if ("exit".equals(news)){
                break;
            }
            //构建一个消息，群发消息
            Message message = new Message();
            message.setSender("服务器");
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            message.setContent(news);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人说： " + news);
            //遍历当前所有通信线程，得到socket，并发送message
            HashMap<String, SeverConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String onlineUserId = iterator.next().toString();
                SeverConnectClientThread severConnectClientThread = hm.get(onlineUserId);
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(severConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
