package com.srping.cloud.api.controller;

import com.srping.cloud.api.model.shiro.UserM;
import com.srping.cloud.api.service.UserApiService;
import com.srping.cloud.api.service.feign.UtilsService;
import com.srping.cloud.api.utils.Result;
import com.srping.cloud.api.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户认证相关接口")
@CrossOrigin("*")
@RestController
@RequestMapping("/shiro")
public class ShiroController {

    @Autowired
    public UserApiService userApiService;

    @Autowired
    public UtilsService utilsService;

    @RequestMapping("/403")
    public Result unauthorizedRole() {
        return ResultUtil.noPermission();
    }


    @ApiOperation(value = "用户登录接口", notes = "提供用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号（必需）,String型", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = " 密码（必需）,String型", required = true, dataType = "String")

    })
    @PostMapping(value = "/login")
    public Result login(@ModelAttribute UserM user) {
        Subject subject = SecurityUtils.getSubject();
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()))
            return utilsService.parameterNotEnoughWithMessage("用户名或密码不能为空");
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(token);
        try {
            subject.login(token);
            return ResultUtil.loginOK(subject.getSession().getId().toString());
        } catch (Exception e) {
            return ResultUtil.loginFail("登录失败");
        }
    }


    @ApiOperation(value = "用户登出接口", notes = "提供用户登出")
    @PostMapping(value = "/logout")
    public Result login() {
        return ResultUtil.unAuth();
    }

    @RequestMapping(value = "/unauth")
    public Result unauth() {
        return ResultUtil.unAuth();
    }
}
