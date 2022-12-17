package com.demo.proxy;

import com.demo.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//Directly invoking a service instance
//@FeignClient(name="registration-service" , url = "http://localhost:9302")
@FeignClient(name="registration-service")
public interface RegistrationProxy {
	@GetMapping("/api/v2/instance")
	public String getServiceInstance();

	@GetMapping("/api/v2/authenticate2/{email}/{password}")
	public Boolean login(@PathVariable String email, @PathVariable String password);


}