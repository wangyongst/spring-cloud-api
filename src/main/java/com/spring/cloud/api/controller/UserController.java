package com.spring.cloud.api.controller;

import com.spring.cloud.api.service.UserService;
import com.spring.cloud.api.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    public UserService uerService;
    @PostMapping(value = "/book/isbn")
    public Result isbn(@RequestParam String name) {
        return uerService.regist(name);
    }

}
