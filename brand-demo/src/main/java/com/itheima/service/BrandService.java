package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * すべてを検索する
     * @return
     */
    public List<Brand> selectAll() {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    public void add(Brand brand){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        //トランザクションをコミットする
        sqlSession.commit();
        sqlSession.close();

    }

    public Brand selectById(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public void update(Brand brand){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        //トランザクションをコミットする
        sqlSession.commit();
        sqlSession.close();

    }
    public void delete(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
