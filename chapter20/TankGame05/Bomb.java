package com.hspedu.chapter20.TankGame05;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Bomb {
    int x,y;
    int life = 9;//z炸弹的生命周期
    boolean isLive = true;//是否还存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //减少生命值
    public void lifeDown(){
        if(life > 0){
            life--;
        } else {
            isLive = false;
        }
    }
}
