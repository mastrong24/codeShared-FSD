package com.demo.service;
import org.springframework.stereotype.Service;

import com.demo.entity.Registration;

public interface RegistrationService {
    Registration save(Registration registration);
    Registration findByEmail(String email);
    Registration findByEmailAndPassword(String email, String password);
    Boolean isValidUser(String email, String password);
}
