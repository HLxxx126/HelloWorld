package com.hspedu.chapter25.jdbc.batch_;

import com.hspedu.chapter25.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author HLxxx
 * @version 1.0
 * java的批处理
 */
public class Batch_ {
    //传统方法添加5000条数据到admin2表
    @Test
    public void noBatch() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,"jack" + i);
            preparedStatement.setString(2,"666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();//结束时间
        System.out.println("传统方式 耗时 = " + (end - start));
        //关闭连接
        JDBCUtils.close(null,preparedStatement,connection);
    }
    //使用批量方式添加数据
    @Test
    public void batch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,"jack" + i);
            preparedStatement.setString(2,"666");
            //将sql语句加入到批处理包
            preparedStatement.addBatch();
            //当有1000条记录时再批量执行
            if ((i + 1) % 1000 == 0){//满1000条sql语句
                preparedStatement.executeBatch();
                //清空一下
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();//结束时间
        System.out.println("批量方式 耗时 = " + (end - start));
        //关闭连接
        JDBCUtils.close(null,preparedStatement,connection);
    }
}
