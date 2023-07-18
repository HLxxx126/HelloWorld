package com.hspedu.chapter11.Enumeration;

/**
 * @author HLxxx
 * @version 1.0
 */
public class EnumDetail {
    public static void main(String[] args) {
        Music.CLASSICMUSIC.playing();
    }
}
class A{

}
//1.使用enum关键字后就不能再继承其他类了，因为enum会隐式继承，而java是单继承机制
//enum Season3 extends A{
//
//}
//2.enum实现的枚举类，仍然是一个类，所以还是能实现接口的
interface IPlaying{
    public void playing();
}
enum Music implements IPlaying{
    CLASSICMUSIC;
    @Override
    public void playing() {
        System.out.println("播放好听的音乐");
    }
}