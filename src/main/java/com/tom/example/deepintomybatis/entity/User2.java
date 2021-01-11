package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.javassist.SerialVersionUID;

import java.io.Serializable;

/**
 * @descriptions: User2
 * @author: Tom
 * @date: 2021/1/10 上午 09:18
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 開啟二級緩存
@CacheNamespace
public class User2 implements Serializable {
    private static final long SerialVersionUID = 1L;
    private Integer user_id;
    private String user_name;
    private String user_sex;
    private Integer user_age;

    public User2(String name, String sex, Integer age) {
        this.user_name = name;
        this.user_sex = sex;
        this.user_age = age;
    }
}









