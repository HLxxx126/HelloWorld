package com.hspedu.chapter17.threaduse;

/**
 * @author HLxxx
 * @version 1.0
 * 通过Thread类创建线程
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //创建Cat对象,可以当做线程使用
        Cat cat = new Cat();
        cat.start();//启动线程//如果cat.ru（）则是普通方法会执行完run方法再继续执行下面内容，即会阻塞，不是真正多线程
        //当main线程启动一个子线程 Thread-0，主线程不会阻塞，会继续执行
        //这时主线程和子线程交替执行
        System.out.println("主线程继续执行" + Thread.currentThread().getName());//main
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程 I= " + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}
class Cat extends Thread{//当一个类继承了Thread类，该类就可以当作一个线程使用
    int times = 0;
    @Override
    public void run() {//重写run方法实现自己的业务逻辑
        while(true) {//让该线程每隔一秒在控制台输出“喵喵，我是小猫咪”
            System.out.println("喵喵，我是小猫咪"+(++times) + "线程名 = " + Thread.currentThread().getName());
            //让该线程休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times == 80){
                break;//当times到80，退出while，这是线程也退出
            }
        }
    }
}