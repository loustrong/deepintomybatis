package com.tom.example.deepintomybatis.springMvc.general;

import com.tom.example.deepintomybatis.springMvc.general.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @descriptions: ModelAndViewController
 * @author: Tom
 * @date: 2021/1/11 上午 09:40
 * @version: 1.0
 */
@Controller
public class ModelAndViewController{

    @RequestMapping(value="/ModelAndViewTest")
    public ModelAndView ModelAndViewTest(ModelAndView mv){
        System.out.println("ModelAndViewTest");
        User user = new User();
        // 设置user对象的username属性
        user.setUsername("疯狂软件");
        // 将User对象添加到ModelAndView当中
        mv.addObject("user", user);
        // 设置要转发的页面
        mv.setViewName("result");
        return mv;
    }


}
