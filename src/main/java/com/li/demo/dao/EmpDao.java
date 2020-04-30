package com.li.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.demo.entity.Emp;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;


public interface EmpDao extends BaseMapper<Emp> {

}
