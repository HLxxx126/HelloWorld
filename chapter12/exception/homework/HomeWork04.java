package com.hspedu.chapter12.exception.homework;

/**
 * @author HLxxx
 * @version 1.0
 */
public class HomeWork04 {
    public static void main(String[] args) {
        try {
            showExce();
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("B");
        } finally {
            System.out.println("C");
        }
        System.out.println("D");
    }
    public static void showExce() throws Exception{
        throw new Exception();
    }
}
