package com.hspedu.chapter16.TankGame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author HLxxx
 * @version 1.0
 * 坦克大战绘图区
 */
//为了监听键盘事件，需要实现接口KeyListener
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克,放入Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    public MyPanel(){
        hero = new Hero(100,100);//初始化自己坦克
        hero.setSpeed(6);
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
       g.fillRect(0,0,1000,750);
       //画出o我的坦克-封装到方法
        drawTank(hero.getX() ,hero.getY(),g,hero.getDirect(),1);//我的坦克
//        drawTank(hero.getX() +80 ,hero.getY(),g,1,1);//我的坦克，向右
//        drawTank(hero.getX() +160 ,hero.getY(),g,2,1);//我的坦克，向下
//        drawTank(hero.getX() +240 ,hero.getY(),g,3,1);//我的坦克，向左
        //画出敌人的坦克，遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),0);
        }
    }
    //编写方法画出坦克
    public void drawTank(int x, int y,Graphics g, int direct, int type){
       //根据不同类型的坦克设置颜色
        switch (type){
            case 0: //敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //我们的坦克
                g.setColor(Color.orange);
                break;
        }
        //根据坦克方向绘制对应的坦克
        //direct表示方向（0向上，1向右，2向下，3向左）
        switch (direct){
            case 0://向上
                g.fill3DRect(x,y,10,60,false);//坦克左轮
                g.fill3DRect(x+10,y+10,20,40,false);//坦克身子
                g.fill3DRect(x+30,y,10,60,false);//坦克右轮
                g.fillOval(x+10,y+20,20,20);//盖子
                g.drawLine(x+20,y+30,x+20,y);//炮
                break;
            case 1://向右
                g.fill3DRect(x,y,60,10,false);//坦克左轮
                g.fill3DRect(x+10,y+10,40,20,false);//坦克身子
                g.fill3DRect(x,y+30,60,10,false);//坦克右轮
                g.fillOval(x+20,y+10,20,20);//盖子
                g.drawLine(x+30,y+20,x+60,y+20);//炮
                break;
            case 2://向下
                g.fill3DRect(x,y,10,60,false);//坦克左轮
                g.fill3DRect(x+10,y+10,20,40,false);//坦克身子
                g.fill3DRect(x+30,y,10,60,false);//坦克右轮
                g.fillOval(x+10,y+20,20,20);//盖子
                g.drawLine(x+20,y+30,x+20,y+60);//炮
                break;
            case 3://向左
                g.fill3DRect(x,y,60,10,false);//坦克左轮
                g.fill3DRect(x+10,y+10,40,20,false);//坦克身子
                g.fill3DRect(x,y+30,60,10,false);//坦克右轮
                g.fillOval(x+20,y+10,20,20);//盖子
                g.drawLine(x+30,y+20,x,y+20);//炮
                break;

            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
//处理wdsa键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_W){//按下W键
            //改变坦克方向
            hero.setDirect(0);
            //坦克移动
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        }
        //面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
