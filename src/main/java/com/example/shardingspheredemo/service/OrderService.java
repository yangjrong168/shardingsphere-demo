package com.example.shardingspheredemo.service;

import com.example.shardingspheredemo.dao.OrderDao;
import com.example.shardingspheredemo.dao.OrderProductDao;
import com.example.shardingspheredemo.model.Order;
import com.example.shardingspheredemo.model.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderProductDao orderProductDao;
    public void saveOrderAndProduct(Order order, List<OrderProduct> productList){
        orderDao.save(order);
        for (OrderProduct orderProduct : productList) {
            orderProduct.setOrderId(order.getId());
            orderProductDao.save(orderProduct);
        }
    }

}
