package com.srping.cloud.api.utils;

public class ResultUtil {

    public static boolean checkResult(Result result) {
        if (result != null && result.getStatus() == ResultStatus.OK) {
            return true;
        }
        return false;
    }

    public static Result noPermission() {
        Result result = new Result();
        result.setStatus(ResultStatus.NOPERMISSION);
        result.setMessage("你没有访问权限");
        return result;
    }

    public static Result unAuth() {
        Result result = new Result();
        result.setStatus(ResultStatus.UNAUTH);
        result.setMessage("你还未登录或已经退出！");
        return result;
    }


    public static Result loginFail(String message) {
        Result result = new Result();
        result.setStatus(ResultStatus.LOGINFAIL);
        return result;
    }


    public static Result loginOK(String token) {
        Result result = new Result();
        result.setStatus(ResultStatus.LOGINOK);
        result.setData(token);
        result.setMessage("登录成功");
        return result;
    }
}
