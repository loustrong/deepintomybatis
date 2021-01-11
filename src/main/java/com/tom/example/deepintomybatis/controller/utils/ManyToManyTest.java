package com.tom.example.deepintomybatis.controller.utils;

import com.tom.example.deepintomybatis.dao.OrderDao;
import com.tom.example.deepintomybatis.dao.UserMapDao;
import com.tom.example.deepintomybatis.entity.Article;
import com.tom.example.deepintomybatis.entity.Order;
import com.tom.example.deepintomybatis.entity.UserMap;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @descriptions: ManyToManyTest
 * @author: Tom
 * @date: 2021/1/10 下午 02:26
 * @version: 1.0
 */
public class ManyToManyTest {
    // 测试一对多，查询班级User（一）的时候级联查询订单Order（多）
    public void testSelectUserById(SqlSession sqlSession){
        // 获得UserMapper接口的代理对象
        UserMapDao um = sqlSession.getMapper(UserMapDao.class);
        // 调用selectUserById方法
        UserMap user = um.selectUserById(1);
        // 查看查询到的user对象信息
        System.out.println(user.getId() + " " + user.getUsername());
        // 查看user对象关联的订单信息
        List<Order> orders = user.getOrders();
        orders.forEach(order -> System.out.println(order));
    }

    // 测试多对多，查询订单Order（多）的时候级联查询订单的商品Article（多）
    public void testSelectOrderById(SqlSession sqlSession){
        // 获得OrderMapper接口的代理对象
        OrderDao om = sqlSession.getMapper(OrderDao.class);
        // 调用selectOrderById方法
        Order order = om.selectOrderById(2);
        // 查看查询到的order对象信息
        System.out.println(order.getId() + " " + order.getCode() + " " + order.getTotal());
        // 查看order对象关联的用户信息
        UserMap userMap = order.getUserMap();
        System.out.println(userMap);
        // 查看order对象关联的商品信息
        List<Article> articles = order.getArticles();
        articles.forEach(article -> System.out.println(article));
    }
}
