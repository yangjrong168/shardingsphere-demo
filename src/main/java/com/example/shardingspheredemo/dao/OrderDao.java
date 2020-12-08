package com.example.shardingspheredemo.dao;

import com.example.shardingspheredemo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Long> {
}
