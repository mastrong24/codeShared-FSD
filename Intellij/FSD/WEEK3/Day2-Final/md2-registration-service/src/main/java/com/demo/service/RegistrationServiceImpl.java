package com.demo.service;
import com.demo.entity.Registration;
import com.demo.repository.RegistrationRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements  RegistrationService{

    @Autowired
    private RegistrationRepository registrationRepository;


    @Override
    public Registration save(Registration registration) {
    	
    	MessageDigest messgeDigest;
    	
    	try {
    		messgeDigest = MessageDigest.getInstance("MD5");
    		String plainTextPasswordString = registration.getPassword();
    		byte[] passwordInByte = plainTextPasswordString.getBytes();
    		messgeDigest.update(passwordInByte);
    		byte[] resultByteArray = messgeDigest.digest();
    		StringBuilder stringBuilder = new StringBuilder();
    		for (byte byteVar : resultByteArray) {
    			String formattedString = String.format("%02x", byteVar);
    			stringBuilder.append(formattedString);
    		}
    		String hashedPassword = stringBuilder.toString();
    		registration.setPassword(hashedPassword);
    	}catch (NoSuchAlgorithmException e) {
    		throw new RuntimeException(e);
    	}
    	
    	Registration savedRegistration = registrationRepository.save(registration);
        return savedRegistration;
    }
    @Override
    public Registration findByEmail(String email) {


        return registrationRepository.findByEmail(email);
    }
    @Override
    public Registration findByEmailAndPassword(String email, String password) {
        return null;
    }
    @Override
    public Boolean isValidUser(String email, String password) {
    	
//    	
//    	Registration checkRegistration = registrationRepository.findByEmail(email);
//    	
//    	if(checkRegistration!=null && (checkRegistration.getPassword().equalsIgnoreCase(password))) {
//	
//    		return true;
//    	}
//    	else
//    		return false;
    	
    	MessageDigest messgeDigest;
    	
    	try {
    		messgeDigest = MessageDigest.getInstance("MD5");
//    		String encryptedPasswordString = checkRegistration.getPassword();
    		byte[] passwordInByte = password.getBytes();
    		messgeDigest.update(passwordInByte);
    		byte[] resultByteArray = messgeDigest.digest();
    		StringBuilder stringBuilder = new StringBuilder();
    		for (byte byteVar : resultByteArray) {
    			String formattedString = String.format("%02x", byteVar);
    			stringBuilder.append(formattedString);
    		}
    		String hashedPassword = stringBuilder.toString();
    		Registration registration= registrationRepository.findByEmailAndPassword(email, hashedPassword);
			System.out.println("**********"+email+" "+password+" "+hashedPassword);
//    		System.out.println("**********"+registration.getPassword() +"  "+registration.getEmail());
    		if(registration!=null && (registration.getPassword().equalsIgnoreCase(hashedPassword))) {
    			
        		return true;
        	}
        	else
        		return false;
    		
    	}catch (NoSuchAlgorithmException e) {
    		throw new RuntimeException(e);
    	}
    	
    	
    	
    }
}
