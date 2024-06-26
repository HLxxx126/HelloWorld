package com.hspedu.chapter13.wrapper;

/**
 * @author HLxxx
 * @version 1.0
 */
public class WrapperExercise03 {
    public static void main(String[] args) {
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);

        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);

       Integer i5 = 127;
       Integer i6 = 127;
       System.out.println(i5 == i6);

        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);

        Integer i9 = 127;
        Integer i10 = new Integer(127);
        System.out.println(i9 == i10);

        Integer i11 = 127;//只要有基本数据类型，== 判断的就为值是否相等
        int i12 = 127;
        System.out.println(i11 == i12);

        Integer i13 = 128;
        int i14 = 128;
        System.out.println(i13 == i14);
        }
    }

