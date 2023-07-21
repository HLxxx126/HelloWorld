package com.hspedu.chapter12.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Throws01 {
    public static void main(String[] args) {

    }
    public void f1() throws FileNotFoundException,NullPointerException {//也可以直接写父类Exception，也可以是列表，即抛出多个异常
        //创建了一个文件流对象//这里的异常是FileNotFoundException异常，是一个编译异常，必须要处理
        //可以使用try-catch或throws,抛出异常，让调用f1方法的调用者（方法）处理

        FileInputStream fis = new FileInputStream("d://aa.txt");
    }
}
