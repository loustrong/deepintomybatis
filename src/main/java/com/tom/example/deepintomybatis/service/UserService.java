package com.tom.example.deepintomybatis.service;

import com.tom.example.deepintomybatis.dao.UserDao;
import com.tom.example.deepintomybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)  //直接配置在接口上
    public void removeUser() throws Exception {
      int maxId = this.getMaxId();
      userDao.removeUser(maxId);
      if(maxId < 100 ){
        throw new Exception("too small");
      }
//      Thread.sleep(30000);
      User user = new User("Transaction",24,"M");
      userDao.saveUser(user);
    }

}
