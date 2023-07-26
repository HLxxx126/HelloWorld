package com.hspedu.chapter13.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ArrayMethod01 {
    public static void main(String[] args) {
        Integer[] integers = {1, 20, 90};
        //遍历数组
//        for (int i = 0; i < integers.length; i++) {
//            System.out.println(integers[i]);
//        }
        //直接使用Arrays.toString方法显示数组
        System.out.println(Arrays.toString(integers));
        //演示sort方法的使用
        Integer arr[] = {1, -1, 7, 0, 89};
        //进行排序//默认排序
        Arrays.sort(arr);//数组是引用类型，sort排序后会直接影响 实参 arr
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
        //sort是重载的也可以通过传入接口Comparator实现定制排序
        Arrays.sort(arr, new Comparator() {//传入待排序数组和实现了Comparator接口的匿名内部类
            @Override
            public int compare(Object o1, Object o2) {
               Integer i1 = (Integer)o1;
               Integer i2 = (Integer)o2;
                return i2 - i1;
            }
        });
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }
}
