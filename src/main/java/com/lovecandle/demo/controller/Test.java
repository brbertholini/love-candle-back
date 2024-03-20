package com.lovecandle.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class Test {

    @GetMapping("/")
    public String hello(){
        return "Olá mundo" + new Date();
    }
}
