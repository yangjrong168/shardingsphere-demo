package com.example.shardingspheredemo.dao;

import com.example.shardingspheredemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Long> {
}
