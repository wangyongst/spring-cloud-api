package com.srping.cloud.api.utils;

public class ResultStatus {

    //正常结果
    public final static int OK = 1;

    //登录认证失败
    public final static int AUTH_FAIL = 2;

    //熔断
    public final static int HYSTRIC = 3;

}
