package com.tom.example.deepintomybatis.dao;

/**
 * UserDao
 *
 * @author Tom on 2021/1/8
 */

import com.tom.example.deepintomybatis.entity.User2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User2Dao {
    User2 selectUser2();

    /**
     * 插入数据
     * @param user 包含要查询的User信息
     */
    void saveUser(User2 user);


    /**
     * 查询所有数据
     * @return List<User> 包含所有User数据的List集合
     */
    List<User2> selectUser();

    /**
     * 根据id查询对应的数据
     * @param id 用户的id
     * @return User 包含用户信息的User对象
     */
    User2 selectUserById(Integer id);

    /**
     * 修改数据
     * @param user 包含要修改的User信息
     */
    void modifyUser(User2 user);

    /**
     * 删除数据
     * @param user 包含要修改的User信息
     */
    void removeUser(User2 user);
}
