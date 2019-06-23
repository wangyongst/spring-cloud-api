package com.spring.cloud.api.service.feign;

import com.spring.cloud.api.model.shiro.UserM;
import com.spring.cloud.api.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-cloud-user-service")
public interface UserService {

    @PostMapping(value = "/user/regist")
    Result regist(@ModelAttribute UserM user);

    @GetMapping(value = "/user/find/username")
    Result findUserByUsername(@RequestParam("username") String username);

    @GetMapping(value = "/user/login")
    Result login(@ModelAttribute UserM user);
}
