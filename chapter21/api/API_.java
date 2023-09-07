package com.hspedu.chapter21.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author HLxxx
 * @version 1.0
 * InetAddress类的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//输出本机的ip地址及主机名
        //根据指定的主机名 获取InetAddress对象
       // InetAddress host1 = InetAddress.getByName("dreammtank125noMacBook-Pro");
        //System.out.println(host1);
        //根据域名返回 InetAddress对象，比如www.baidu.com
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);
        //通过InetAddress对象，获取对应的地址
        String hostAddress = host2.getHostAddress();//IP
        System.out.println(hostAddress);
        //通过InetAddress对象，获取对应的主机名或者是域名
        String hostName = host2.getHostName();
        System.out.println(hostName);//域名www.baidu.com

    }
}
