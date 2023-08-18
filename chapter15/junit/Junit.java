package com.hspedu.chapter15.junit;

import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.Test;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Junit {
    public static void main(String[] args) {

    }

    @Test
    public void m1() {
        System.out.println("m1被调用");
    }
    @Test
public void m2(){
    System.out.println("m2被调用");
}
}
