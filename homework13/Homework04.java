package com.hspedu.chapter13.homework13;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Homework04 {
    public static void main(String[] args) {
        String str = "abcHsp U 1234";
        countStr(str);

    }
    public static void countStr(String str){
        if (str == null){
            System.out.println("输入不能为null");
            return;
        }
        int strLen = str.length();
        int numCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        int otherCount = 0;
        for (int i = 0; i < strLen; i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9' ){
                numCount ++;
            }else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' ){
                lowerCount++;
            }else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' ){
                upperCount++;
            }else {
                otherCount++;
            }
        }
        System.out.println("数字有" + numCount + "个，小写字母有" + lowerCount + "个，大写字母有" +
                upperCount + "个，其他有" + otherCount + "个");
    }
}
