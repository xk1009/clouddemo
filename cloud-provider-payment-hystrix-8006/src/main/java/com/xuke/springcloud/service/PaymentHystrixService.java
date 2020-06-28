package com.xuke.springcloud.service;

public interface PaymentHystrixService {

    String hystrix_ok();

    String hystrix_error();

    String hystrix_error_timeout();

    String circuit(Long id);
}
