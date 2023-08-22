package com.hspedu.chapter16.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author HLxxx
 * @version 1.0
 */
public class DrawCircle extends JFrame {//JFrame对应窗口，可以理解为是一个画框
    //定义一个面板
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();
    }
    public DrawCircle(){//构造器
        //初始化面板
        mp = new MyPanel();
        //把面板放入窗口
        this.add(mp);
        //设置窗口大小
        this.setSize(500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击窗口小叉时，程序退出运行
        this.setVisible(true);//可以显示
    }
}
//定义一个MyPanel（面板），继承JPanel类，画图形就在面板上画
class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {//绘图方法//Graphics g 把g理解成是一支画笔，它提供了很多绘图方法
        super.paint(g);//调用父类的方法完成初始化
        System.out.println("paint 方法被调用");
        //画出一个圆形
        g.drawOval(10,10,100,100);
        //其他绘制方法
        //画直线
        g.drawLine(10,10,100,100);
        //画矩形边框
        g.drawRect(10,10,100,100);
        //画填充矩形
        //先设置画笔颜色
        g.setColor(Color.PINK);
        g.fillRect(120,10,100,100);
        //画填充圆形
        g.setColor(Color.orange);
        g.fillOval(230,10,100,100);
        //画图片
        //1.加载图片资源
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/demo2.jpg"));//图片需放在项目根目录下
        g.drawImage(image,10,130,192,118,this);
        //画字符串，即写字
        //设置颜色和字体
        g.setColor(Color.yellow);
        g.setFont(new Font("行书",Font.ITALIC,50));
        g.drawString("北京你好",220,200);//坐标为字符串左下角
    }
}