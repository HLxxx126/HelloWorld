package com.hspedu.chapter11.homework;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork08 {
    public static void main(String[] args) {
        Color yellow = Color.YELLOW;
        yellow.show();
        switch (yellow){
            case YELLOW:
                System.out.println("匹配到黄色");
                break;
            case BLACK:
                System.out.println("匹配到黑色");
                break;
            case RED:
                System.out.println("匹配到红色");
                break;
            case BLUE:
                System.out.println("匹配到蓝色");
                break;
            default:
                System.out.println("没有匹配到");
        }
    }
}
enum Color implements IMyInterface{
    RED(255,0,0),
    BLUE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("redValue = " + redValue +" greenValue = " + greenValue + " blueValue = " + blueValue);
    }
}
interface IMyInterface{
    public void show();
}