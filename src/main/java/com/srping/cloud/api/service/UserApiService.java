package com.srping.cloud.api.service;

import com.srping.cloud.api.model.shiro.UserM;
import com.srping.cloud.api.utils.Result;

public interface UserApiService {

    Result regist(UserM user);

    Result login(UserM user);

    Result findByUsername(String username);
}
