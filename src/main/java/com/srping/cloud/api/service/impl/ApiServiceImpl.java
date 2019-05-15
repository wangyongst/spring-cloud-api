package com.srping.cloud.api.service.impl;

import com.ctc.wstx.util.StringUtil;
import com.srping.cloud.api.model.User;
import com.srping.cloud.api.service.ApiService;
import com.srping.cloud.api.service.feign.ResultService;
import com.srping.cloud.api.service.feign.UserService;
import com.srping.cloud.api.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ApiServcie")
public class ApiServiceImpl implements ApiService {

    @Autowired
    public UserService userService;

    @Autowired
    public ResultService resultService;

    @Override
    public Result regist(User user) {
        if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()) || StringUtils.isBlank(user.getPhone())) return resultService.parameterNotEnoughWithDataAndMessage(user,"缺少必需参数");
        else return userService.regist(user);
    }
}
