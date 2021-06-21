package com.wang.service;

import com.wang.entity.User;

public interface UserService {
    User checkUser(String username, String password);
}
