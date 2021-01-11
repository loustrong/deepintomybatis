package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @descriptions: Order
 * @author: Tom
 * @date: 2021/1/10 下午 02:06
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;  // 订单id，主键
    private String code;  // 订单编号
    private Double total; // 订单总金额

    // 订单和用户是多对一的关系，即一个订单只属于一个用户
    private UserMap userMap;

    // 订单和商品是多对多的关系，即一个订单可以包含多种商品
    private List<Article> articles;
    public Order(String code, Double total) {
        super();
        this.code = code;
        this.total = total;
    }

}
