package com.spring.cloud.api.service;


import com.spring.cloud.api.service.hystric.UserServiceHystric;
import com.spring.cloud.api.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service",fallback = UserServiceHystric.class)
public interface UserService {

    @PostMapping(value = "/hi")
    Result regist(@RequestParam(value = "name") String name);
}
