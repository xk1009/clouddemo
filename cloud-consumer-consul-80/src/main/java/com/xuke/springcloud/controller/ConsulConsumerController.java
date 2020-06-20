package com.xuke.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsulConsumerController {

    @Resource
    private RestTemplate restTemplate;

    private String url = "http://consul-provider-payment";
    @GetMapping("/consumer/payment/consul")
    public String getConsul(){
        return restTemplate.getForObject(url+"/payment/consul",String.class);
    }
}
