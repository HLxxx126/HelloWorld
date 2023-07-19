package com.hspedu.chapter11.homework;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork07 {
    public static void main(String[] args) {
        Car_ car = new Car_(30);
        car.getAir().flow();
        Car_ car1 = new Car_(-3);
        car1.getAir().flow();
        Car_ car2 = new Car_(60);
        car2.getAir().flow();
    }
}
class Car_{
    private double temperature;

    public Car_(double temperature) {
        this.temperature = temperature;
    }

    class Air{
        public void flow(){
            if (temperature < 0){
                System.out.println("温度小于0，空调吹暖气");
            }else if (temperature > 40){
                System.out.println("温度大于40，空调吹冷气");
            }else {
                System.out.println("温度正常，空调关闭");
            }
        }
    }
    public Air getAir(){
        return new Air();
    }
}
