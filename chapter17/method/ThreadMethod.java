package com.hspedu.chapter17.method;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        //测试相关方法
        T t = new T();
        t.setName("老韩");
        t.setPriority(Thread.MIN_PRIORITY);//1
        t.start();
        //主线程打印5个hi，然后中断子线程休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi" + i);
        }
        System.out.println(t.getName() + "线程的优先级为" + t.getPriority());//1
        t.interrupt();//当执行到这里时就会中断t的休眠
    }
}
class T extends Thread{//自定义线程类
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "吃包子～～～" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "休眠中～～～");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //当该线程执行到一个interrupt方法时，就会catch一个异常，可以加入自己的业务代码
                //InterruptedException是捕获到一个中断异常
                System.out.println(Thread.currentThread().getName() + "被 interrupt了");
            }
        }
    }
}