package com.example.shardingspheredemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Data
@Entity(name = "t_order_product")
public class OrderProduct {

    @Id
    private Long id;
    // @Column(name = "user_id")
    private Long orderId;
    private Long productId;
    private Integer amount;

    private Integer num;

    private Integer price;
}
