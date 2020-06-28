package com.xuke.springcloud.service;

import com.xuke.springcloud.service.fallback.OrderFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE-HYSTRIX",fallback = OrderFallbackServiceImpl.class)
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/ok")
    String ok();

    @GetMapping("/payment/hystrix/error")
    String error();
}
