package com.example.shardingspheredemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name="t_order")
public class Order {
    @Id
    private Long id;
   // @Column(name = "user_id")
    private Long userId;

    private Integer amount;

    private Integer state;

    private Date createTime;

    private Date updateTime;
}
