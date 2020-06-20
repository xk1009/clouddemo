package com.xuke.springcloud.controller;

import com.xuke.springcloud.entities.CommonResult;
import com.xuke.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderOpenFeignController
{

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/feign/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPayment(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public CommonResult timeout(){
        return paymentFeignService.timeout();
    }
}
