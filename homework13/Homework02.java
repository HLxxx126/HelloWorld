package com.hspedu.chapter13.homework13;

import java.util.Scanner;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入姓名：");
        String name = scanner.next();
        System.out.print("请输入密码：");
        String pwd = scanner.next();
        System.out.print("请输入邮箱：");
        String email = scanner.next();
        try {
            userRegister(name,pwd,email);
            System.out.println("恭喜注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void userRegister(String name, String pwd, String email){
        if (!( name != null && pwd != null && email != null)){
            throw new RuntimeException("参数不能为null");
        }
        int userLength = name.length();
        if (!(userLength >=2 && userLength <=4)){
            throw new RuntimeException("用户名不正确,长度为2-4");
        }
        if (!(pwd.length() == 6 && isDigital(pwd))){
            throw new RuntimeException("密码不正确,长度需为6，且为数字");
        }
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && j > i)){
            throw new RuntimeException("邮箱不正确，邮箱中包含@和.，且@在.前面，");
        }

    }
    public static boolean isDigital(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!(chars[i] > '0' || chars[i] < '9')){
                return false;
            }
        }return true;
    }
}
