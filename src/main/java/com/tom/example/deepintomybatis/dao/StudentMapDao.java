package com.tom.example.deepintomybatis.dao;

/**
 * UserDao
 *
 * @author Tom on 2021/1/8
 */


import com.tom.example.deepintomybatis.entity.StudentMap;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapDao {

    // 根据id查询学生信息
    StudentMap selectStudentById(Integer id);
}
