package com.hspedu.chapter25.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author HLxxx
 * @version 1.0
 * 这是一个工具类，完成mysql的连接和关闭资源
 */
public class JDBCUtils {
    //定义相关属性（4个），因为只需要一份，因此做成static
    private static String user;
    private static String password;
    private static String url;
    private static String driver;
   //在static代码块中初始化
    static {
       try {
           Properties properties = new Properties();
           properties.load(new FileInputStream("src/mysql.properties"));
           //读取相关属性值
           user = properties.getProperty("user");
           password = properties.getProperty("password");
           url = properties.getProperty("url");
           driver = properties.getProperty("driver");
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
   //连接数据库返回Connection
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //关闭相关资源
    public static void close(ResultSet set, Statement statement, Connection connection){
        //判断是否为null
        try {
            if (set != null){
                set.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
