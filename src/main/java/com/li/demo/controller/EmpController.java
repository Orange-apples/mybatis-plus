package com.li.demo.controller;

import com.li.demo.entity.Dept;
import com.li.demo.entity.Emp;
import com.li.demo.entity.Role;
import com.li.demo.service.DeptService;
import com.li.demo.service.EmpService;
import com.li.demo.service.RoleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/emps")
public class EmpController {

    @Resource
    EmpService empService;

    @GetMapping
    public String selectList(Emp emp, ModelMap modelMap) {
        List<Emp> emps = empService.selectList(emp);
        modelMap.addAttribute("empList", emps);
        return "/emp/empList";
    }

    @Resource
    DeptService deptService;

    @Resource
    RoleService roleService;

    @RequestMapping("/getView")
    public String getView(Integer ids, ModelMap modelMap) {
        modelMap.addAttribute("depts", deptService.selectAll());
        modelMap.addAttribute("roles", roleService.selectAll());
        if (ids != null) {
            modelMap.addAttribute("emp",empService.selectById(ids));
        }
        return "emp/empInsert";
    }

    @PostMapping
    public String insertOrUpdate(Emp emp){
        empService.insertOrUpdate(emp);
        return "redirect:/emps";
    }
    @DeleteMapping
    public String delete(Integer[] ids){
        for(int i =  0;i < ids.length;i++)empService.delete(ids[i]);
        return "redirect:/emps";
    }

}
