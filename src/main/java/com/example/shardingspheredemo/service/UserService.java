package com.example.shardingspheredemo.service;

import com.example.shardingspheredemo.dao.UserDao;
import com.example.shardingspheredemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void save(User user){
        userDao.save(user);
    }
}
