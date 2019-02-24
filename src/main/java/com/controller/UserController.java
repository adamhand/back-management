package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/hello", produces = {"application/json;charset=UTF-8"})
    public String hello(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }

    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public String list(){
        return "list";
    }


    @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login1", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> login(@RequestParam("username") String username, @RequestParam("password") String password){
        Map<String, Object> map = new HashMap<>();
        System.out.println(username + " " +password);

        map.put("success", true);
        map.put("msg", "hahahahahaha");

        return map;
    }
}
