package com.srping.cloud.api.utils;

public class ResultUtil {

    public static boolean checkResult(Result result){
        if(result.getStatus() == ResultStatus.OK){
            return true;
        }
        return false;
    }


    public static Result hystric(){
        Result result = new Result();
        result.setStatus(ResultStatus.HYSTRIC);
        result.setMessage("服务请求失败，熔断处理！");
        return  result;
    }
}
