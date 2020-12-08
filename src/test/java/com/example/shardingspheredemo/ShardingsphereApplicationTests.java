package com.example.shardingspheredemo;

import com.example.shardingspheredemo.model.Order;
import com.example.shardingspheredemo.model.OrderProduct;
import com.example.shardingspheredemo.model.User;
import com.example.shardingspheredemo.service.OrderService;
import com.example.shardingspheredemo.service.UserService;
import com.example.shardingspheredemo.util.SnowflakeIdWorker;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ShardingsphereApplicationTests {

    //@Resource
    //IOrderService orderService;
    @Resource
    UserService userService;
    @Resource
    OrderService orderService;

    @Test
    void contextLoads() {
    }
    @Test
    void TestInsertUser(){
     User user = new User();
     user.setId(1l);
     user.setCreateTime(new Date());
     user.setMobile("13567887676");
     user.setNickName("yjr");
     userService.save(user);

    }
    @Test
    void TestInsertOrder(){
       Order order = new Order();
       //order.setId(1l);
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        order.setId(idWorker.nextId());
        order.setUpdateTime(new Date());
       order.setCreateTime(new Date());
       order.setAmount(1000);
       order.setState(1);

        List<OrderProduct> productList = Lists.newArrayList();
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(idWorker.nextId());
        orderProduct.setAmount(1000);
        orderProduct.setNum(2);
        orderProduct.setPrice(500);
        orderProduct.setProductId(2l);
        productList.add(orderProduct);
        orderService.saveOrderAndProduct(order,productList);


    }


    @Test
    void TestListOrder(){
       /* OrderExample orderExample = new OrderExample();
        List<Order> orderList= orderService.listOrder(orderExample);
        for (Order o:orderList){
            System.out.println(o.toString());
        }*/
    }
    @Test
    void TestListOrder2(){
       /* OrderExample orderExample = new OrderExample();
        OrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andMemberIdEqualTo(101L);
        List<Order> orderList= orderService.listOrder(orderExample);
        for (Order o:orderList){
            System.out.println(o.toString());
        }*/
    }



}