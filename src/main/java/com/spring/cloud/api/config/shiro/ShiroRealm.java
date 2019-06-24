package com.spring.cloud.api.config.shiro;

import com.spring.cloud.api.model.shiro.RoleM;
import com.spring.cloud.api.model.shiro.UserM;
import com.spring.cloud.api.model.shiro.PermissionM;
import com.spring.cloud.api.service.UserApiService;
import com.spring.cloud.api.utils.Result;
import com.spring.cloud.api.utils.ResultUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserApiService userApiService;

    //权限信息，包括角色以及权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserM user = (UserM) principals.getPrimaryPrincipal();
        for (RoleM role : user.getRoles()) {
            authorizationInfo.addRole(role.getRole());
            for (PermissionM p : role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        UserM user = null;
        Result result = userApiService.findByUsername(username);
        if (ResultUtil.checkResult(result)) user = (UserM) result.getData();
        else throw new AuthenticationException();
        if (user == null) {
            throw new AuthenticationException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        return authenticationInfo;
    }
}