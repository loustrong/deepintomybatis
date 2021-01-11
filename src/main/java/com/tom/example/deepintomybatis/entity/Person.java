package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @descriptions: Person
 * @author: Tom
 * @date: 2021/1/10 上午 10:28
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    // 主键id
    private Integer id;
    // 姓名
    private String name;
    // 性别
    private String sex;
    // 年龄
    private Integer age;

    // 人和身份证是一对一的关系，即一个人只有一个身份证
    private Card card;
}
