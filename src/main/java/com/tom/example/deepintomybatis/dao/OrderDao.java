package com.tom.example.deepintomybatis.dao;

/**
 * UserDao
 *
 * @author Tom on 2021/1/8
 */


import com.tom.example.deepintomybatis.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    Order selectOrderById(int id);
    Order selectOrderByUserId(int id);
}
