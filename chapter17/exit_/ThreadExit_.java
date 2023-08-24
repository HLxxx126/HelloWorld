package com.hspedu.chapter17.exit_;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        //如果希望main线程去控制t线程的终止，必须可以修改loop
        //让它退出run方法，从而终止t线程->通知方式
        //让主线程休眠10秒
        System.out.println("主线程休眠10秒");
        Thread.sleep(10*1000);
        t.setLoop(false);
    }
}
class T extends Thread{
    private int count = 0;
    //设置一个控制变量
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("T运行中。。。" + (++count));
        }
    }
}