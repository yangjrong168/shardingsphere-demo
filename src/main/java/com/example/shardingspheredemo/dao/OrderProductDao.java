package com.example.shardingspheredemo.dao;

import com.example.shardingspheredemo.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductDao extends JpaRepository<OrderProduct,Long> {
}
