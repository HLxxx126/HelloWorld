package com.hspedu.chapter18.TankGame04;

/**
 * @author HLxxx
 * @version 1.0
 * 射击子弹
 */
public class Shot implements Runnable{
    //子弹坐标
    int x;
    int y;
    int direct = 0;//子弹方向
    int speed = 2;//子弹速度
    boolean isLive = true;//子弹是否存活

    public Shot(int x, int y, int direct) {//构造器
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {//射击行为
        while (true){
            //子弹休眠
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //根据方向来改变x，y
            switch (direct){
                case 0://向上
                    y-= speed;
                    break;
                case 1://向右
                    x += speed;
                    break;
                case 2://向下
                    y += speed;
                    break;
                case 3://向左
                    x-= speed;
                    break;
            }
            //测试，输出子弹坐标
            System.out.println("子弹 x = "+ x + "子弹 y = " + y);
            //当子弹移动到面板边界时，就应该销毁
            //当子弹碰到敌人坦克时，也应销毁
            if( !(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)){
                System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }
}
