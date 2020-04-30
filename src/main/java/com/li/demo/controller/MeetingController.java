package com.li.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.demo.entity.Emp;
import com.li.demo.entity.Meeting;
import com.li.demo.service.EmpService;
import com.li.demo.service.MeetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/meetings")
public class MeetingController {
    @Resource
    MeetingService meetingService;
    @GetMapping
    public String meetingList(Meeting meeting, Integer pages, ModelMap modelMap){
        pages = pages==null?1:pages;
        Page<Meeting> page = meetingService.selectList(meeting, pages);
        modelMap.addAttribute("meetings",page.getRecords());
        modelMap.addAttribute("page",page);
        return "meeting/meetingList";
    }
    @Resource
    EmpService empService;
    @RequestMapping("/getView")
    public String getView(Integer ids,ModelMap modelMap){
        modelMap.addAttribute("emps",empService.selectList(new Emp()));
        if(ids!=null)modelMap.addAttribute("meeting",meetingService.queryById(ids));
        return "meeting/meetingInsert";
    }
    @PostMapping
    public String insertOrUpdate(Meeting meeting){
        meetingService.insertOrUpdate(meeting);
        return "redirect:meetings";
    }
    @DeleteMapping
    public String delete(Integer[] ids){
        for(Integer id:ids) {
            meetingService.delete(id);
        }
        return  "redirect:meetings";
    }
}
