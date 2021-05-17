package com.rx.springsecuritydemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "authority")
@Slf4j
public class AuthorityController {

    /**
     * @PreAuthorize：进入方法前进行权限验证， @PreAuthorize 可以将登录用户的 roles/permissions 参数传到方法中。
     * @return
     */
    @PreAuthorize("hasAuthority('query')")
    @GetMapping(value = "t1")
    public String t1(){
        log.warn("TestController -> t1");
        return "TestController t1!";
    }

    /**
     * @PostAuthorize：方法执行后再进行权限验证，适合验证带有返回值的权限
     * @return
     */
    @PostAuthorize("hasAuthority('query2')")
    @GetMapping(value = "t2")
    public String t2(){
        log.warn("TestController -> t2");
        return "TestController t1!";
    }
}
