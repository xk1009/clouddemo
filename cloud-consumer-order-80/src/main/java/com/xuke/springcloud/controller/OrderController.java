package com.xuke.springcloud.controller;

import com.xuke.springcloud.entities.CommonResult;
import com.xuke.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;


//    private String url = "http://localhost:8001";
    private String url = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){

        log.info("客户端 生成一个支付信息");
        return restTemplate.postForObject(url+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id){
        log.info("客户端 获取一个支付信息");
        return restTemplate.getForObject(url+"/payment/get/"+id,CommonResult.class);
    }
}
