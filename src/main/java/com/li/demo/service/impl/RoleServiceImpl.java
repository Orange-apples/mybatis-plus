package com.li.demo.service.impl;

import com.li.demo.entity.Role;
import com.li.demo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Override
    public Role queryById(Integer id) {
        return new Role().selectById(id);
    }

    @Override
    public List<Role> selectAll() {
        return new Role().selectAll();
    }
}
