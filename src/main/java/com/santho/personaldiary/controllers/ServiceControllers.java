package com.santho.personaldiary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServiceControllers {
    @RequestMapping("/")
    public String start(){
        System.out.println("Coming inside start()");
        return "index";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "forbidden";
    }
}
