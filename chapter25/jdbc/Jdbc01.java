package com.hspedu.chapter25.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author HLxxx
 * @version 1.0
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();
        //2.得到连接
        String url = "jdbc:mysql://localhost:3306/hlxxx";
        //将用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user","root");//用户
        properties.setProperty("password","7942Ud38");//密码
        Connection connect = driver.connect(url, properties);

        //3.执行sql
        String sql = "insert into actor values(null,'刘德华','男','1970-11-11','110')";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");
        //4.关闭连接
        statement.close();
        connect.close();
    }
}
