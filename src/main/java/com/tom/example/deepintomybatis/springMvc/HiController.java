package com.tom.example.deepintomybatis.springMvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HiController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/hi")
    public String sayHello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hi";
    }
    @RequestMapping(value="/hello")
    public ModelAndView hello(){
        System.out.println("hello方法 被调用");
        // 创建准备返回的ModelAndView对象，
        // 该对象通常包含了返回视图的路径、模型的名称以及模型对象
        ModelAndView mv = new ModelAndView();
        //添加模型数据 可以是任意的POJO对象
        mv.addObject("message", "Hello World!");
        // 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("/WEB-INF/views/welcome.jsp");
        // 返回ModelAndView对象。
        return mv;
    }
}
