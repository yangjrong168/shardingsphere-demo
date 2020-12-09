package com.example.shardingspheredemo.dao;

import com.example.shardingspheredemo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderDao extends JpaRepository<Order,Long> {

    @Modifying
    @Query("update Order sc set sc.state = 4 where sc.id = :id and sc.userId = :userId")
    public void updateByUserIdAndId(@Param(value = "userId") Long userId,@Param(value = "id") Long id);
}
