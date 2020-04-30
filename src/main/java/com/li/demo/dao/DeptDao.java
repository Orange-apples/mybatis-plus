package com.li.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.demo.entity.Dept;
import org.apache.ibatis.annotations.CacheNamespace;

public interface DeptDao extends BaseMapper<Dept> {
}
