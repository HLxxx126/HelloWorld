package com.hspedu.chapter13.string.stringBuffer;

import kotlin.text.StringsKt;

/**
 * @author HLxxx
 * @version 1.0
 */
public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//看源码，底层调用的是AbstractStringBuilder的appendNull
        System.out.println(sb.length());

        System.out.println(sb);
        StringBuffer sb1 = new StringBuffer(str);//空指针异常
        System.out.println(sb1);
    }
}
