package com.li.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.demo.entity.Dept;

import java.util.List;

public interface DeptService {
    Dept queryById(Integer id);

    List<Dept> selectAll();

    Page<Dept> selectList(Dept dept, Integer pages);

    boolean insertOrUpdate(Dept dept);

    boolean delete(Integer id);
}
