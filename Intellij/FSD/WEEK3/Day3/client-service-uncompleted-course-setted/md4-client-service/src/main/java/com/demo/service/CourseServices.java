package com.demo.service;

import com.demo.entity.Course;
import com.demo.proxy.CourseProxy;
import com.demo.proxy.RegistrationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CourseServices {

	@Autowired
	private CourseProxy courseProxy;


	public String getServiceInstance() {
	String serverInstancePortString = courseProxy.getServiceInstance();
	return serverInstancePortString;
	}


	public String createCourse( Course course){

		return courseProxy.createCourse(course);

	}


	public List<Course> listOfCourse(){

		return courseProxy.listOfCourse();
	}


	public Course findByCourseId(Integer courseId){

		return courseProxy.findByCourseId(courseId);
	}

}


