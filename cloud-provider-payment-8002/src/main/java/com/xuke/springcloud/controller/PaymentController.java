package com.xuke.springcloud.controller;

import com.xuke.springcloud.entities.CommonResult;
import com.xuke.springcloud.entities.Payment;
import com.xuke.springcloud.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PayMentService payMentService;

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

    @GetMapping("/feign/timeout")
    public CommonResult getPayment(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult(200,"端口号为： "+port+"，获取成功",null);
    }


    @GetMapping("/getPort/{id}")
    public String getPort(@PathVariable("id") Long id){
        return port+";id="+id;
    }
}
