package com.hspedu.chapter17.threaduse;

/**
 * @author HLxxx
 * @version 1.0
 * 通过实现Runnable来开发线程
 */
//由于java是单继承机制，若方法已经继承其他父类，则无法继承thread类，此时用实现Runnable接口实现线程开发
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start();//这里不能调用start方法
        //创建Thread对象，把dog对象（实现Runnable）放入thread
        Thread thread = new Thread(dog);
        thread.start();

    }
}
class Dog implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while (true){
            System.out.println("小狗汪汪叫..hi" + (++count) + Thread.currentThread().getName());
            //休眠1秒
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