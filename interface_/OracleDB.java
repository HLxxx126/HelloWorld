package com.hspedu.chapter10.interface_;

public class OracleDB  implements DBInterface{
    @Override
    public void connect() {
        System.out.println("连接Oracle");
    }

    @Override
    public void close() {
        System.out.println("关闭Oracle");
    }
}
