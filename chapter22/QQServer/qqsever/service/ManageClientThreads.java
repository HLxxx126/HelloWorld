package com.hspedu.chapter22.QQServer.qqsever.service;

import com.sun.security.ntlm.Client;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author HLxxx
 * @version 1.0
 * 该类用于管理和客户端通信的线程
 */
public class ManageClientThreads {
    private static HashMap<String, SeverConnectClientThread> hm = new HashMap<>();

    public static HashMap<String, SeverConnectClientThread> getHm() {
        return hm;
    }

    //添加线程对象到hm集合
    public static void addClientThread(String userId,SeverConnectClientThread severConnectClientThread){
        hm.put(userId,severConnectClientThread);
    }
    //根据userId返回线程
    public static SeverConnectClientThread getSeverConnectClientThread(String userId){
        return hm.get(userId);
    }
    //增加一个方法从集合中，移除某个线程对象
    public static void removeSeverConnectClientThread(String userId){
        hm.remove(userId);
    }
    //这里编写方法，可以返回在线用户列表
    public static String getOnlineUser(){
        //集合遍历，遍历hashmap的key
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()){
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }
}
