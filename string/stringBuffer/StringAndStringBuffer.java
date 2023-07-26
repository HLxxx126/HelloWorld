package com.hspedu.chapter13.string.stringBuffer;

/**
 * @author HLxxx
 * @version 1.0
 */
public class StringAndStringBuffer {
    public static void main(String[] args) {
        //String->StringBuffer
        String str = "hello tom";
        //方式1，使用构造器，返回的才是stringBuffer对象，对str本身没有影响
        StringBuffer stringBuffer = new StringBuffer(str);
        //方式2 使用append方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        //StringBuffer->String
        StringBuffer stringBuffer3 = new StringBuffer("韩顺平教育");
        //方式1 使用StringBuffer提供的toString方法
        String string = stringBuffer3.toString();
        //方式2 使用构造器
        String s = new String(stringBuffer3);
    }
}
