package com.srping.cloud.api.service.feign;


import com.srping.cloud.api.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-cloud-utils")
public interface ResultService {

    @GetMapping(value = "result/ok")
    Result ok();

    @GetMapping(value = "result/okWithMessage")
    Result okWithMessage(@RequestParam("message") String message);

    @GetMapping(value = "result/okWithData")
    Result okWithData(@RequestParam("data") Object data);

    @GetMapping(value = "result/okWithDataAndMessage")
    Result okWithDataAndMessage(@RequestParam("data")  Object data, @RequestParam("message")  String message);

    @GetMapping(value = "result/parameterNotEnoughWithDataAndMessage")
    Result parameterNotEnoughWithDataAndMessage(@RequestParam("data")  Object data, @RequestParam("message")  String message);

    @GetMapping(value = "result/parameterErrorWithDataAndMessage")
    Result parameterErrorWithDataAndMessage(@RequestParam("data")  Object data, @RequestParam ("message") String message);

}
