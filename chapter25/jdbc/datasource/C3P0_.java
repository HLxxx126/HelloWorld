package com.hspedu.chapter25.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author HLxxx
 * @version 1.0
 */
public class C3P0_ {
    //方式1:相关参数在程序中指定 user url password等
    @Test
    public void testC3P0_01() throws Exception {
        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.通过配置文件mysql.properties获取相关连接的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));
        //读取相关属性值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //给数据源comboPooledDataSource设置相关的参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        long start = System.currentTimeMillis();
        //测试连接池的效率 ，连接mysql5000次
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();//这个方法就是从DateSource接口实现的
           // System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0 5000连接mysql耗时 = " +(end-start));
    }
    //第二种方式 使用配置文件模版完成
    @Test
    public void testC3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hello");
       //测试5000次连接时间
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            //System.out.println("连接成功~");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0 5000连接mysql耗时 = " +(end-start));
    }
}
