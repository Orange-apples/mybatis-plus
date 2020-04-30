package com.li.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.demo.entity.Meeting;

import java.util.List;

public interface MeetingService {
    Meeting queryById(Integer id);

    Page<Meeting> selectList(Meeting dept, Integer pages);

    boolean insertOrUpdate(Meeting dept);

    boolean delete(Integer id);
}
