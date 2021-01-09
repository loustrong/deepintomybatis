package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 *
 * @author Tom on 2021/1/8
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String userName;
    private int age;
    private String sex;

    public User(String userName, int age, String sex) {
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }
}
