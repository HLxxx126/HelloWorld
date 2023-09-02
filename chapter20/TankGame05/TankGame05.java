package com.hspedu.chapter20.TankGame05;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author HLxxx
 * @version 1.0
 */
public class TankGame05 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) {
        TankGame05 tankGame05 = new TankGame05();
    }
    public TankGame05(){
        System.out.println("请输入选择 1：新游戏 2:继续上局");
        String key = scanner.next();
        mp = new MyPanel(key);
        //将mp放入Thread并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1400,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //在JFrame中，增加关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
