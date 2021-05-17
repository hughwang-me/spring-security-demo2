package com.rx.springsecuritydemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "book")
@Slf4j
public class BookController {

    @GetMapping
    public String get(){
        log.warn("BookController -> get");
        return "BookController get!";
    }

    @PutMapping
    public String put(){
        log.warn("BookController -> put");
        return "BookController put!";
    }

    @PostMapping
    public String post(){
        log.warn("BookController -> post");
        return "BookController post!";
    }
}
