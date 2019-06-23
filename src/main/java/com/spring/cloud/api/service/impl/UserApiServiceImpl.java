package com.spring.cloud.api.service.impl;

import com.spring.cloud.api.service.feign.UserService;
import com.spring.cloud.api.model.shiro.PermissionM;
import com.spring.cloud.api.model.shiro.RoleM;
import com.spring.cloud.api.model.shiro.UserM;
import com.spring.cloud.api.service.UserApiService;
import com.spring.cloud.api.utils.Result;
import com.spring.cloud.api.utils.ResultStatus;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserApiService")
public class UserApiServiceImpl implements UserApiService {

    @Autowired
    public UserService userService;

    @Override
    public Result regist(UserM user) {
        //return userService.regist(user);
        Result result = new Result();
        result.setStatus(ResultStatus.OK);
        result.setMessage("成功");
        return result;

    }

    @Override
    public Result findByUsername(String username) {
        //实现这个服务，传入用户名返回User对象，必须封装成我定义的User对象
        //User一对多Role,Role一对多Permission
        //return userService.findUserByUsername(username);
        Result result = new Result();
        if (username.equals("test")) {
            result.setStatus(ResultStatus.OK);
            List<PermissionM> permissionMS = new ArrayList<>();

            PermissionM permissionM = new PermissionM();
            permissionM.setPermission("create");
            permissionMS.add(permissionM);

            PermissionM permissionM1 = new PermissionM();
            permissionM1.setPermission("delete");
            permissionMS.add(permissionM1);

            List<RoleM> roleMS = new ArrayList<>();
            RoleM roleM = new RoleM();
            roleM.setRole("caiwu");
            roleM.setPermissions(permissionMS);
            roleMS.add(roleM);

            UserM userM = new UserM();
            userM.setUsername("test");
            userM.setPassword(new Md5Hash("test").toHex());
            userM.setRoles(roleMS);
            result.setData(userM);
        }
        return result;
    }
}
