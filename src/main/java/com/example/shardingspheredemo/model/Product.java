package com.example.shardingspheredemo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "t_product")
public class Product {
    @Id
    private Long id;

    private String name;

    private Integer price;

    private Integer stock;

    private Integer state;

    private Date createTime;

    private Date updateTime;
}
