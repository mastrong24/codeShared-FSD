package com.demo.service;

import com.demo.entity.Course;
import com.demo.entity.Registration;
import com.demo.repository.CourseRepository;
import com.demo.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{

    @Autowired
    private CourseRepository courseRepository;

	@Override
	public Course save(Course course) {

		Course course1=courseRepository.save(course);
		return course1;
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findByCourseId(int courseId) {

		Course course=courseRepository.findByCourseId(courseId);
		return course;
	}

	@Override
	public Course findByCourseName(String courseName) {

		Course course=courseRepository.findByCourseName(courseName);
		return course;
	}
}
