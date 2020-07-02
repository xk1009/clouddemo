package com.xuke.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/nacos/provider/get/{id}")
    public String NacosTest(@PathVariable("id") Long id){

        return "服务提供者端口号为："+port+"; 获取id："+id;
    }
}
