package com.hspedu.chapter13.math;

/**
 * @author HLxxx
 * @version 1.0
 */
public class MathMethod {
    public static void main(String[] args) {
        //Math常用方法（静态方法）
        //1.abs 绝对值
        int abs = Math.abs(-9);//9
        System.out.println(abs);
        //2.pow 求幂
        double pow = Math.pow(2,4);//2的4次方 16
        System.out.println(pow);
        //3.ceil 向上取整(double)
        double ceil = Math.ceil(-3.00001);//-3
        System.out.println(ceil);
        //4.floor 向下取整(double)
        double floor = Math.floor(-4.999);//-5
        System.out.println(floor);
        //5.round 四舍五入
        long round = Math.round(-5.001);//-5
        //6.sqrt 开放
        double sqrt = Math.sqrt(9.0);
        System.out.println(sqrt);
        //7.random 随机数  返回的是【0-1）之间的随机小数
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random());
        }
        //使用random返回一个大于等于2小于等于7的数
        int a = (int)(2 + Math.random()*6);
        System.out.println(a);
        //8.max 9.min 返回最大值和最小值
        int min =Math.min(1,9);
        int max = Math.max(45, 90);
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }
}
