package com.oracle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HellowController {

    @RequestMapping("/")
    public String menu(){
        return "forward:/oraclecrm.jsp";
    }

    @RequestMapping("/hellow")
    public String sayHellow(){
        System.out.println("hellow");
        return "index";
    }
    @RequestMapping("/main")
    public String showMain(){
        System.out.println("main");
        return "main";
    }
}
