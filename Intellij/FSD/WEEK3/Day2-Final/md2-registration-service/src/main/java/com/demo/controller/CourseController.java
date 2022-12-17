package com.demo.controller;

import com.demo.entity.Author;
import com.demo.entity.Course;
import com.demo.entity.Registration;
import com.demo.service.CourseService;
import com.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class CourseController {
//    Interface representing the environment in which the current application is running
    @Autowired
    private Environment environment;
    // TODO : Connect with the backend

    @Autowired
    private CourseService courseService;

    @GetMapping("/instance")
    public String getInstancePort() {
      String microservicePort =   environment.getProperty("local.server.port");
      return "Course Microservices running on port : " + microservicePort;
    }

//    @RequestMapping("/findByEmail/{email}")
//    public Registration findByEmail(@PathVariable(value = "email") String emailFromClient) {
//        System.out.println("GET EMPLOYEE WITH THE GIVEN ID FROM REPOSITORY");
////        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(idFromClient);
////        EmployeeEntity employeeEntity = employeeEntityOptional.get();
//        RegistrationService registrationService=new RegistrationServiceImpl();
//        registrationService.findByEmail(emailFromClient);
//
//        return registrationService.findByEmail(emailFromClient);
//    }
    
    @PostMapping("/courses/register")
    public Course createCourse (@RequestBody Course course) {
    	
    	Course saveCourse = courseService.save(course);
    	
    	return saveCourse;
    	
    }

    @GetMapping("/findbycourseid/{courseId}")
    @ResponseBody
    public Course findbycourseid(@PathVariable(value = "courseId") Integer courseId) {

        return courseService.findByCourseId(courseId);

    }
    
    @GetMapping("/listofcourses")
    public List<Course> listofcourse() {
    	
    	return courseService.findAll();
    }

}
