package com.peter.bj.controller;


import com.peter.bj.pojo.User;
import com.peter.bj.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping(value ="/tologin")
    @ResponseBody
    public String tologin(){
        return "login";
    }


    @RequestMapping(value = "/login")
    @ResponseBody
    public String login (String userName,String passwd){
        System.out.println(userName);
        System.out.println(passwd);
        return "登陆成功";
    }


}