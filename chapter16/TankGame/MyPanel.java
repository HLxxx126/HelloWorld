package com.hspedu.chapter16.TankGame;

import javax.swing.*;
import java.awt.*;

/**
 * @author HLxxx
 * @version 1.0
 * 坦克大战绘图区
 */
public class MyPanel extends JPanel {
    //定义我的坦克
    Hero hero = null;
    public MyPanel(){
        hero = new Hero(100,100);//初始化自己坦克
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
       g.fillRect(0,0,1000,750);
       //画出坦克-封装到方法
        drawTank(hero.getX(),hero.getY(),g,0,0);//我的坦克
        drawTank(hero.getX() + 60,hero.getY(),g,0,1);//别人的坦克
    }
    //编写方法画出坦克
    public void drawTank(int x, int y,Graphics g, int direct, int type){
       //根据不同类型的坦克设置颜色
        switch (type){
            case 0: //我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的坦克
                g.setColor(Color.orange);
                break;
        }
        //根据坦克方向绘制坦克
        switch (direct){
            case 0://向上
                g.fill3DRect(x,y,10,60,false);//坦克左轮
                g.fill3DRect(x+10,y+10,20,40,false);//坦克身子
                g.fill3DRect(x+30,y,10,60,false);//坦克右轮
                g.fillOval(x+10,y+20,20,20);//盖子
                g.drawLine(x+20,y+30,x+20,y);//炮
            default:
                System.out.println("暂时没有处理");
        }
    }
}
