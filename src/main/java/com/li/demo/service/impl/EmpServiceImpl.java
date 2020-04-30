package com.li.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.demo.entity.Emp;
import com.li.demo.service.EmpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("empService")
public class EmpServiceImpl implements EmpService {
    @Override
    public List<Emp> selectList(Emp emp) {
        emp.setName(emp.getName() == null ? "" : emp.getName());
        emp.setEmpNo(emp.getEmpNo() == null ? "" : emp.getEmpNo());
        return emp.selectList(
                new QueryWrapper<Emp>().like("name", emp.getName())
                        .like("emp_no", emp.getEmpNo())
        );
    }

    @Override
    public Emp selectById(Integer id) {
        return new Emp().selectById(id);
    }

    @Override
    public boolean insertOrUpdate(Emp emp) {
        if(emp.getEmpNo()==null)emp.setEmpNo("EMP_"+Math.round(Math.random()*100000));
        return emp.insertOrUpdate();
    }

    @Override
    public boolean delete(Integer id) {
        return new Emp().deleteById(id);
    }
}
