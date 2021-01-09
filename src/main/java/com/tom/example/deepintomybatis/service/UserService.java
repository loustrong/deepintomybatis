package com.tom.example.deepintomybatis.service;

import com.tom.example.deepintomybatis.dao.UserDao;
import com.tom.example.deepintomybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author Tom on 2021/1/8
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User getUserById(int id){
        return userDao.getUserById(id);
    }
    public int getMaxId(){
        return userDao.getMaxId();
    }

}
