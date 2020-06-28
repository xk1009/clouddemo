package com.xuke.springcloud.controller;

import com.xuke.springcloud.service.OrderHystrixService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/consumer/hystrix/ok")
    public String ok(){
        return "当前客户端口号："+port+"===="+orderHystrixService.ok();
    }

    @GetMapping("/consumer/hystrix/error")
    public String error(){
        return "当前客户端口号："+port+"===="+orderHystrixService.error();
    }
}
