package com.hspedu.chapter16.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author HLxxx
 * @version 1.0
 * 小球通过键盘控制上下左右移动
 */
public class BallMove extends JFrame{//窗口
    MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }
    public BallMove(){
       mp = new MyPanel();
       this.add(mp);
       this.setSize(400,300);
       this.addKeyListener(mp);//窗口可以监听在面板发生的键盘事件
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
    }
}
//面板
//KeyListener是一个监听器，可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    //为了让小球可以移动，把它的左上角坐标设置为变量
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void keyTyped(KeyEvent e) {//有字符输出时该方法就会触发

    }

    @Override
    public void keyPressed(KeyEvent e) {//当某个键按下，该方法触发
        //System.out.println((char) e.getKeyCode() + "被按下");
        //根据用户按下的不同键，来处理小球的移动
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {//KeyEvent.VK_DOWN是向下箭头对应的code值
            y+=5;
        }else if (e.getKeyCode() == KeyEvent.VK_UP){
            y-=5;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x-=5;
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            x+=5;
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {//当某个键松开，该方法触发

    }
}