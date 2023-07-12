package com.hspedu.chapter10.abstract_;

public class BB extends Template{

    public void job() {

        long num = 0;
        for (long i = 0; i < 80000; i++) {
            num *= i;
        }

    }
}
