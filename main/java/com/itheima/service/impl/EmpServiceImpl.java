package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


/**
 * @author HLxxx
 * @version 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    //传统方式进行分页查询

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//       Long count = empMapper.count();
//        List<Emp> empList = empMapper.page((page-1)*pageSize,pageSize);
//        PageBean pageBean = new PageBean(count, empList);
//        return pageBean;

    //    }
    //使用PageHelper进行分页查询
    @Override
    public PageBean page(Integer page, Integer pageSize,String name, Short gender,
                         LocalDate begin, LocalDate end) {
        PageHelper.startPage(page,pageSize);
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>) empList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
       return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
}
