package com.srping.cloud.api.service.impl;

import com.srping.cloud.api.model.UserM;
import com.srping.cloud.api.service.UserApiService;
import com.srping.cloud.api.service.feign.UserService;
import com.srping.cloud.api.utils.Result;
import com.srping.cloud.api.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserApiService")
public class UserApiServiceImpl implements UserApiService {

    @Autowired
    public UserService userService;

    @Override
    public Result regist(UserM user) {
        //第一个服务调用
        Result userResult = userService.regist(user);
        if (ResultUtil.checkResult(userResult)) return userResult;
        UserM user2 = (UserM) userResult.getData();
        //第二个服务调用
        return  userService.regist(user);

    }
}
