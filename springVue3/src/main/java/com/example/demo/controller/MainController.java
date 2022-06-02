package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/welcome", "/room"})
    public String index(HttpServletRequest request){
        System.out.println(">>> Call index() ::: " +request.getRequestURL().toString());
        return "index";
    }
}
