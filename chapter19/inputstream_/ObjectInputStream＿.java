package com.hspedu.chapter19.inputstream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ObjectInputStream＿ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //指定反序列化的文件
        String filePath = "src/com/hspedu/chapter19/date.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        //读取
        //读取（反序列化）顺序需和存放（序列化）数据一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject();//底层Object-》Dog
        System.out.println("运行类型 = " + dog.getClass());
        System.out.println("dog信息=" + dog);
        //关闭流
        ois.close();
    }


}
