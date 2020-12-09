package com.example.shardingspheredemo.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@DynamicUpdate
@DynamicInsert
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
