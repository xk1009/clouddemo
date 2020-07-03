package com.xuke.springcloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xuke.springcloud.entities.CommonResult;
import com.xuke.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SentinelController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/testA")
    @SentinelResource(value = "testA",blockHandler = "blockTestA",fallback = "fallback")
    public CommonResult testA(){
        int i = 1/0;
        return new CommonResult(200,"端口："+port+"; 调用testA方法");
    }

    public CommonResult blockTestA(BlockException blockException){
        log.info(blockException.getClass().getCanonicalName()+"---------");
        return new CommonResult(444,blockException.getMessage()+" 端口："+port+"; 调用testA限流方法");
    }

    public CommonResult fallback(Throwable e){
        return new CommonResult(555,e.getClass().getCanonicalName()+"运行异常调用 熔断方法");
    }
}
