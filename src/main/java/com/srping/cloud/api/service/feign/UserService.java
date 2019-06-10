package com.srping.cloud.api.service.feign;
import com.srping.cloud.api.model.User;
import com.srping.cloud.api.service.feign.hystric.UserServiceHystric;
import com.srping.cloud.api.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "spring-cloud-user-service",fallback = UserServiceHystric.class)
public interface UserService {

    @PostMapping(value = "/user/regist")
    Result regist(@ModelAttribute User user);
}
