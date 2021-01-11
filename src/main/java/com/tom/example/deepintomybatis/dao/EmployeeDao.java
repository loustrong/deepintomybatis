package com.tom.example.deepintomybatis.dao;

/**
 * UserDao
 *
 * @author Tom on 2021/1/8
 */



import com.tom.example.deepintomybatis.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface EmployeeDao {
    List<Employee> selectEmployeeByIdLike(HashMap<String, Object> params);

    List<Employee> selectEmployeeByLoginLike(HashMap<String, Object> params);

    List<Employee> selectEmployeeChoose(HashMap<String, Object> params);

    List<Employee> findEmployeeLike(HashMap<String, Object> params);

    List<Employee> selectEmployeeLike(HashMap<String, Object> params);

    Employee selectEmployeeWithId(Integer id);

    void updateEmployeeIfNecessary(Employee employee);

    List<Employee> selectEmployeeIn(List<Integer> ids);

    List<Employee> selectEmployeeLikeName(Employee employee);
}
