package com.tom.example.deepintomybatis.springMvc.general;

import com.tom.example.deepintomybatis.springMvc.general.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @descriptions: ModelController
 * @author: Tom
 * @date: 2021/1/11 上午 09:13
 * @version: 1.0
 */
@Controller
public class ModelController {

    @RequestMapping(value="/modelTest")
    public String modelTest(Model model){
        System.out.println("modelTest");
        User user = new User();
        // 设置user对象的username属性
        user.setUsername("疯狂软件");
        // 将User对象添加到Model当中
        model.addAttribute("user", user);
        return "result1";
    }

    @RequestMapping(value="/ModelMapTest")
    public String ModelMapTest(ModelMap modelMap){
        System.out.println("ModelMapTest");
        User user = new User();
        // 设置user对象的username属性
        user.setUsername("疯狂软件");
        // 将User对象添加到ModelMap当中
        modelMap.addAttribute("user", user);
        return "result2";
    }
}
