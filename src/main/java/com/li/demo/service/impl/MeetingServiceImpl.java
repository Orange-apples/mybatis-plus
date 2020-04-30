package com.li.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.demo.component.ApplicationUtil;
import com.li.demo.dao.MeetingDao;
import com.li.demo.entity.Meeting;
import com.li.demo.service.MeetingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("meetingService")
public class MeetingServiceImpl implements MeetingService {

    @Resource
    MeetingDao meetingDao;

    @Override
    public Meeting queryById(Integer id) {
        return meetingDao.selectById(id);
    }


    @Override
    public Page<Meeting> selectList(Meeting meeting, Integer pages) {
        meeting.setTitle(meeting.getTitle() == null ? "" : meeting.getTitle());
        return meetingDao.selectPage(new Page<Meeting>(pages, ApplicationUtil.PAGESIZE),
                new QueryWrapper<Meeting>()
                        .like("title", meeting.getTitle()));
    }

    @Override
    public boolean insertOrUpdate(Meeting meeting) {
        if(meeting.getId()==null){
            return meetingDao.insert(meeting) > 0;
        }else{
            return meetingDao.updateById(meeting) > 0;
        }
    }

    @Override
    public boolean delete(Integer id) {
        return meetingDao.deleteById(id) > 0;
    }
}
