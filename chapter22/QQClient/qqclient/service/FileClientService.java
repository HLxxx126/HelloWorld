package com.hspedu.chapter22.QQClient.qqclient.service;

import com.hspedu.chapter22.qqcommom.Message;
import com.hspedu.chapter22.qqcommom.MessageType;

import java.io.*;

/**
 * @author HLxxx
 * @version 1.0
 * 该类完成文件传输服务
 */
public class FileClientService {
    public void sendFileToOne(String src,String dest,String sendId,String getterId){
        //读取src文件--》message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(sendId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);
        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int)new File(src).length()];
        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);//将文件读入到字节数组
            //将文件对应的字节数组设置message
            message.setFileBytes(fileBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //提示信息
        System.out.println("\n" + sendId + "给" + getterId + "发送文件：" + src + "到对方的" + dest);
        //发送
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageClientConnectServerThread.getClientConnectServerThread(sendId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
