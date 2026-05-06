package com.ssm.service;

import com.ssm.pojo.User;

public interface UserService {
    User login(String username, String password);
    boolean register(User user);
}