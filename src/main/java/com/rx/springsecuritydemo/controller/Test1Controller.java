package com.rx.springsecuritydemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test1")
@Slf4j
public class Test1Controller {

    @GetMapping(value = "t1")
    public String t1(){
        log.warn("TestController -> t1");
        return "TestController t1!";
    }

    @PostMapping(value = "t3")
    public String t3(){
        log.warn("TestController -> t3");
        return "TestController t3!";
    }

    @GetMapping(value = "t2")
    public String t2(){
        log.warn("TestController -> t2");
        return "TestController t2!";
    }
}
