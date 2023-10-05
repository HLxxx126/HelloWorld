package com.hspedu.chapter25.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author HLxxx
 * @version 1.0
 * 该类演示如何使用JDBCUtils工具类，完成dml和select
 */
public class JDBCUtils_Use {
        //测试
    @Test
    public void testSelect(){
        //1.得到连接
        Connection connection = null;
        //2.组织一个sql
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3.创建PreparedStatement对象
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //执行,得到一个结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("NAME");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name +"\t" + sex + "\t" + borndate + "\t" + phone );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtils.close(set,preparedStatement,connection);
        }
    }

    @Test
    public void testDML(){//insert,update,delete
        //1.得到连接
        Connection connection = null;
        //2.组织一个sql
        String sql = "update actor set NAME = ? where id = ?";
        PreparedStatement preparedStatement = null;
        //3.创建PreparedStatement对象
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1,"周星驰");
            preparedStatement.setInt(2,1);
            //执行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
