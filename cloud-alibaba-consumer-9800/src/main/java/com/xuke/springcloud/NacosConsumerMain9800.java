package com.xuke.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerMain9800 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerMain9800.class,args);
    }
}
