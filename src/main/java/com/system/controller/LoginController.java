package com.system.controller;

import com.system.entity.TUser;
import com.system.service.user.UserService;
import com.system.utils.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/biz")
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public R login(@RequestParam String name, @RequestParam String password){
        R r=userService.login(name,password);
        return r;
    }

    @GetMapping("/error")
    public String error(){
        return "404";
    }

}
