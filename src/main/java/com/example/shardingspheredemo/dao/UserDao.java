package com.example.shardingspheredemo.dao;

import com.example.shardingspheredemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
