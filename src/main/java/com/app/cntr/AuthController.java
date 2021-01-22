package com.app.cntr;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.exception.ComplaintNotFoundException;
import com.app.service.AuthService;
//import com.app.service.SendEmailService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;
	
//	@Autowired
//	private SendEmailService sendEmailService;

	
	public String encoder(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(password);
		return encodedPassword;	
	}
	
	public boolean decoder(String password, String encoded) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean isPasswordMatch = passwordEncoder.matches(password, encoded);
		return isPasswordMatch;
	}
	
	
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {

		String tempMail = user.getUserMail();
		Optional<String> mailOptional = Optional.ofNullable(tempMail);
		
		if(mailOptional.isPresent() && !"".equals(tempMail)) {
			
			authService.fetchByUserMailForReg(tempMail);

		}
		else {

			throw new ComplaintNotFoundException("Invalid Mail Id");
		}
		
		Optional<String> empDeptOptional = Optional.ofNullable(user.getUserDepartment() );

		if (empDeptOptional.isPresent()) {
			user.setUserType("emp");
			user.setUserAction("Active");

		} else {
			user.setUserType("user");
		}
		
		String today = new Date().getDate() + "-" + (new Date().getMonth() + 1) + "-" + "2021";

		user.setUserRegDate(today);
	
		
//		sendEmailService.sendEmail(user.getUserMail(),"Hello "+user.getUserName()+"\n\nPlease click below to login for PGRAMS"  +"\n\nhttp://pgrams-frontend.s3-website-us-east-1.amazonaws.com/login"+"\n\nThank You", "PGRAMS - Register Successful !!" + 
//				"");

	
	String encoded = encoder(user.getUserPassword());
		user.setUserPassword(encoded);
		
		//userObj = userServiceImple.saveUser(user);

		
		return authService.saveUser(user);

	}

	@CrossOrigin(origins = "*")
	@PostMapping("login")
	public User loginUser(@RequestBody User user) throws Exception {

		String tempMail = user.getUserMail();
		String tempPass = user.getUserPassword();
		Optional<String> mailOptional = Optional.ofNullable(tempMail);		Optional<String> passOptional = Optional.ofNullable(tempPass);

		User userObj = new User();

		if (mailOptional.isPresent() && passOptional.isPresent()  && !"".equals(tempMail) && !"".equals(tempPass)) {

			//userObj = authService.fetchByUserMailAndUserPassword(tempMail, tempPass);
			userObj = authService.fetchByUserMail(tempMail);
			boolean match = decoder(tempPass,userObj.getUserPassword());
			if(!match){
				System.out.println("not match");
				throw new Exception("Bad Credentials");
			}
		}

		return userObj;

	}
}
