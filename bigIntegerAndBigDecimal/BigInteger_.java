package com.hspedu.chapter13.bigIntegerAndBigDecimal;

import java.math.BigInteger;

/**
 * @author HLxxx
 * @version 1.0
 */
public class BigInteger_ {
    public static void main(String[] args) {
        long l = 237888888999l;
        System.out.println("l = " + l);
        //当编程中需要处理很大的整数，long不够用，可以使用BigInteger的类
        BigInteger bigInteger = new java.math.BigInteger("237888888999999999");
        BigInteger bigInteger1 = new BigInteger("199");
        System.out.println(bigInteger);
        //对BigInteger进行加减乘除是需使用对应方法
        BigInteger add = bigInteger.add(bigInteger1);
        System.out.println(add);
        BigInteger subtract = bigInteger.subtract(bigInteger1);
        System.out.println(subtract);
        BigInteger multiply = bigInteger.multiply(bigInteger1);
        System.out.println(multiply);
        BigInteger divide = bigInteger.divide(bigInteger1);
        System.out.println(divide);
    }
}
