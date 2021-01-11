package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @descriptions: Student
 * @author: Tom
 * @date: 2021/1/10 上午 09:56
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    // 关联的Clazz对象
    private Clazz clazz;
}
