package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
@Mapper
public interface DeptMapper {
    //全ての部門データを検索します
    @Select("select * from tlias.dept")
    List<Dept> list();

    //IDに基づいて部門を削除します
    @Delete("delete from tlias.dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into tlias.dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Select("select * from tlias.dept where id = #{id}")
    Dept searchById(Integer id);

    @Update("update tlias.dept set name = #{name} , update_time = #{updateTime} where id = #{id}")
    void updateById(Dept dept);
}
