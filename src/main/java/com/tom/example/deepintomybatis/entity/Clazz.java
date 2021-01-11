package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @descriptions: Clazz
 * @author: Tom
 * @date: 2021/1/10 上午 09:55
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz implements Serializable {
    private Integer id;
    private String code;
    private List<Student> students;
}
