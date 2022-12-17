package com.demo.service;

import com.demo.entity.Course;
import com.demo.entity.Registration;

import java.util.List;

public interface CourseService {
    Course save(Course course);

    List<Course> findAll();
    Course findByCourseId(int courseId);
    Course findByCourseName(String courseName);

}
