package com.hspedu.chapter17;

/**
 * @author HLxxx
 * @version 1.0
 */
public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑可用CPU个数
        int cpuNums = runtime.availableProcessors();
        System.out.println(cpuNums);
    }
}
