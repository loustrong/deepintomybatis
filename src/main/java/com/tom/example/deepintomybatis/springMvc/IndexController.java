package com.tom.example.deepintomybatis.springMvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @descriptions: IndexController
 * @author: Tom
 * @date: 2021/1/10 下午 10:56
 * @version: 1.0
 */


import org.springframework.ui.Model;

@Controller
@RequestMapping("/goods/")
public class IndexController {


    @RequestMapping("/doDeleteById")
    public String deleteById(Integer id){
        return "redirect:doGoodsUI";
    }
    //请求地址
//http://localhost:8080/goods/doGoodsUI
//此访问路径会传递到DispatcherServlet对象
//DispatcherServlet对象基于用户输入的url找到对应的controller及方法
//DispatcherServlet底层会通过反射技术调用对应的控制层方法
    @RequestMapping("/doGoodsUI")
    public String doGoodsUI(Model model) {

//将页面响应到客户端
        return "goods"; //view name
//1)此view返回给前端控制器(DispatcherServlet)
//2)前端控制器会调用视图解析器对view进行解析，添加前缀和后缀
    }

}