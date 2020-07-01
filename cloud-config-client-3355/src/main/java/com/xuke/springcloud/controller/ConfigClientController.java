package com.xuke.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//刷新的注解标签
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String port;

    @GetMapping("/configClient/getConfig")
    public String getConfigInfo(){
        return "客户端端口号："+port+"; 配置文件类容："+configInfo;
    }
}
