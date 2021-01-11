package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * User
 *
 * @author Tom on 2021/1/8
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
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
