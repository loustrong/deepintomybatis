package com.tom.example.deepintomybatis.springMvc.general.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.javassist.SerialVersionUID;

import java.io.Serializable;

/**
 * @descriptions: domain user
 * @author: Tom
 * @date: 2021/1/11 上午 09:10
 * @version: 1.0
 */
// 域对象，实现序列化接口
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    // 私有字段
    private String loginname;
    private String password;
    private String username;

}
