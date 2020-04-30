package com.li.demo.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.li.demo.dao.UserDao;
import com.li.demo.entity.User;
import com.li.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
@SessionAttributes({"loginUser"})
public class UserController {

    @Resource
    UserService userService;

    @PostMapping
    public String login(User user, ModelMap modelMap) {
        User login = userService.login(user);
        if(login==null) {//login fail
            modelMap.addAttribute("loginMsg","There had a error maybe in Username or Password");
            return "login";
        }else{//login success
            modelMap.put("loginUser",login);
            return "redirect:/emps";
        }
    }
    @RequestMapping("/logout")
    public String quit(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/index.html";
    }
    @ResponseBody
    @RequestMapping("/info")
    public User info(HttpServletRequest request){
        return (User) request.getSession().getAttribute("loginUser");
    }
}
