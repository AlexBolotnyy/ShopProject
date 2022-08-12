package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-controller")
public class UserController {

    @GetMapping("/createNewUser")
    public String sayHello(String name){
        return "hello " + name;
    }
}
