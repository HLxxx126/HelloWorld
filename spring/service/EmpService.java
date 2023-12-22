package com.itheima.service;

import com.itheima.pojo.Emp;

import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public interface EmpService {
    //従業員リストを取得する
    public List<Emp> listEmp();
}
