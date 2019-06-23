package com.srping.cloud.api.model.shiro;

import java.util.List;

public class UserM {
    //用户名
    private String username;
    //密码
    private String password;
    //加盐
    private String salt;
    //角色列表
    private List<RoleM> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<RoleM> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleM> roles) {
        this.roles = roles;
    }
}
