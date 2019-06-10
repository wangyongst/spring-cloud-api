package com.srping.cloud.api.utils;

public class ResultUtil {

    public static boolean checkResult(Result result) {
        if (result != null && result.getStatus() == ResultStatus.OK) {
            return true;
        }
        return false;
    }
}
