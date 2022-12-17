package com.demo.controller;

import com.demo.entity.Course;
import com.demo.service.CourseService;
import com.demo.service.CourseServices;
import com.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v5")
public class CourseController {
	@Autowired
	private CourseServices courseServices;

	@GetMapping("/instance")
	public String getServiceInstance() {
		String serverInstancePortString = courseServices.getServiceInstance();
		return serverInstancePortString;
	}
	
	@GetMapping("/courses/register")
	public String createCourse(@RequestBody Course course) {

		return courseServices.createCourse(course);

	}

	@GetMapping("/listofcourses")
	public List<Course> listOfCourse(){

		return courseServices.listOfCourse();
	}

	@GetMapping("/findbycourseid/{courseId}")
	public Course findByCourseId(@PathVariable(value = "courseId") Integer courseId){

		return courseServices.findByCourseId(courseId);
	}

}
