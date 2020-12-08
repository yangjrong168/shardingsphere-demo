package com.example.shardingspheredemo.service;
import com.example.shardingspheredemo.dao.OrderMapper;
import com.example.shardingspheredemo.model.Order;
import com.example.shardingspheredemo.model.OrderExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order findById(Long orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public void createOrder(Order order) {
        orderMapper.insertSelective(order);
    }

    @Override
    public List<Order> listOrder(OrderExample orderExample) {
        return orderMapper.selectByExample(orderExample);
    }


}