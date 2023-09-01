package com.hspedu.chapter19;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Test_ {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader = new BufferedReader_(new FileReader_());
        bufferedReader.readFiles(10);
        //多次读取字符串
        BufferedReader_ bufferedReader1 = new BufferedReader_(new StringReader_());
        bufferedReader1.readStrings(10);
    }
}
