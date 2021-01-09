package com.tom.example.deepintomybatis.dao;

/**
 * UserDao
 *
 * @author Tom on 2021/1/8
 */

import com.tom.example.deepintomybatis.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User getUserById(int id);
    int getMaxId();
}
