package com.hspedu.chapter13.string.stringBuilder;

/**
 * @author HLxxx
 * @version 1.0
 */
public class StringVsStringBufferVsStringBuilder {
    public static void main(String[] args) {
        String text = "";
        long startTime = 0L;
        long endTime = 0L;
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        startTime = System .currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
            endTime = System.currentTimeMillis();
        System.out.println("stringBuffer的执行时间： " + (endTime - startTime));


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("stringBuilder的执行时间： " + (endTime - startTime));


        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
          text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("string的执行时间： " + (endTime - startTime));
        }
}
