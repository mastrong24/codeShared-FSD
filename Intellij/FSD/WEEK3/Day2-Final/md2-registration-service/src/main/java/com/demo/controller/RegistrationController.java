package com.demo.controller;
import com.demo.entity.Registration;
import com.demo.repository.RegistrationRepository;
import com.demo.service.RegistrationService;
import com.demo.service.RegistrationServiceImpl;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v2")
public class RegistrationController {
//    Interface representing the environment in which the current application is running
    @Autowired
    private Environment environment;
    // TODO : Connect with the backend

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/instance")
    public String getInstancePort() {
      String microservicePort =   environment.getProperty("local.server.port");
      return "Microservie running on port : " + microservicePort;
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
    
    @PostMapping("/registrations/register")
    public Registration createRegistration (@RequestBody Registration registration) {
    	
    	Registration saveRegistration = registrationService.save(registration);
    	
    	return saveRegistration;
    	
    }
    
//    @GetMapping("/authenticate")
//    @ResponseBody
//    public Boolean authenticate(@RequestParam(name = "email") String emailFromClient, @RequestParam(name = "password") String passwordFromClient) {
//    	
//    	return registrationService.isValidUser(emailFromClient, passwordFromClient);
//    }
    
    
    
    @GetMapping("/authenticate2/{email}/{password}")
    public Boolean authenticate(@PathVariable(value = "email") String emailFromClient, @PathVariable(value = "password") String passwordFromClient) {
    	
    	return registrationService.isValidUser(emailFromClient, passwordFromClient);
    }

}
