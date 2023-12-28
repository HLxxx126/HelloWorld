package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;


/**
 * @author HLxxx
 * @version 1.0
 */
@Mapper
public interface EmpMapper {
    //传统方法执行分页查询
   // @Select("select count(*) from tlias.emp")
  //  public Long count();

    //@Select("select * from tlias.emp limit #{start},#{pageSize}")
    //public List<Emp> page(Integer start, Integer pageSize);

    //使用PageHelper插件进行分页查询
   // @Select("select * from tlias.emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);



   void delete(List<Integer> ids);

   @Insert("insert into tlias.emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
           "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime}," +
           "#{updateTime})")
    void insert(Emp emp);

   @Select("select * from tlias.emp where id = #{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    @Select("select * from tlias.emp where username=#{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    @Delete("delete from tlias.emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
