package com.tom.example.deepintomybatis.controller;

import com.tom.example.deepintomybatis.entity.User;
import com.tom.example.deepintomybatis.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * UserController
 *
 * @author Tom on 2021/1/8
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @RequestMapping(value={"/getUser"})
    @ResponseBody
    public User getUser(HttpServletRequest request){
        return userService.getUserById(Integer.valueOf(request.getParameter("id")));
    }

    @RequestMapping(value={"/insertUser"})
    @ResponseBody
    public String insertUser(HttpServletRequest request){
        int maxId = userService.getMaxId();
//        int nextId = maxId + 1;
//        User user = new User(nextId,"guest", 33,"M");
        User user = new User("guest", 33,"M");
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.getMapper();
        sqlSession.insert("com.tom.example.deepintomybatis.dao.UserDao.save", user);
        sqlSession.commit();
        return "ok";
    }

    @RequestMapping(value={"/saveUser"})
    @ResponseBody
    public String saveUser(HttpServletRequest request){

        User user = new User("jack", 33,"M");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("com.tom.example.deepintomybatis.dao.UserDao.saveUser", user);
        sqlSession.commit();
        return "ok";
    }

    @RequestMapping(value={"/modifyUser"})
    @ResponseBody
    public String modifyUser(HttpServletRequest request){

//        User user = new User("jack", 33,"M");
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.insert("com.tom.example.deepintomybatis.dao.UserDao.saveUser", user);

        User user = sqlSession.selectOne("com.tom.example.deepintomybatis.dao.UserDao.getUserById",1);
        // 修改User对象的属性值
        user.setUserName("Tom");;
        user.setAge(25);
        // 修改User对象
        sqlSession.update("com.tom.example.deepintomybatis.dao.UserDao.modifyUser", user);

        sqlSession.commit();
        return "ok";
    }

    @RequestMapping(value={"/removeUser"})
    @ResponseBody
    public String removeUser(HttpServletRequest request){

        int maxId = userService.getMaxId();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("com.tom.example.deepintomybatis.dao.UserDao.removeUser", maxId);
        sqlSession.commit();
        return "ok";
    }


    @RequestMapping(value={"/selectUserMap"})
    @ResponseBody
    public List selectUserMap(HttpServletRequest request){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 查询TB_USER表所有数据返回List集合,集合中的每个元素都是一个Map
        List<Map<String,Object>> list
                = sqlSession.selectList("com.tom.example.deepintomybatis.dao.UserDao.selectUserMap");
        // 遍历List集合，打印每一个Map对象
        list.forEach(row -> System.out.println(row));
        // 提交事务
        sqlSession.commit();
        return list;
    }

}
