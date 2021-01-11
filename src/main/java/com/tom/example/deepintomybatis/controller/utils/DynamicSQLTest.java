package com.tom.example.deepintomybatis.controller.utils;

import com.tom.example.deepintomybatis.dao.EmployeeDao;
import com.tom.example.deepintomybatis.entity.Employee;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @descriptions: DynamicSQLTest
 * @author: Tom
 * @date: 2021/1/10 下午 03:02
 * @version: 1.0
 */
public class DynamicSQLTest {
    // 测试<select id="selectEmployeeByIdLike" ...>
    public void testSelectEmployeeByIdLike(SqlSession sqlSession){
        // 获得EmployeeMapper接口的代理对象
        EmployeeDao em = sqlSession.getMapper(EmployeeDao.class);
        // 创建一个HashMap存储参数
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 设置id属性
        params.put("id", 1);
        // 调用EmployeeMapper接口的selectEmployeeByIdLike方法
        List<Employee> list = em.selectEmployeeByIdLike(params);
        // 查看返回结果
        list.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeByLoginLike(SqlSession sqlSession){
        EmployeeDao em = sqlSession.getMapper(EmployeeDao.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 设置loginname和password属性
        params.put("loginname", "jack");
        params.put("password", "123456");
        List<Employee> list = em.selectEmployeeByLoginLike(params);
        list.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeChoose(SqlSession sqlSession){
        EmployeeDao em = sqlSession.getMapper(EmployeeDao.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 设置id属性
        params.put("id", 1);
        params.put("loginname", "jack");
        params.put("password", "123456");
        List<Employee> list = em.selectEmployeeChoose(params);
        list.forEach(employee -> System.out.println(employee));
    }

    // 没有使用where元素，如果没有传入state参数，会导致执行失败 的例子
    public void testFindEmployeeLike(SqlSession sqlSession){
        EmployeeDao em = sqlSession.getMapper(EmployeeDao.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id", 1);
        params.put("loginname", "jack");
        params.put("password", "123456");
        List<Employee> list = em.findEmployeeLike(params);
        list.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeLike(SqlSession sqlSession){
        EmployeeDao em = sqlSession.getMapper(EmployeeDao.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 设置state属性和id属性
        params.put("id", 1);
        params.put("loginname", "jack");
        params.put("password", "123456");
        List<Employee> list = em.selectEmployeeLike(params);
        list.forEach(employee -> System.out.println(employee));
    }

    public void testUpdateEmployeeIfNecessary(SqlSession sqlSession){
        EmployeeDao em = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = em.selectEmployeeWithId(4);
        // 设置需要修改的属性
        employee.setLoginname("mary");
        employee.setPassword("123");
        employee.setName("玛丽");
        em.updateEmployeeIfNecessary(employee);
    }

    public void testSelectEmployeeIn(SqlSession sqlSession){
        EmployeeDao em = sqlSession.getMapper(EmployeeDao.class);
        // 创建List集合
        List<Integer> ids = new ArrayList<Integer>();
        // 往List集合中添加两个测试数据
        ids.add(1);
        ids.add(2);
        List<Employee> list = em.selectEmployeeIn(ids);
        list.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeLikeName(SqlSession sqlSession){
        EmployeeDao em = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = new Employee();
        // 设置模糊查询的参数
        employee.setName("o");
        List<Employee> list = em.selectEmployeeLikeName(employee);
        list.forEach(result -> System.out.println(result));
    }

}
