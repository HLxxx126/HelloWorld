package com.hspedu.chapter25.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Druid_ {
    @Test
    public void testDruid() throws Exception {
        //创建properties对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));
        //创建一个指定参数的数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = dataSource.getConnection();
            //System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("druid 5000连接mysql耗时 = " +(end-start));
    }
}
