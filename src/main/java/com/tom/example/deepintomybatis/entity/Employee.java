package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @descriptions: Employee
 * @author: Tom
 * @date: 2021/1/10 下午 02:55
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    // 主键id
    private Integer id;
    // 登录名
    private String loginname;
    // 密码
    private String password;
    // 真实姓名
    private String name;
    // 性别
    private String sex;
    // 年龄
    private Integer age;
    // 电话
    private String phone;
    // 薪水
    private Double sal;
    // 状态
    private String state;
}
