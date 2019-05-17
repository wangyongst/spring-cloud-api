package com.srping.cloud.api.service;

import com.srping.cloud.api.model.User;
import com.srping.cloud.api.utils.Result;

public interface UserApiService {

    Result regist(User user);
}
