package com.itheima.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// 这是MyBatis的工具类,简化MyBatis代码
public class SqlSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory;
    // 我们只需要一个SqlSessionFactory,在静态代码块中创建SqlSessionFactory
    static {
        try {
            // 编写代码让MyBatis跑起来,执行SQL语句
            String resource = "mybatis-config.xml";
            // 加载核心配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 得到SqlSession工厂,赋值给成员变量
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 返回SqlSessionFactory
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    // 返回SqlSession
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    public static SqlSession openSession(boolean autoCommit) {
        return sqlSessionFactory.openSession(autoCommit);
    }
}
