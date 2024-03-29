package com.spring.cloud.api.service.feign;

import com.spring.cloud.api.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-cloud-utils")
public interface UtilsService {

    @GetMapping("result/okWithMessage")
    Result okWithMessage(@RequestParam("message") String message);


    @GetMapping("result/createErrorWithMessage")
    Result createErrorWithMessage(@RequestParam("message") String message);

    @GetMapping("restful/get")
    Result get(@RequestParam("url") String url);

    @GetMapping("db/createId")
    Result createId();

    @GetMapping("db/formatTime")
    Result formatTime(@RequestParam("time") long time);

    @GetMapping("db/parameterNotEnoughWithMessage")
    Result parameterNotEnoughWithMessage(@RequestParam("message") String message);

    @GetMapping(value = "result/jsonProcessingExceptionWithMessage")
    public Result jsonProcessingExceptionWithMessage(@RequestParam("message") String message);

    @GetMapping(value = "result/ioExceptionWithMessage")
    public Result ioExceptionWithMessage(@RequestParam("message") String message);

}
