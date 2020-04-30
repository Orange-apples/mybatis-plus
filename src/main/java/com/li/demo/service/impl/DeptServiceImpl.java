package com.li.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.demo.component.ApplicationUtil;
import com.li.demo.entity.Dept;
import com.li.demo.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Override
    public Dept queryById(Integer id) {
        return new Dept().selectById(id);
    }

    @Override
    public List<Dept> selectAll() {
        return new Dept().selectAll();
    }

    @Override
    public Page<Dept> selectList(Dept dept, Integer pages) {
        dept.setName(dept.getName() == null ? "" : dept.getName());
        return new Dept().selectPage(new Page<Dept>(pages, ApplicationUtil.PAGESIZE), new QueryWrapper<Dept>().like("name", dept.getName()));

    }

    @Override
    public boolean insertOrUpdate(Dept dept) {
        dept.setDNo(dept.getDNo()==null?"DEPT_"+Math.round(Math.random()*100000):dept.getDNo());
        return dept.insertOrUpdate();
    }

    @Override
    public boolean delete(Integer id) {
        return new Dept().deleteById(id);
    }
}
