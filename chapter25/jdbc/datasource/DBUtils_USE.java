package com.hspedu.chapter25.jdbc.datasource;
import com.hspedu.chapter25.jdbc.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public class DBUtils_USE {
       //使用apache-DBUtils工具类+druid 完成对表的crud操作
    @Test
    public void testQueryMany() throws SQLException {//返回结果是多行的情况
        //1.得到连接（druid）
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2.使用DBUtils
        //3.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4.执行相关方法，返回ArrayList结果集
        //把得到的resultset的记录，封装到Actor对象，放入到list集合
        String sql = "select * from actor where id >= ?";
        List<Actor> list =
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合的信息");
        for (Actor actor :list) {
            System.out.println(actor);
        }
        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }
    public void testQuerySingle() throws SQLException {//返回单行记录
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id = ?";
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
        System.out.println(actor);
        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }
    @Test
    public void testScalar() throws SQLException {//单行单列，返回object
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from actor where id = ?";
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 1);
        System.out.println(obj);
        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }
    @Test
    public void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update actor set name = ? where id = ?";
        int affectedRow = queryRunner.update(connection, sql, "张三丰", 1);
        System.out.println(affectedRow > 0 ? "执行成功":"没有影响数据库");
        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }
}
