package com.hspedu.chapter10.abstract_;

public class AA extends Template {
    public void job(){

        long num = 0;
        for (long i = 0; i < 1000000; i++) {
            num += 1;
        }

    }
}
