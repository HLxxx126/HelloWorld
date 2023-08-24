package com.hspedu.chapter17.method;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        T3 t3 = new T3();
        for (int i = 1; i <= 10; i++) {
            System.out.println("hi" + i);
            if (i == 5){
                t3.start();
                t3.join();
            }
        }
    }
}
class T3 extends Thread{
    private int count = 0 ;
    @Override
    public void run() {
       while (true){
           System.out.println("hello " + (++count));
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