package com.itheima.dao;

import com.itheima.pojo.Emp;

import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public interface EmpDao {
    //従業員リストデータを取得する
    public List<Emp> listEmp();

}
