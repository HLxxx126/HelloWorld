package com.hspedu.chapter17.synchronized_;

/**
 * @author HLxxx
 * @version 1.0
 * 线程死锁
 */
public class DeadLock_ {
    public static void main(String[] args) {
//模拟死锁现象
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A 线程 ");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B 线程 ");
        A.start();
        B.start();
    }
}
class DeadLockDemo extends Thread{
    static Object o1 = new Object();//保证多线程，共享一个对象，这里使用static
    static Object o2 = new Object();
    boolean flag;
    public DeadLockDemo(boolean flag){
        this.flag =flag;
    }

    @Override
    public void run() {
        //如果flag为T，线程A会先得到o1对象锁，然后尝试获取o2对象锁
        //如果线程A得不到o2对象锁，就会Blocked
        //如果flag为F，线程B会先得到o2对象锁，然后尝试获取o1对象锁
        //如果线程B得不到o1对象锁，就会Blocked
        if (flag){
            synchronized (o1){//对象互斥锁，下面为同步代码
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        }else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }

        }
    }
}