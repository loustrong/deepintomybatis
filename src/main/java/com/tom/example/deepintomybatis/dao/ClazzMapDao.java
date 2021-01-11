package com.tom.example.deepintomybatis.dao;

/**
 * UserDao
 *
 * @author Tom on 2021/1/8
 */


import com.tom.example.deepintomybatis.entity.ClazzMap;
import org.springframework.stereotype.Repository;

@Repository
public interface ClazzMapDao {
    // 根据id查询班级信息
    ClazzMap selectClazzById(Integer id);

}
