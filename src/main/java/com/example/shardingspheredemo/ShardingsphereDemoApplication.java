package com.example.shardingspheredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.shardingspheredemo.dao")
public class ShardingsphereDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingsphereDemoApplication.class, args);
	}

}
