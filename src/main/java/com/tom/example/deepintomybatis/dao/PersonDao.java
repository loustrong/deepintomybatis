package com.tom.example.deepintomybatis.dao;

/**
 * UserDao
 *
 * @author Tom on 2021/1/8
 */


import com.tom.example.deepintomybatis.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao {
    /**
     * 根据id查询Person
     * 方法名和参数必须和XML文件中的<select.../>元素的id属性和parameterType属性一致
     * @param id
     * @return Person对象
     * */
    Person selectPersonById(Integer id);
}
