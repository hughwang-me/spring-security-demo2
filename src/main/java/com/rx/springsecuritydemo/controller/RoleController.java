package com.rx.springsecuritydemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "role")
@Slf4j
public class RoleController {

    @Secured({"ROLE_normal","ROLE_admin"})
    @GetMapping
    public String t1(){
        log.warn("TestController -> t1");
        return "TestController t1!";
    }
}
