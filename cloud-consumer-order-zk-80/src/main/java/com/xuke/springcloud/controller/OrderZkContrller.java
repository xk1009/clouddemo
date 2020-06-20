package com.xuke.springcloud.controller;

import com.xuke.springcloud.entities.CommonResult;
import com.xuke.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrderZkContrller {

    @Resource
    private RestTemplate restTemplate;

    private String url ="http://cloud-payment-service";

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id){
        return restTemplate.getForObject(url+"/payment/get/"+id,CommonResult.class);
    }
}
