package com.hspedu.chapter17.method;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //希望当主线程结束，子线程自动结束
        //将子线程设置为守护线程,先设置，后启动
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("宝强在辛苦地工作。。。");
            Thread.sleep(1000);
        }
    }
}
class MyDaemonThread extends Thread{
    @Override
    public void run() {
        for (; ; ) {//无限循环
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("马蓉和宋晶快乐聊天，哈哈哈～～～");
        }
    }
}
