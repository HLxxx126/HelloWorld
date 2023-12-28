package com.itheima.mapper;

import com.itheima.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author HLxxx
 * @version 1.0
 */
@Mapper
public interface DeptLogMapper {
    @Insert("insert into tlias.dept_log(id, create_time, description) values (#{id},#{createTime},#{description})")
    void insert(DeptLog deptLog);
}
