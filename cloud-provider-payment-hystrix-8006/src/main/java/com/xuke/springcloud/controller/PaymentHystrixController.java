package com.xuke.springcloud.controller;

import com.xuke.springcloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentHystrixController {


    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/hystrix/ok")
    public String ok(){
        return "当前服务端口号为："+port+" ———— 调用方法："+paymentHystrixService.hystrix_ok();
    }

    @GetMapping("/payment/hystrix/error")
    public String error(){
        return "当前服务端口号为："+port+" ———— 调用方法："+paymentHystrixService.hystrix_error();
    }



    @GetMapping("/payment/hystrix/circuit/{id}")
    public String circuit(@PathVariable("id") Long id){
        return "当前服务端口号为："+port+" ———— 调用方法："+paymentHystrixService.circuit(id);
    }

}
