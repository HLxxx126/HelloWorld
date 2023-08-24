package com.hspedu.chapter17.threaduse;

/**
 * @author HLxxx
 * @version 1.0
 * main线程启动2个子线程
 */
public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}
class T1 implements Runnable{
    int count = 0;
    @Override
    public void run() {
       while (true) {//每隔1秒输出“Hello，World”输出10次
           System.out.println("Hello,World" + (++count));
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           if (count == 10){
               break;
           }
       }
    }
}
class T2 implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while (true) {//每隔1秒输出“Hi”输出5次
            System.out.println("Hi" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 5){
                break;
            }
        }
    }
}