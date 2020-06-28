package com.xuke.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //hystrix 回路开启
public class PaymentHystrixMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8006.class,args);
    }
}
