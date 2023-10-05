package com.hspedu.chapter25.jdbc.datasource;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author HLxxx
 * @version 1.0
 */
public class JDBCUtilsByDruid_USE {
        @Test
        public void testSelect(){
            System.out.println("测试druid方式");
            //1.得到连接
            Connection connection = null;
            //2.组织一个sql
            String sql = "select * from actor";
            PreparedStatement preparedStatement = null;
            ResultSet set = null;
            //3.创建PreparedStatement对象
            try {
                connection = JDBCUtilsByDruid.getConnection();
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
               JDBCUtilsByDruid.close(set,preparedStatement,connection);
            }
    }
    //使用土方法解决ResultSet　封装 =》Arraylist
    @Test
    public void testSelectToArraylist(){
        System.out.println("测试druid方式");
        //1.得到连接
        Connection connection = null;
        //2.组织一个sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Actor> list = new ArrayList();//创建Arraylist对象存放actor对象
        //3.创建PreparedStatement对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            //执行,得到一个结果集
            set = preparedStatement.executeQuery();
            //遍历该结果集
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("NAME");
                String sex = set.getString("sex");
                String borndate = set.getString("borndate");
                String phone = set.getString("phone");
                //把得到的resultset的记录，封装到Actor对象，放入到list集合
                list.add(new Actor(id,name,sex,borndate,phone));
            }
            System.out.println("list集合数据 = " + list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set,preparedStatement,connection);
        }
    }
}
