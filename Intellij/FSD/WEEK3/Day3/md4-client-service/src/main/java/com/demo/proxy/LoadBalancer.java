package com.demo.proxy;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(name = "registration-service")
public class LoadBalancer {

    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder(){

        return Feign.builder();
    }

}
