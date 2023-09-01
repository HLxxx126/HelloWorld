package com.hspedu.chapter19.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author HLxxx
 * @version 1.0
 * 使用 Properties类读取mysql.properties文件
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/mysql.properties"));
        properties.list(System.out);
        //根据key获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名 = " + user);
        System.out.println("密码 = " + pwd);
    }
}
