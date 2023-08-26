package com.hspedu.chapter18.TankGame04;

import java.util.Vector;

/**
 * @author HLxxx
 * @version 1.0
 * 敌人的坦克
 */
public class EnemyTank extends Tank implements Runnable {
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            //判断，如果shots size ==0,创建一颗子弹并启用它
            if (isLive && shots.size() == 0) {
                Shot s = null;
                //判断坦克方向，创建相应子弹
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }
            //根据坦克的方向来继续移动
            switch (getDirect()) {
                case 0:
                    //让坦克保持一个方向，走30步
                    for (int i = 0; i < 30; i++) {
                        if (getY() >= 0) {
                            moveUp();
                        }
                        //休眠100毫秒
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 <= 1000) {
                            moveRight();
                        }
                        //休眠100毫秒
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 <= 750) {
                            moveDown();
                        }
                        //休眠100毫秒
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() >= 0) {
                            moveLeft();
                        }
                        //休眠100毫秒
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            //随机改变坦克方向
            setDirect((int) (Math.random() * 4));
            //被击中后退出线程
            if ((!isLive)) {
                break;
            }
        }
    }
}
