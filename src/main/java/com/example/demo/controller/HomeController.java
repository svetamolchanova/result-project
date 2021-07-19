package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ModelAndView helloWorld() {
        ModelAndView model = new ModelAndView("user");
        return model;
    }
}
