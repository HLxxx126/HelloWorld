package com.hspedu.chapter17.synchronized_;

import com.hspedu.chapter17.threaduse.Thread03;

/**
 * @author HLxxx
 * @version 1.0
 * 使用多线程模拟三个窗口同时售票100张
 */
public class SellTicket {
    public static void main(String[] args) {
        //测试
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
////        //这里会出现超卖现象
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();
//        System.out.println("使用接口方式进行售票");//也会有超卖现象
//        SellTicket02 sellTicket02 = new SellTicket02();
//        new Thread(sellTicket02).start();//第一个线程
//        new Thread(sellTicket02).start();//第二个线程
//        new Thread(sellTicket02).start();//第三个线程
        //测试sellTicket03
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();

    }
}

//使用Thread方式
class SellTicket01 extends Thread {
    private static int ticketNum = 100;//让多个线程共享ticketNum

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束。。");
                break;
            }
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口" + Thread.currentThread().getName() + " 售出一张票" +
                    "剩余票数：" + (--ticketNum));
        }
    }
}

//使用接口方式
class SellTicket02 implements Runnable {
    private int ticketNum = 100;//让多个线程共享ticketNum

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束。。");
                break;
            }
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口" + Thread.currentThread().getName() + " 售出一张票" +
                    "剩余票数：" + (--ticketNum));
        }
    }
}

//实现接口方式，使用synchronized实现线程同步
class SellTicket03 implements Runnable {
    private int ticketNum = 100;//让多个线程共享ticketNum
    private boolean loop = true;
    Object object = new Object();
    //同步方法（静态的）的锁为当前类本身
    public synchronized static void m1(){//锁是加在SellTicket03.class上
    }
    public static void m2(){
        synchronized (SellTicket03.class) {//在静态方法中实现一个同步代码块
            System.out.println("m2");
        }
    }

    //public synchronized void sell(){}是一个同步方法，这时锁在this对象，也可以在代码块上加锁
    public /*synchronized*/ void sell() {//同步方法，在同一时刻，只能有一个线程来执行sell 方法
        synchronized (/*this*/object) {//同步代码块，互斥锁还是加在this对象上
            if (ticketNum <= 0) {
                System.out.println("售票结束。。");
                loop = false;
                return;
            }
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口" + Thread.currentThread().getName() + " 售出一张票" +
                    "剩余票数：" + (--ticketNum));
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
