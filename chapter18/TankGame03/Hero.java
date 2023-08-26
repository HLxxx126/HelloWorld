package com.hspedu.chapter18.TankGame03;

/**
 * @author HLxxx
 * @version 1.0
 * 自己的坦克
 */
public class Hero extends Tank {
    //定义一个Shot对象
    Shot shot = null;

    public Hero(int x, int y) {
        super(x, y);
    }
    //射击
    public void shotEnemyTank(){
        //创建Shot对象，根据当前Hero对象的位置和方向来创建Shot
        switch (getDirect()){//得到hero对象的方向
            case 0://向上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX()+60,getY()+20,1);
                break;
            case 2:
                shot = new Shot(getX()+20,getY()+60,2);
                break;
            case 3:
                shot = new Shot(getX(),getY()+20,3);
                break;
        }
        //启动射击线程
        new Thread(shot).start();
    }
}

