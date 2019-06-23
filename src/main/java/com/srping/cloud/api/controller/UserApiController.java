package com.srping.cloud.api.controller;

import com.srping.cloud.api.model.shiro.UserM;
import com.srping.cloud.api.service.UserApiService;
import com.srping.cloud.api.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户相关接口")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    public UserApiService userApiService;

    @ApiOperation(value = "用户注册接口", notes = "提供用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号（必需）,String型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = " 密码（必需）,String型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = " 手机号（必需）,String型", required = true, dataType = "String")

    })
    @RequiresPermissions("user:select")//注解权限;
    @PostMapping(value = "/regist")
    public Result regist(HttpServletRequest httpServletRequest, @ModelAttribute UserM user) {
        return userApiService.regist(user);
    }
}
