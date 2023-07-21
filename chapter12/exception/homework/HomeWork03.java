package com.hspedu.chapter12.exception.homework;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork03 {
    public static void main(String[] args) {
        try {
            func();
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("C");
        }
        System.out.println("D");
    }
    public static void func(){
        try {
            throw new RuntimeException();
        } finally {
            System.out.println("B");
        }
    }
}
