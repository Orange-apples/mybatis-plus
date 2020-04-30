package com.li.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.demo.entity.Dept;
import com.li.demo.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/depts")
public class DeptController {
    @Resource
    DeptService deptService;


    @GetMapping
    public String selectList(Dept dept, ModelMap modelMap, Integer pages) {
        pages = pages==null?1:pages;
        Page<Dept> page = deptService.selectList(dept, pages);
        System.out.println(page.getRecords().size());
        modelMap.addAttribute("depts", page.getRecords());
        modelMap.addAttribute("name", dept.getName() == null ? "" : dept.getName());
        modelMap.addAttribute("page", page);
        return "dept/deptList";
    }


    @RequestMapping("/getView")
    public String getView(Integer ids, ModelMap modelMap) {
        if (ids != null) {
            modelMap.addAttribute("dept", deptService.queryById(ids));
        }
        return "dept/deptInsert";
    }

    @PostMapping
    public String insertOrUpdate(Dept dept) {
        deptService.insertOrUpdate(dept);
        return "redirect:/depts";
    }

    @DeleteMapping
    public String delete(Integer[] ids) {
        for (int i = 0; i < ids.length; i++) deptService.delete(ids[i]);
        return "redirect:/depts";
    }
}
