package com.spring.cloud.api.service;

import com.spring.cloud.api.model.shiro.UserM;
import com.spring.cloud.api.utils.Result;

public interface UserApiService {

    Result regist(UserM user);

    Result findByUsername(String username);
}
