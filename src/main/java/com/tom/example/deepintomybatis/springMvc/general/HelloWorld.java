package com.tom.example.deepintomybatis.springMvc.general;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @descriptions: HelloWorld
 * @author: Tom
 * @date: 2021/1/11 上午 09:00
 * @version: 1.0
 */
@Controller
public class HelloWorld {
    @RequestMapping("/helloWorld")
    public String helloWorld(Model model){
        model.addAttribute("message", "Hello World!");
        return "helloWorld";
    }

}
