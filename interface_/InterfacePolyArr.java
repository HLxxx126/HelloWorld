package com.hspedu.chapter10.interface_;

public class InterfacePolyArr {
    public static void main(String[] args) {
        //多态数组->接口类型数组
        Usb[] usb = new Usb[2];
        usb[0] = new Phone_();
        usb[1] = new Camera_();
        for (int i = 0; i < usb.length; i++) {
            usb[i].work();//动态绑定。。
            //需要进行类型的向下转型
            if (usb[i] instanceof Phone_){
                ((Phone_) usb[i]).call();
            }
        }
    }
}
interface Usb{
    void work();
}
class Phone_ implements Usb{
    public void call(){
        System.out.println("手机可以打电话。。。");
    }

    @Override
    public void work() {
        System.out.println("手机工作中");
    }
}
class Camera_ implements Usb{

    @Override
    public void work() {
        System.out.println("相机工作中");
    }
}