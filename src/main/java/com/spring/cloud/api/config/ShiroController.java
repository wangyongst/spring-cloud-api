package com.spring.cloud.api.config;

import com.spring.cloud.api.model.shiro.UserM;
import com.spring.cloud.api.service.UserApiService;
import com.spring.cloud.api.service.feign.UtilsService;
import com.spring.cloud.api.utils.Result;
import com.spring.cloud.api.utils.ResultUtil;
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
import springfox.documentation.annotations.ApiIgnore;

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


    @PostMapping(value = "/login")
    public Result login(@ModelAttribute UserM user) {
        Subject subject = SecurityUtils.getSubject();
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()))
            return utilsService.parameterNotEnoughWithMessage("用户名或密码不能为空");
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            return ResultUtil.loginOK(subject.getSession().getId().toString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.loginFail("登录失败");
        }
    }

    @PostMapping(value = "/logout")
    public Result login() {
        return ResultUtil.unAuth();
    }

    @ApiIgnore
    @RequestMapping(value = "/unauth")
    public Result unauth() {
        return ResultUtil.unAuth();
    }
}
