package com.srping.cloud.api.controller;

import com.srping.cloud.api.model.User;
import com.srping.cloud.api.service.ApiService;
import com.srping.cloud.api.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags= "用户相关接口")
@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class ApiController {

    @Autowired
    public ApiService apiService;


    @ApiOperation(value = "用户注册接口", notes = "提供用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号（必需）", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = " 密码（必需）", required = true, dataType = "String"),
            @ApiImplicitParam(name = "mobile", value = " 手机号（必需）", required = true, dataType = "String")
    })
    @PostMapping(value = "/regist")
    public Result regist(@ModelAttribute User user) {
        return apiService.regist(user);
    }

}
