package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @descriptions: UserMap
 * @author: Tom
 * @date: 2021/1/10 下午 02:04
 * @version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserMap implements Serializable {
    private static final long serialVersionUID = 1L;
    // 用户id，主键
    private Integer id;
    // 用户名
    private String username;
    // 登录名
    private String loginname;
    // 密码
    private String password;
    // 联系电话
    private String phone;
    // 收货地址
    private String address;

    // 用户和订单是一对多的关系，即一个用户可以有多个订单
    private List<Order> orders;

    public UserMap(String username, String loginname, String password,
                String phone, String address) {
        super();
        this.username = username;
        this.loginname = loginname;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}
