package com.tom.example.deepintomybatis.springMvc.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @descriptions: VariableTest
 * @author: Tom
 * @date: 2021/1/11 上午 10:12
 * @version: 1.0
 */
@Controller
public class VariableController {

    // 测试@PathVariable注解
    // 该方法映射的请求为/VariableTest/pathVariableTest/1
    @GetMapping(value="/VariableTest")
    public String pathVariableTestIndex() {
       return "variableIndex";
    }

    // 测试@PathVariable注解
    // 该方法映射的请求为/VariableTest/pathVariableTest/1
    @GetMapping(value="/pathVariableTest/{userId}")
    public void pathVariableTest(
            @PathVariable Integer userId) {
        System.out.println("通过@PathVariable获得数据： userId=" + userId);
    }

    // 测试@MatrixVariable注解
    // 该方法映射的请求为/VariableTest/matrixVariableTest/1;name=jack;age=23
    @GetMapping(value="/matrixVariableTest/{userId}")
    public void matrixVariableTest(
            @PathVariable Integer userId,
            @MatrixVariable(value="name",pathVar="userId") String name,
            @MatrixVariable(value="age",pathVar="userId") Integer age){
        System.out.println("通过@PathVariable获得数据： userId=" + userId);
        System.out.println("通过@MatrixVariable获得数据： name="  + name + " age="+ age);
    }

    // 测试@MatrixVariable注解的复杂例子
    // 该方法映射的请求为//VariableTest/productTest/computer;brand=apple,acer;low=2000;height=10000
    @GetMapping(value="/productTest/{goods}")
    public void productTest(
            @PathVariable String goods,
            @MatrixVariable(value="brand",pathVar="goods") List<String> brand,
            @MatrixVariable(value="low",pathVar="goods") Integer low,
            @MatrixVariable(value="height",pathVar="goods") Integer height){
        System.out.println("通过@PathVariable获得数据： goods=" + goods);
        System.out.println("通过@MatrixVariable获得数据：brand="  + brand);
        System.out.println("通过@MatrixVariable获得数据： low="  + low + " height="+ height);
    }
}
