package com.ssm.controller;

import com.ssm.pojo.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        User u = userService.login(user.getUsername(), user.getPassword());
        if (u != null) {
            map.put("code", 200);
            map.put("msg", "登录成功");
        } else {
            map.put("code", 500);
            map.put("msg", "账号或密码错误");
        }
        return map;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        boolean b = userService.register(user);
        if (b) {
            map.put("code", 200);
            map.put("msg", "注册成功");
        } else {
            map.put("code", 500);
            map.put("msg", "注册失败");
        }
        return map;
    }
}