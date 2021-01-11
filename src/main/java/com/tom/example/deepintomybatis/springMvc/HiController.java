package com.tom.example.deepintomybatis.springMvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
