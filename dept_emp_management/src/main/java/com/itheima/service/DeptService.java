package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * @author HLxxx
 * @version 1.0
 */
public interface DeptService {
    //全ての部門データを検索します
    List<Dept> list();

    //IDに基づいて部門を削除します
    void delete(Integer id) throws Exception;

    void add(Dept dept);

    Dept search(Integer id);

    void update(Dept dept);
}
