package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @descriptions: Card
 * @author: Tom
 * @date: 2021/1/10 上午 10:25
 * @version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;  // 主键id
    private String code; // 身份证编号
}
