package com.xuke.springcloud.service.impl;


import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xuke.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String hystrix_ok() {
        return "ok";
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public String hystrix_error() {

        int i = 1/0;

        return "error";

    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback",commandProperties ={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String hystrix_error_timeout() {
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.getMessage();
        }
        return "error";
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback_circuit",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//开启服务熔断机制
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "10")//出现错误次数
    })
    public String circuit(Long id) {
        if(id<0){
            throw  new RuntimeException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return "id:"+id+" ; 获取订单号："+uuid;
    }


    private String fallback_circuit(Long id){
        return "id不能为负数："+id;
    }

    private String fallback_error(){
        return "出现错误或超时调用降级方法";
    }
}
