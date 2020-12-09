package com.example.shardingspheredemo;

import com.example.shardingspheredemo.dao.OrderDao;
import com.example.shardingspheredemo.dao.OrderProductDao;
import com.example.shardingspheredemo.model.Order;
import com.example.shardingspheredemo.model.OrderProduct;
import com.example.shardingspheredemo.model.Product;
import com.example.shardingspheredemo.model.User;
import com.example.shardingspheredemo.service.OrderService;
import com.example.shardingspheredemo.service.ProductService;
import com.example.shardingspheredemo.service.UserService;
import com.example.shardingspheredemo.util.SnowflakeIdWorker;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

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
    @Resource
    ProductService productService;

    @Resource
    OrderProductDao orderProductDao;

    @Resource
    OrderDao orderDao;

    @Test
    void contextLoads() {
    }
    @Test
    void TestInsertUser(){
     User user = new User();
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

        user.setId(idWorker.nextId());
     user.setCreateTime(new Date());
     user.setMobile("13567887676");
     user.setNickName("yjr");
     userService.save(user);

    }
    @Test
    void TestInsertProduct(){
        Product product = new Product();
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

        product.setId(idWorker.nextId());
        product.setCreateTime(new Date());
        product.setPrice(100);
        product.setState(1);
        product.setStock(1000);
        product.setName("方便面");
        productService.save(product);

    }
    @Test
    void TestInsertOrder(){
       Order order = new Order();
       //order.setId(1l);
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        order.setId(idWorker.nextId());
        order.setUpdateTime(new Date());
       order.setCreateTime(new Date());
       order.setUserId(786189612698566656l);
       order.setAmount(1000);
       order.setState(1);

        List<OrderProduct> productList = Lists.newArrayList();
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(idWorker.nextId());
        orderProduct.setAmount(1000);
        orderProduct.setNum(2);
        orderProduct.setUserId(786189612698566656l);
        orderProduct.setPrice(500);
        orderProduct.setProductId(786191584377962496l);
        productList.add(orderProduct);
        orderService.saveOrderAndProduct(order,productList);


    }


    @Test
    void TestUpdateOrder(){
        System.out.println("获取订单==");
        Order order = orderDao.findById(786240292108894208l).get();
        System.out.println("获取订单===============end");
        order.setState(2);
        orderDao.save(order);
        //  查两个库，每个库一个表  ， 修改 修改两个库，每个库一个表
    }

    @Test
    void TestUpdateOrder2(){
        System.out.println("获取订单==");
        Order param = new Order();
        param.setId(786240292108894208l);
        param.setUserId(786189612698566656l);
        Example<Order> orderExample = Example.of(param);
       // Order order = orderDao.findById(786240292108894208l).get();
        List<Order> list = orderDao.findAll(orderExample);
        System.out.println("获取订单===============end");
        for (Order order : list) {
            order.setState(3);
            orderDao.save(order);
        }
     // 只查一条sql 准确定位 库表  ，修改两条语句
    }
    @Test
    void TestUpdateOrder3(){
        System.out.println("获取订单==");
        Order param = new Order();
        param.setId(786240292108894208l);
        param.setUserId(786189612698566656l);
        Example<Order> orderExample = Example.of(param);
        // Order order = orderDao.findById(786240292108894208l).get();
        List<Order> list = orderDao.findAll(orderExample);
        System.out.println("获取订单===============end");
        for (Order order : list) {
            order.setState(4);
            orderDao.updateByUserIdAndId(order.getUserId(),order.getId());
        }
        // 只查一条sql 准确定位 库表  ，只有一条修改语句?
    }
    @Test
    void TestListOrder(){
        List<Order> list = orderService.listByUserId(786189612698566656l);
        for (Order order : list) {
            System.out.println(order);

            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setUserId(786189612698566656l);
            orderProduct.setOrderId(order.getId());
            Example<OrderProduct> example = Example.of(orderProduct);
            List<OrderProduct> orderProductList = orderProductDao.findAll(example);
            for (OrderProduct product : orderProductList) {
                System.out.println("--"+product);
            }
        }
    }



}