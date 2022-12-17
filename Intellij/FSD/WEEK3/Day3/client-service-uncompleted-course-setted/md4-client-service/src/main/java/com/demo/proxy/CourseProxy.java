package com.demo.proxy;

import com.demo.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//Directly invoking a service instance
//@FeignClient(name="registration-service" , url = "http://localhost:9302")
@FeignClient(name="registration-service")
public interface CourseProxy {
	@GetMapping("/api/v3/instance")
	public String getServiceInstance();

	@GetMapping("/api/v3/courses/register")
	public String createCourse(@RequestBody Course course);

	@GetMapping("/api/v3/listofcourses")
	public List<Course> listOfCourse();

	@GetMapping("/api/v3/findbycourseid/{courseId}")
	public Course findByCourseId(@PathVariable(value = "courseId") Integer courseId);
}

