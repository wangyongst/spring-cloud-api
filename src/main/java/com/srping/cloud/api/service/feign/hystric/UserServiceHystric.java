package com.srping.cloud.api.service.feign.hystric;

import com.srping.cloud.api.model.User;
import com.srping.cloud.api.service.feign.UserService;
import com.srping.cloud.api.utils.Result;
import com.srping.cloud.api.utils.ResultUtil;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystric  implements UserService {

    @Override
    public Result regist(User user) {
        return ResultUtil.hystric();
    }
}
