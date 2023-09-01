package com.hspedu.chapter19.outputstream_;

import java.io.*;

/**
 * @author HLxxx
 * @version 1.0
 * 使用ObjectOutputStream，完成数据的序列化
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        //序列化后，保存的文件格式不是纯文本，而是按照他的格式保存的
        String filePath = "src/com/hspedu/chapter19/date.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        //序列化程序到src/com/hspedu/chapter19/date.txt
        oos.writeInt(100);//int->Integer(实现了Serializable接口）
        oos.writeBoolean(true);//boolean->Boolean(实现了Serializable接口）
        oos.writeChar('a');//char->Character(实现了Serializable接口）
        oos.writeDouble(9.5);//double->Double(实现了Serializable接口）
        oos.writeUTF("韩顺平");//String(实现了Serializable接口）
        //保存一个Dog对象
        oos.writeObject(new Dog("旺财",10));
        oos.close();
        System.out.println("数据保存完毕（序列化形式）");
    }
}
//如果需要序列化某个类的对象，需实现Serializable接口
class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}