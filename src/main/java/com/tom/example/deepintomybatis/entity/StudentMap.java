package com.tom.example.deepintomybatis.entity;

import com.tom.example.deepintomybatis.entity.ClazzMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @descriptions: StudentMap
 * @author: Tom
 * @date: 2021/1/10 上午 11:09
 * @version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentMap implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; // 学生id，主键
    private String name; // 姓名
    private String sex;  // 性别
    private Integer age; // 年龄

    // 学生和班级是多对一的关系，即一个学生只属于一个班级
    private ClazzMap clazzMap;

}
