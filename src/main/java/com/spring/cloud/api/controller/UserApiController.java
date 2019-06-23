package com.spring.cloud.api.controller;

import com.spring.cloud.api.model.shiro.UserM;
import com.spring.cloud.api.service.UserApiService;
import com.spring.cloud.api.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
    @RequiresRoles("caiwu")//注解权限;
    @PostMapping(value = "/regist")
    public Result regist(HttpServletRequest httpServletRequest, @ModelAttribute UserM user) {
        return userApiService.regist(user);
    }


    @ApiOperation(value = "用户注册接口", notes = "提供用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号（必需）,String型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = " 密码（必需）,String型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = " 手机号（必需）,String型", required = true, dataType = "String")

    })
    @RequiresPermissions(value = {"create", "delete"}, logical = Logical.OR)//注解权限;
    @PostMapping(value = "/regist2")
    public Result regist2(HttpServletRequest httpServletRequest, @ModelAttribute UserM user) {
        return userApiService.regist(user);
    }
}
