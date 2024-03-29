package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author HLxxx
 * @version 1.0
 */
public interface UserMapper {

    @Select("select * from jsp_test.tb_user where username = #{username} and password=#{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("select * from jsp_test.tb_user where username = #{username}")
    User selectByUsername(String username);

    @Insert("insert into jsp_test.tb_user values (null,#{username},#{password})")
    void add(User user);


}
