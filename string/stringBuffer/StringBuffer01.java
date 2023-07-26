package com.hspedu.chapter13.string.stringBuffer;

/**
 * @author HLxxx
 * @version 1.0
 */
public class StringBuffer01 {
    public static void main(String[] args) {
        //创造一个 大小为16的char【】，用于存放字符内容
        StringBuffer stringBuffer = new StringBuffer();
        //通过构造器指定char【】大小
        StringBuffer stringBuffer1 = new StringBuffer(100);
        //通过 给一个String 创建 StringBuffer,char[]大小就是str.length() + 16
       StringBuffer hello = new StringBuffer("hello");

    }
}
