package com.demo.controller;

import com.demo.entity.Author;
import com.demo.entity.Course;
import com.demo.service.AuthorService;
import com.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4")
public class AuthorController {
//    Interface representing the environment in which the current application is running
    @Autowired
    private Environment environment;
    // TODO : Connect with the backend

    @Autowired
    private AuthorService authorService;

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
    
    @PostMapping("/authors/register")
    public Author createAuthor (@RequestBody Author author) {
    	
    	Author saveAuthor = authorService.save(author);
    	
    	return saveAuthor;
    	
    }
    
    @GetMapping("/findbyauthorid/{authorId}")
    @ResponseBody
    public Author findbyauthorid(@PathVariable(value = "authorId") Integer authorId) {

    	return authorService.findByAuthorId(authorId);
    }
    
    
    
    @GetMapping("/listofauthor")
    public List<Author> listofauthor() {
    	
    	return authorService.findAll();
    }

}
