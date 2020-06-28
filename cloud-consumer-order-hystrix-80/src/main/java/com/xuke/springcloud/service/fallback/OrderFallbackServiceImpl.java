package com.xuke.springcloud.service.fallback;

import com.xuke.springcloud.service.OrderHystrixService;
import org.springframework.stereotype.Component;

@Component
public class OrderFallbackServiceImpl implements OrderHystrixService {
    @Override
    public String ok() {
        return "客户端降级方法：ok，运行时异常或超时";
    }

    @Override
    public String error() {
        return "客户端降级方法：error，运行时异常或超时";
    }
}
