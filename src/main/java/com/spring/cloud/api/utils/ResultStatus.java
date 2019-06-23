package com.spring.cloud.api.utils;

public class ResultStatus {

    //正常结果
    public final static int OK = 1;

    //登录失败
    public final static int LOGINOK = 2;

    //未登录或登出成功
    public final static int UNAUTH = 3;

    //登录失败
    public final static int LOGINFAIL = 4;

    //权限不足
    public final static int NOPERMISSION = 403;
}
