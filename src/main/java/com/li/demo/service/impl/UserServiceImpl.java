package com.li.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.li.demo.entity.User;
import com.li.demo.service.UserService;
import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public User login(User user) {
        return user.selectOne(new QueryWrapper<User>().eq("name",user.getName()).eq("password",user.getPassword()));
    }
}
