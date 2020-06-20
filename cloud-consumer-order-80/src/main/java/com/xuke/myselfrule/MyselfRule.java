package com.xuke.myselfrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的 负载规则 改为随机
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
