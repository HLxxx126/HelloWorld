package com.hspedu.chapter22.QQClient.qqclient.service;

import com.hspedu.chapter22.qqcommom.Message;
import com.hspedu.chapter22.qqcommom.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author HLxxx
 * @version 1.0
 * 该类提供和消息相关的服务方法
 */
public class MessageClientService {
    public void sendMessageToOne(String content,String sendId,String getterId){
        //构建message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(sendId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(new java.util.Date().toString());//发送时间
        System.out.println(sendId + " 对 " + getterId + " 说 " + content);
        //发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(sendId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void sendMessageToAll(String content,String sendId){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
        message.setSender(sendId);
        message.setContent(content);
        message.setSendTime(new java.util.Date().toString());//发送时间
        System.out.println(sendId + " 对大家说 " + content);
        //发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(sendId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
