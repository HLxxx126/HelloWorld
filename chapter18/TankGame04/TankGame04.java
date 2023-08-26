package com.hspedu.chapter18.TankGame04;

import javax.swing.*;

/**
 * @author HLxxx
 * @version 1.0
 */
public class TankGame04 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame04 tankGame01 = new TankGame04();
    }
    public TankGame04(){
        mp = new MyPanel();
        //将mp放入Thread并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
