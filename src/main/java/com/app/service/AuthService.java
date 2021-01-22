package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.entity.User;
import com.app.exception.ComplaintNotFoundException;
import com.app.repo.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
		
	public User fetchByUserMail(String tempMail) {
		
		User userObj = userRepository.findByUserMail(tempMail);
		
		Optional<User> useOpt = Optional.ofNullable(userObj);
		
		if(!useOpt.isPresent()) {
			
			throw new ComplaintNotFoundException("user with "+tempMail+" is not exist");
		}
		
		return userObj;
		 
	}
	
	
	
	public User fetchByUserMailForReg(String tempMail) {
		
		User userObj = userRepository.findByUserMail(tempMail);
		
		Optional<User> useOpt = Optional.ofNullable(userObj);
		
		if(useOpt.isPresent()) {
			
			throw new ComplaintNotFoundException("user with "+tempMail+" is already exist");
		}
		
		return userObj;
		 
	}
	
	
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
	
	public User fetchByUserMailAndUserPassword(String tempMail,String tempPassword) {
		
		User userObj = userRepository.findByUserMailAndUserPassword(tempMail, tempPassword);
		
		Optional<User> userOpt = Optional.ofNullable(userObj);
		
		if(!userOpt.isPresent()) {
			
			throw new ComplaintNotFoundException("Mail Id or Password not correct");
		}
		
		return userObj;
		
	}

}
