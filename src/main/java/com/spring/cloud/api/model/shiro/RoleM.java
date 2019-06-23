package com.spring.cloud.api.model.shiro;

import java.util.List;

public class RoleM {

    //角色名
    private String role;

    //权限列表
    private List<PermissionM> permissions;

    public List<PermissionM> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionM> permissions) {
        this.permissions = permissions;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
