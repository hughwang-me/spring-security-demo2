package com.rx.springsecuritydemo.controller;

import com.alibaba.fastjson.JSON;
import com.rx.springsecuritydemo.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "u")
@Slf4j
public class AccountController {

//    @PostMapping(value = "login")
//    public String login(@RequestParam("username")String username , @RequestParam("password")String password){
//        log.warn("AccountController -> login");
//        Account account = new Account();
//        account.setUsername(username);
//        account.setPassword(password);
//        log.warn("AccountController -> {}" , JSON.toJSONString(account));
//        return JSON.toJSONString(account);
//    }

    @PostMapping(value = "login2")
    public String login2(@RequestBody Account account){
        log.warn("AccountController -> login2");
        log.warn("AccountController login2 -> {}" , JSON.toJSONString(account));
        return JSON.toJSONString(account);
    }
}
