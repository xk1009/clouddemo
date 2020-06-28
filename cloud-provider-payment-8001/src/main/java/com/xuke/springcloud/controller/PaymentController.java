package com.xuke.springcloud.controller;

import com.xuke.springcloud.entities.CommonResult;
import com.xuke.springcloud.entities.Payment;
import com.xuke.springcloud.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PayMentService payMentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        int insert = payMentService.insert(payment);
        return insert>0?new CommonResult(200,"端口号为： "+port+"，添加成功",insert):new CommonResult(444,"添加失败");
    }

    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment = payMentService.selectByPrimaryKey(id);
        log.info("获取数据payment：" +payment);
        return payment==null?new CommonResult(444,"获取失败"):new CommonResult(200,"端口号为： "+port+"，获取成功",payment);
    }

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String ele: services) {
            log.info("——服务名称— ： "+ele);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances) {
            String instanceId = instance.getInstanceId();
            int port = instance.getPort();
            URI uri = instance.getUri();
            log.info("instanceId:"+instanceId);
            log.info("port:"+port);
            log.info("uri:"+uri);
            log.info("=========================");
        }
        return discoveryClient;
    }

        @GetMapping("/getPort/{id}")
        public String getPort(@PathVariable("id") Long id){
            return port+";id="+id;
        }
}
