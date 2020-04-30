package com.li.demo.service;

import com.li.demo.entity.Role;

import java.util.List;

public interface RoleService {
    Role queryById(Integer id);

    List<Role> selectAll();
}
