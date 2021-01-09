package com.tom.example.deepintomybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello Controller
 *
 * @author Tom on 2021/1/8
 */
@RestController
public class HelloController {
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String hello(){
        return "Hello world.";
    }

}
