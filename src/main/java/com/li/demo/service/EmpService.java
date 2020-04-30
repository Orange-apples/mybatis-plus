package com.li.demo.service;

import com.li.demo.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> selectList(Emp emp);

    Emp selectById(Integer ids);

    boolean insertOrUpdate(Emp emp);

    boolean delete(Integer id);
}
