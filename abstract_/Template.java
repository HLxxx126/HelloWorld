package com.hspedu.chapter10.abstract_;

abstract public class Template {//抽象类，模板
    public abstract void job();
    public void calculateTime(){
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("执行时间" + (end-start));
    }
}
