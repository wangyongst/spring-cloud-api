package com.spring.cloud.api.service.hystric;

import com.spring.cloud.api.service.UserService;
import com.spring.cloud.api.utils.Result;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystric implements UserService {
    @Override
    public Result regist(String name) {
        Result result = new Result();
        result.setStatus(1001);
        result.setMessage("***************");
        return result;
    }
}
