package com.example.shardingspheredemo.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "t_user")
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
   // @GeneratedValue(generator = "idGenerator")
   // @GenericGenerator(name = "idGenerator", strategy = "com.example.shardingspheredemo.service.GenerateId")
    private Long id;

    private String nickName;

    private String mobile;

    private Date createTime;

    private Date updateTime;

}
