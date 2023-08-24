package com.hspedu.chapter17.ticket;

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
        System.out.println("使用接口方式进行售票");//也会有超卖现象
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();//第一个线程
        new Thread(sellTicket02).start();//第二个线程
        new Thread(sellTicket02).start();//第三个线程

    }
}
//使用Thread方式
class SellTicket01 extends Thread{
    private static int ticketNum = 100;//让多个线程共享ticketNum

    @Override
    public void run() {
       while (true){
           if (ticketNum <= 0){
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
class SellTicket02 implements Runnable{
    private  int ticketNum = 100;//让多个线程共享ticketNum
    @Override
    public void run() {
        while (true){
            if (ticketNum <= 0){
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