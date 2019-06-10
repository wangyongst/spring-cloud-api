package com.srping.cloud.api.service;

import com.srping.cloud.api.model.UserM;
import com.srping.cloud.api.utils.Result;

public interface UserApiService {

    Result regist(UserM user);
}
