package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public interface BrandMapper {
    /**
     * すべてを検索する
     * @return
     */
    @Select("select * from jsp_test.tb_brand")
    List<Brand> selectAll();


    @Insert("insert into jsp_test.tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    @Select("select * from jsp_test.tb_brand where id = #{id}")
    Brand selectById(int id);

    @Update("update jsp_test.tb_brand set brand_name = #{brandName},company_name = #{companyName}," +
            "ordered = #{ordered},description = #{description},STATUS = #{status} where id = #{id}")
    void update(Brand brand);

    @Delete("delete from jsp_test.tb_brand where id= #{id}")
    void delete(int id);
}
