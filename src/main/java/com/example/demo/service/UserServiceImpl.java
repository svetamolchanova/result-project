package com.example.demo.service;

import com.example.demo.dto.*;
import org.springframework.stereotype.*;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getUserName(){
        return "John";
    }

    @Override
    public User getName() {
        User user = new User();
        user.setName("John");
        user.setAge(20);
        return user;
    }
}
