package com.tom.example.deepintomybatis.controller.utils;

import com.tom.example.deepintomybatis.dao.User2Dao;
import com.tom.example.deepintomybatis.entity.User2;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @descriptions: ProcedureTest
 * @author: Tom
 * @date: 2021/1/10 下午 03:32
 * @version: 1.0
 */
public class ProcedureTest {
    // 测试插入数据
    public void testSaveUser(SqlSession sqlSession){
        // 获得UserMapper接口的代理对象
        User2Dao um = sqlSession.getMapper(User2Dao.class);
        User2 user = new User2("test","男",23);
//		User2 user = new User("jack","男",20);
//		User2 user = new User("rose","女",18);
//		User2 user = new User("tom","男",21);
//		User2 user = new User("mary","女",19);
//		User2 user = new User("alice","女",18);
//		User2 user = new User("scott","男",25);
        // 调用保存User的方法
        um.saveUser(user);
        System.out.println("插入成功，返回的id = " + user.getUser_id());
    }

    // 测试查询所有数据
    public void testSelectUser(SqlSession sqlSession){
        // 获得UserMapper接口的代理对象
        User2Dao um = sqlSession.getMapper(User2Dao.class);
        // 调用查询所有User数据的方法
        List<User2> users = um.selectUser();
        // 遍历打印每一个User对象
        users.forEach(user -> System.out.println(user));
    }

    // 测试根据id查询对应的数据
    public void testSelectUserById(SqlSession sqlSession){
        // 获得UserMapper接口的代理对象
        User2Dao um = sqlSession.getMapper(User2Dao.class);
        // 调用根据id查询User数据的方法
        User2 user = um.selectUserById(1);
        System.out.println(user);
    }

    // 测试修改数据
    public void testModifyUser(SqlSession sqlSession){
        // 获得UserMapper接口的代理对象
        User2Dao um = sqlSession.getMapper(User2Dao.class);
        // 查询出id为1的User对象
        User2 user = um.selectUserById(1);
        // 修改对象的属性
        user.setUser_name("fkit");
        user.setUser_sex("男");
        user.setUser_age(19);
        // 调用修改数据的方法
        um.modifyUser(user);
    }

    // 测试删除数据
    public void testRemoveUser(SqlSession sqlSession){
        // 获得UserMapper接口的代理对象
        User2Dao um = sqlSession.getMapper(User2Dao.class);
        // 查询出id为1的User对象
        User2 user = um.selectUserById(1);
        // 调用删除数据的方法
        um.removeUser(user);
    }

}
