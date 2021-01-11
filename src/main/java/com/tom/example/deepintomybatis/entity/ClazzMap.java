package com.tom.example.deepintomybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @descriptions: ClazzMap
 * @author: Tom
 * @date: 2021/1/10 上午 10:55
 * @version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClazzMap implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; // 班级id，主键
    private String code; // 班级编号
    private String name; // 班级名称

    // 班级和学生是一对多的关系，即一个班级可以有多个学生
    private List<StudentMap> studentMaps;

}
