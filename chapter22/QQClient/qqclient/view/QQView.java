package com.hspedu.chapter22.QQClient.qqclient.view;

import com.hspedu.chapter22.QQClient.qqclient.service.FileClientService;
import com.hspedu.chapter22.QQClient.qqclient.service.MessageClientService;
import com.hspedu.chapter22.QQClient.qqclient.service.UserClientService;
import com.hspedu.chapter22.QQClient.qqclient.utils.Utility;

/**
 * @author HLxxx
 * @version 1.0
 * 客户端的菜单界面
 */
public class QQView {
    //显示主菜单
    private boolean loop = true;//控制是否显示菜单
    private String key = "";//接收用户的键盘输入
    private UserClientService userClientService = new UserClientService();
    private MessageClientService messageClientService = new MessageClientService();//对象用于用户消息的发送
    private FileClientService fileClientService = new FileClientService();//对象用于发送文件

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统。。。。。");
    }
    private void  mainMenu(){
        while(loop){
            System.out.println("===========欢迎登陆王阔通信系统==========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readString(1);
            //根据用户的输入来处理不同的逻辑
            switch (key){
                case "1":
                    System.out.print("请输入用户号：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密 码 ：");
                    String pwd = Utility.readString(50);
                    //这里需要到服务端去验证该用户是否合法
                    //编写一个类UserClientService

                    if (userClientService.checkUser(userId,pwd)){
                        System.out.println("===========欢迎 (用户 " + userId + " 登录成功）==========");
                        //进入二级菜单
                        while (loop){
                            System.out.println("\n===========网络通信系统二级菜单（用户 " + userId + " )==========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    //写一个方法获取在线用户列表
                                    userClientService.onlineFriendList();
                                    //System.out.println("显示在线用户列表");
                                    break;
                                case "2":
                                    System.out.print("请输入想对大家说的话：");
                                    String s = Utility.readString(100);
                                    //调用一个方法将消息封装成message对象，发送给服务端
                                    messageClientService.sendMessageToAll(s,userId);

                                    break;
                                case "3":
                                    System.out.print("请输入想聊天的用户名（在线）：");
                                    String getterId = Utility.readString(50);
                                    System.out.print("请输入想说的话：");
                                    String content = Utility.readString(100);
                                    //编写一个方法将私聊信息发给服务端
                                    messageClientService.sendMessageToOne(content,userId,getterId);
                                    break;
                                case "4":
                                    System.out.print("你想把文件发给：");
                                    getterId = Utility.readString(50);
                                    System.out.print("发送文件的路径：");
                                    String src = Utility.readString(100);
                                    System.out.print("发送到对方的路径：");
                                    String dest = Utility.readString(100);
                                    fileClientService.sendFileToOne(src,dest,userId,getterId);
                                    break;
                                case "9":
                                    //调用方法，给服务器发送一个退出系统的message
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    }else {//登陆服务器失败
                        System.out.println("=======登陆失败======");
                    }
                    break;
                case  "9":
                    loop = false;
                    break;
            }
        }
    }
}
