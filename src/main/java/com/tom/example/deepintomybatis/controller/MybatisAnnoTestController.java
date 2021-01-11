package com.tom.example.deepintomybatis.controller;

import com.tom.example.deepintomybatis.controller.utils.DynamicSQLAnnoTest;
import com.tom.example.deepintomybatis.entity.*;
import com.tom.example.deepintomybatis.mapper.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @descriptions: AnnocattionController
 * @author: Tom
 * @date: 2021/1/10 下午 04:50
 * @version: 1.0
 */
@Controller
public class MybatisAnnoTestController {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping(value={"/annoInsert"})
    @ResponseBody
    public String annoInsert(HttpServletRequest request){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建UserMapper实例
        UserMapper um = sqlSession.getMapper(UserMapper.class);
        // 创建User对象并设置属性
        User user = new User();
        user.setUserName("test");
        user.setSex("男");
        user.setAge(18);
        // 插入数据
        um.saveUser(user);
        // 查看插入数据生成的主键
        System.out.println("插入数据生成的主键id为：" + user.getId());
        // 提交事务
        int maxId = um.selectMaxId();
        // 删除User对象
        um.removeUser(maxId);
        // 查找所有數據
        List<User> list = um.selectAllUser();
        // 查看查询到的User对象
        list.forEach(u->System.out.println(u));
        maxId = um.selectMaxId();
        User userMax = um.selectUserById(maxId);
        // 查看查询到的User对象
        System.out.println(userMax);

        // 查询id=5的User对象
//        userMax = um.selectUserById(5);
        // 修改查询到的User对象
        userMax.setUserName("update");
        userMax.setSex("女");
        userMax.setAge(19);
        // 修改User对象
        um.modifyUser(userMax);


        sqlSession.commit();
        return "ok";
    }


    @RequestMapping(value={"/oneToOneAnno"})
    @ResponseBody
    public String oneToOne(HttpServletRequest request){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建UserMapper实例
        UserMapper um = sqlSession.getMapper(UserMapper.class);
        // 创建User对象并设置属性
        PersonMapper pm = sqlSession.getMapper(PersonMapper.class);
        // 根据id查询Person对象，同时需要获得关联的Card对象
        Person p = pm.selectPersonById(1);
        // 查看查询到的Person对象
        System.out.println(p);
        // 查看查询到的关联的Card对象
        System.out.println(p.getCard());

        sqlSession.commit();
        return "ok";
    }

    @RequestMapping(value={"/oneToManyAnno"})
    @ResponseBody
    public String oneToManyAnno(HttpServletRequest request){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取ClazzMapper实例
        ClazzMapper cm = sqlSession.getMapper(ClazzMapper.class);
        // 根据id查询Clazz对象
        ClazzMap clazz = cm.selectById(1);
        // 查看查询到的Clazz对象
        System.out.println(clazz.getId() + " "+ clazz.getCode() + " "+clazz.getName());
        // 查看关联的学生集合，因为配置使用的是LAZY懒加载，所以当使用时才执行SQL语句
        clazz.getStudentMaps().forEach(student->System.out.println(student));
        // 提交事务

        sqlSession.commit();
        return "ok";
    }
    @RequestMapping(value={"/manyToManyAnno"})
    @ResponseBody
    public String manyToManyAnno(HttpServletRequest request){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取OrderMapper实例
        OrderMapper om = sqlSession.getMapper(OrderMapper.class);
        // 根据id查询Order对象
        Order order = om.selectById(1);
        // 查看查询到的Order对象
        System.out.println(order.getId() + " " + order.getCode() + " " + order.getTotal());
        // 查看Order关联的User对象
        System.out.println(order.getUserMap());
        // 查看关联的Article集合，因为配置使用的是LAZY懒加载，所以当使用时才执行SQL语句
        order.getArticles().forEach(article -> System.out.println(article));

        // 提交事务
        sqlSession.commit();
        return "ok";
    }

    @RequestMapping(value={"/dynamicSqlAnno"})
    @ResponseBody
    public String dynamicSqlAnno(HttpServletRequest request){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        DynamicSQLAnnoTest t = new DynamicSQLAnnoTest();
        // 获取EmployeeMapper对象
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        // 测试testSelectWhitParam方法
        t.testSelectWhitParam(em);
        // 测试testInsertEmployee方法
        t.testInsertEmployee(em);
        // 测试testUpdateEmployee方法
        t.testUpdateEmployee(em);
        // 测试testDeleteEmployee方法
        t.testDeleteEmployee(em);
        // 提交事务

        // 提交事务
        sqlSession.commit();
        return "ok";
    }

}
