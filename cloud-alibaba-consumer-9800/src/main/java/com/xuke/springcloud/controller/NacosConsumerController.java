package com.xuke.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NacosConsumerController {

    @Value("${server.port}")
    private String port;
    @Value("${payment.server_url}")
    private String server_url;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/nacos/consumer/get/{id}")
    public String nacosTest(@PathVariable("id") Long id){
        String result = restTemplate.getForObject(server_url + "/nacos/provider/get/" + id, String.class);
        return "客户端 端口号为 ："+port+";请求结果为 "+ result;
    }
}
