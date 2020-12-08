package com.example.shardingspheredemo.service;

import com.example.shardingspheredemo.model.Order;
import com.example.shardingspheredemo.model.OrderExample;

import java.util.List;

public interface IOrderService {

    Order findById(Long orderId);

    void createOrder(Order order);

    List<Order> listOrder(OrderExample orderExample);

}