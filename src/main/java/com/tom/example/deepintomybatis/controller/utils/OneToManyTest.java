package com.tom.example.deepintomybatis.controller.utils;

import com.tom.example.deepintomybatis.dao.ClazzMapDao;
import com.tom.example.deepintomybatis.dao.StudentMapDao;
import com.tom.example.deepintomybatis.entity.ClazzMap;
import com.tom.example.deepintomybatis.entity.StudentMap;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @descriptions: OneToManyTest
 * @author: Tom
 * @date: 2021/1/10 上午 11:39
 * @version: 1.0
 */
public class OneToManyTest {
    // 测试一对多，查询班级Clazz（一）的时候级联查询学生Student（多）
    public void testSelectClazzById(SqlSession sqlSession){
        // 获得ClazzMapper接口的代理对象
        ClazzMapDao cm = sqlSession.getMapper(ClazzMapDao.class);
        // 调用selectClazzById方法
        ClazzMap clazz = cm.selectClazzById(1);
        // 查看查询到的clazz对象信息
        System.out.println(clazz.getId() + " "+ clazz.getCode() + " "+clazz.getName());
        // 查看clazz对象关联的学生信息
        List<StudentMap> students = clazz.getStudentMaps();
        students.forEach(stu -> System.out.println(stu));
    }

    // 测试多对一，查询学生Student（多）的时候级联查询 班级Clazz（一）
    public void testSelectStudentById(SqlSession sqlSession){
        // 获得StudentMapper接口的代理对象
        StudentMapDao sm = sqlSession.getMapper(StudentMapDao.class);
        // 调用selectStudentById方法
        StudentMap stu = sm.selectStudentById(1);
        // 查看查询到的Student对象信息
        System.out.println(stu);
        // 查看Student对象关联的班级信息
        System.out.println(stu.getClazzMap());
    }
}
