package com.hspedu.chapter20.TankGame06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

/**
 * @author HLxxx
 * @version 1.0
 * 坦克大战绘图区
 */
//为了监听键盘事件，需要实现接口KeyListener
//为了让Panel不停地重绘子弹，需要将MyPanel实现Runnable，当作一个线程使用
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克,放入Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个存放Node对象的Vector，用于恢复敌人坦克的坐标，方向
    Vector<Node> nodes = new Vector<>();
    //定义一个Vector，用于存放炸弹
    //当子弹击中坦克时，加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;
    //定义3张炸弹图片，用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(String key) {
        //先判断记录文件是否存在
        //如果存在就正常执行，如果文件不存在，提示只能开新游戏，key制成1
        File file = new File(Recorder.getRecordFile());
        if (file.exists()) {
            nodes = Recorder.getNodesAndEnemyTankRec();
        }else {
            System.out.println("文件不存在，只能开启新游戏");
            key = "1";
        }
        //将MyPanel对象的enemyTanks设置给 Record的enemyTanks
        Recorder.setEnemyTanks(enemyTanks);
        hero = new Hero(500, 100);//初始化自己坦克
        hero.setSpeed(6);
        switch (key){
            case "1":
                //初始化敌人的坦克
                for (int i = 0; i < enemyTankSize; i++) {
                    //创建一个敌人坦克
                    EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
                    //将enemyTanks设置给enemyTank
                    enemyTank.setEnemyTanks(enemyTanks);
                    //设置方向
                    enemyTank.setDirect(2);
                    //启动敌人坦克线程
                    new Thread(enemyTank).start();
                    //给该enemyTank加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                    //加入enemyTank的Vector成员
                    enemyTank.shots.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                }
                break;
            case "2"://继续上局游戏
                //初始化敌人的坦克
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    //创建一个敌人坦克
                    EnemyTank enemyTank = new EnemyTank(node.getX() , node.getY());
                    //将enemyTanks设置给enemyTank
                    enemyTank.setEnemyTanks(enemyTanks);
                    //设置方向
                    enemyTank.setDirect(node.getDirect());
                    //启动敌人坦克线程
                    new Thread(enemyTank).start();
                    //给该enemyTank加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                    //加入enemyTank的Vector成员
                    enemyTank.shots.add(shot);
                    //启动shot对象
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                }
                break;
            default:
                System.out.println("你的输入有误");
        }

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/3.png"));
        //这里，播放指定的音乐
        new com.hspedu.tankgame6.AePlayWave("src/com/hspedu/chapter20/TankGame06/111.wav").start();
    }

//编写方法，显示我方击毁敌方坦克的信息
    public void showInfo(Graphics g){
        //画出玩家总成绩
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("累计击毁敌方坦克数量：",1020,30);
        drawTank(1020,60,g,0,0);//画出一个敌方坦克
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getAllEnemyTankNum() + "",1080,100);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        showInfo(g);
        if (hero != null && hero.isLive) {
            //画出o我的坦克-封装到方法
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);//我的坦克
        }
//        drawTank(hero.getX() +80 ,hero.getY(),g,1,1);//我的坦克，向右
//        drawTank(hero.getX() +160 ,hero.getY(),g,2,1);//我的坦克，向下
//        drawTank(hero.getX() +240 ,hero.getY(),g,3,1);//我的坦克，向左

        //画出hero坦克射击的子弹
//        if (hero.shot != null && hero.shot.isLive != false){
//            g.draw3DRect(hero.shot.x,hero.shot.y,2,2,false);
//        }
        //将hero的子弹集合 shots遍历取出绘制
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive ) {
                g.draw3DRect(shot.x, shot.y, 2, 2, false);
            }else {//如果该shot对象已无效，从集合中移除
                hero.shots.remove(shot);
            }
        }
        //如果bombs集合中有对象，就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            }//让炸弹的生命值减小
            bomb.lifeDown();
            //如果bomb life为0，就从bombs集合中删除
            if (bomb.life == 0)
                bombs.remove(bomb);
        }
        //画出敌人的坦克，遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断当前坦克是否存活
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);

                //画出enemyTank 所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        //从Vector移除
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
    }

    //编写方法画出坦克
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同类型的坦克设置颜色
        switch (type) {
            case 0: //敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //我们的坦克
                g.setColor(Color.orange);
                break;
        }
        //根据坦克方向绘制对应的坦克
        //direct表示方向（0向上，1向右，2向下，3向左）
        switch (direct) {
            case 0://向上
                g.fill3DRect(x, y, 10, 60, false);//坦克左轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克身子
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右轮
                g.fillOval(x + 10, y + 20, 20, 20);//盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//炮
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);//坦克左轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克身子
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右轮
                g.fillOval(x + 20, y + 10, 20, 20);//盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//炮
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, false);//坦克左轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克身子
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右轮
                g.fillOval(x + 10, y + 20, 20, 20);//盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//炮
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, false);//坦克左轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克身子
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右轮
                g.fillOval(x + 20, y + 10, 20, 20);//盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//炮
                break;

            default:
                System.out.println("暂时没有处理");
        }
    }

    //编写方法，判断我方子弹是否击中敌人坦克
    //如果我们的坦克可以发射多个子弹
    //在判断我方子弹是否击中敌人坦克时，就需要把我们的子弹集合中所有的子弹都取出和敌人的所有坦克，进行判断
    public void hitEnemyTank(){
        //遍历我们的子弹
        for (int j = 0; j <hero.shots.size() ; j++) {
            Shot shot = hero.shots.get(j);
            //判断是否击中了敌人坦克
            if (shot != null && shot.isLive) {//当我的子弹还存活
                //遍历敌人所有的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(shot, enemyTank);
                }
            }
        }
    }
    //编写方法，判断敌人坦克是否击中我的坦克
    public void hitHero(){
        //遍历所有的敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);//取出敌人坦克
            //遍历enemyTank 对象的所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //取出子弹
                Shot shot = enemyTank.shots.get(j);
                //判断shot是否击中我方坦克
                if (hero.isLive && shot.isLive){
                    hitTank(shot,hero);
                }
            }
        }
    }

    //编写方法判断我方子弹是否击中敌人坦克
    public void hitTank(Shot s, Tank tank) {
        //判断s击中坦克
        switch (tank.getDirect()) {
            case 0:
            case 2:
                if (s.x > tank.getX() && s.x < tank.getX() + 40 &&
                        s.y > tank.getY() && s.y < tank.getY() + 60) {
                    s.isLive = false;
                    tank.isLive = false;
                    //当我放子弹击中敌人坦克后，将enemyTank从Vector中删除
                    enemyTanks.remove(tank);
                    //当击中坦克时allEnemyTankNum++
                    if (tank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建Bomb对象，加入到bombs
                    Bomb bomb = new Bomb(tank.getX(),tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if (s.x > tank.getX() && s.x < tank.getX() + 60 &&
                        s.y > tank.getY() && s.y < tank.getY() + 40) {
                    s.isLive = false;
                    tank.isLive = false;
                    enemyTanks.remove(tank);
                    //当击中坦克时allEnemyTankNum++
                    if (tank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wdsa键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {//按下W键
            //改变坦克方向
            hero.setDirect(0);
            //坦克移动
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }
        //如果按下J，就射击
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //判断hero的子弹是否销毁 发射一颗子弹
           // if (hero.shot == null || !hero.shot.isLive) {
                // System.out.println("用户按下了J，开始射击 ");
              //  hero.shotEnemyTank();
           // }
            //发射多颗子弹
            hero.shotEnemyTank();
        }
        //面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔100毫秒，重绘一次
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断我们坦克是否击中敌人
            hitEnemyTank();
            //判断敌人坦克是否击中我们
            hitHero();
            this.repaint();
        }
    }
}
