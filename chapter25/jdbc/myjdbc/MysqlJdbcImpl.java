package com.hspedu.chapter25.jdbc.myjdbc;

/**
 * @author HLxxx
 * @version 1.0
 * 模拟Mysql数据库实现jdbc接口
 */
public class MysqlJdbcImpl implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("得到Mysql的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成Mysql的增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭Mysql的连接");
    }
}
