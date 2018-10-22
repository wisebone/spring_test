package org.wisebone.springboot.controller;

import org.wisebone.springboot.bean.City;
import org.wisebone.springboot.service.ICityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;

@Controller
public class MyController {
    
    @Autowired
    ICityService cityService;

    @PostConstruct
    public void init() {
    	System.out.println("hello");
    }
}