package com.example.shardingspheredemo.service;

import com.example.shardingspheredemo.dao.OrderDao;
import com.example.shardingspheredemo.dao.OrderProductDao;
import com.example.shardingspheredemo.dao.ProductDao;
import com.example.shardingspheredemo.model.Order;
import com.example.shardingspheredemo.model.OrderProduct;
import com.example.shardingspheredemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    ProductDao productDao;
    public void save(Product product){
        productDao.save(product);
    }
}
