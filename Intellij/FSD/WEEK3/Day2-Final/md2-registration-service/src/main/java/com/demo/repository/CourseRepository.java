package com.demo.repository;

import com.demo.entity.Author;
import com.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    Course findByCourseId(int courseId);

    Course findByCourseName(String courseName);
}
