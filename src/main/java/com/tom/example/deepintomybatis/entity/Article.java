package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @descriptions: Article
 * @author: Tom
 * @date: 2021/1/10 下午 02:07
 * @version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {
    private static final long serialVersionUID = 1L;
    // 商品id，主键
    private Integer id;
    // 商品名称
    private String name;
    private Double price;	// 商品价格
    private String remark;	// 商品描述

    // 商品和订单是多对多的关系，即一种商品可以包含在多个订单中
    private List<Order> orders;

    public Article(String name, Double price, String remark) {
        super();
        this.name = name;
        this.price = price;
        this.remark = remark;
    }

}
