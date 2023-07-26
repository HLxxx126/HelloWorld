package com.hspedu.chapter13.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public class ArrayMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 90, 123, 567};
        //binarySearch 通过二分搜索法进行查找，要求必须排好序,如果不存在则返回-（low + 1）
        int index = Arrays.binarySearch(arr,1);
        System.out.println(index);

        //copyOf数组元素的复制
        Integer[] newArr = Arrays.copyOf(arr,arr.length);//从arr中拷贝arr.length个元素到newArr数组中
        //如果拷贝长度大于arr.length，就在新数组后面插入null，若拷贝长度小于0，则发生异常
        System.out.println("--拷贝执行完毕后--");
        System.out.println(Arrays.toString(newArr));

        //ill数组填充
        Integer[] num = new Integer[]{9, 3, 2};
        Arrays.fill(num,99);//使用99替换num中所有元素
        System.out.println("---填充后---");
        System.out.println(Arrays.toString(num));

        //equals 比较两个数组元素是否完全一致
        Integer[] arr2 = {1, 2, 90, 123, 567};
        boolean equals = Arrays.equals(arr,arr2);
        System.out.println(equals);

        //asList 将一组数值转换成list
        List  asList = Arrays.asList(2,3,4,5,6,1);//将(2,3,4,5,6,1)数据转成一个list集合返回
        System.out.println("asList = " + asList);
    }
}
