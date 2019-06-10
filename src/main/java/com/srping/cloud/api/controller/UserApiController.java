package com.srping.cloud.api.controller;

import com.srping.cloud.api.model.UserM;
import com.srping.cloud.api.service.UserApiService;
import com.srping.cloud.api.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags= "用户相关接口")
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
    @PostMapping(value = "/regist")
    public Result regist(HttpServletRequest httpServletRequest, @ModelAttribute UserM user) {

        //所有接口不允许直接向前端返回当前登录用户ID
        //获取登录用户id办法
        String userId = httpServletRequest.getAttribute("userid").toString();

        //实现以下接口
        // userApiService.islogin(String token,long time)
        // 判断token是否有效
        //返回结果中有userId





        return userApiService.regist(user);
    }


    //https://blog.csdn.net/u011974797/article/details/81315503

}
