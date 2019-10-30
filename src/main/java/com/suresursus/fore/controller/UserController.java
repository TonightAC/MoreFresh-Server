package com.suresursus.fore.controller;

import com.suresursus.fore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService = null;

    @ResponseBody
    @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8", method = {RequestMethod.POST,RequestMethod.GET})
    public String login(@RequestParam("uname") String uname, @RequestParam("pwd") String pwd){
        return userService.login(uname, pwd);
    }
}
