package com.hspedu.chapter13.string.stringBuffer;

import java.util.Scanner;

/**
 * @author HLxxx
 * @version 1.0
 */
public class StringBufferExercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入商品金额：");
      String price = scanner.next();
        StringBuffer sb = new StringBuffer(price);
        for (int i = sb.lastIndexOf(".") - 3 ; i >0 ; i -=3) {
            sb.insert(i,",");
        } System.out.println(sb);
    }
}
