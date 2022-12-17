package com.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import com.demo.service.RegistRationService;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Md3ClientAppApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Md3ClientAppApplication.class, args);
		RegistRationService registrationService = applicationContext.getBean("registRationService", RegistRationService.class);
		String serverInstancePortString = registrationService.getServiceInstance();	
		System.out.println("Client connected to Registration Microservice @ port : " + serverInstancePortString);

		String emailString = "lim1@ncs.com.sg";
		String passwordString = "123";

		Boolean thruth=registrationService.login(emailString,passwordString);

		if (thruth.equals(true)){

			System.out.println(thruth);
		}
		else {
			System.out.println(thruth);
		}
	}

}
