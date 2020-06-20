package com.xuke.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String port;
    @GetMapping("/payment/consul")
    public String getConsul(){
        return "服务提供方："+port+"  __  序列号："+ UUID.randomUUID().toString();
    }
}
