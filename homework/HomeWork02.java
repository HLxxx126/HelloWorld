package com.hspedu.chapter11.homework;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork02 {
}
class Frock{
    private static int currentNum = 100000;
    public static int getNextNum(){
        currentNum += 100;
        return currentNum;
    }
    private int serialNumber;

    public int getSerialNumber() {
        return serialNumber;
    }

    public Frock(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Frock() {
        serialNumber = getNextNum();
    }
}
class TestFrock{
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock frock = new Frock();
        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        System.out.println(frock.getSerialNumber());
        System.out.println(frock1.getSerialNumber());
        System.out.println(frock2.getSerialNumber());
    }
}