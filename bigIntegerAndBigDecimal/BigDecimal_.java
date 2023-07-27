package com.hspedu.chapter13.bigIntegerAndBigDecimal;

import java.math.BigDecimal;

/**
 * @author HLxxx
 * @version 1.0
 */
public class BigDecimal_ {
    public static void main(String[] args) {
        double d = 1999.11111111d;
        System.out.println(d);
        //当需要保存一个精度很高的数时，double不够用，可以使用BigDecimal
        BigDecimal bigDecimal = new BigDecimal("1999.1111111111111199999999999998888887");
        BigDecimal bigDecimal1 = new BigDecimal("1.11");
        System.out.println(bigDecimal);
        //对BigDecimal进行加减乘除也需要用相应方法
        BigDecimal add = bigDecimal.add(bigDecimal1);
        System.out.println(add);
        BigDecimal subtract = bigDecimal.subtract(bigDecimal1);
        System.out.println(subtract);
        BigDecimal multiply = bigDecimal.multiply(bigDecimal1);
        System.out.println(multiply);
        //BigDecimal divide = bigDecimal.divide(bigDecimal1);//当结果为无限循环小数时，可能抛出异常ArithmeticException
        //解决方法：在使用divide方法时指定精度
        BigDecimal divide = bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_CEILING);//如果无限循环，保留分子相同精度
        System.out.println(divide);
    }
}
