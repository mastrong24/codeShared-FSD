package com.demo.md5apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
public class Md5ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Md5ApiGatewayApplication.class, args);
	}

}
