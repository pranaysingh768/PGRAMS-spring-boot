package com.app.cntr;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.ChangePassword;
import com.app.entity.Complaint;
import com.app.entity.ContactUs;
import com.app.entity.User;
import com.app.exception.ComplaintNotFoundException;
import com.app.service.AuthService;
import com.app.service.SendEmailService;
import com.app.service.UserServiceInmple;

@RestController
public class UserController {
	
	private String mail="";
	//Model map;
	
	@Autowired
	private UserServiceInmple userServiceInmple;
	
	@Autowired
	private SendEmailService sendEmailService;
	
	@Autowired
	private AuthService authService;
	
	
	@CrossOrigin
	@PostMapping("/add/{userId}")
	public Complaint addComplaint(@PathVariable int userId,@RequestBody Complaint complaint) {
		
		userServiceInmple.checkComplaint(complaint);
		
		Optional<String> com = Optional.ofNullable(complaint.getComplaintDetail());
		
		if(!com.isPresent()) {
			throw new ComplaintNotFoundException("Please enter complaint detail field");
		}
		
		
		String today = new Date().getDate()+"-"+(new Date().getMonth() +1)+"-"+"2021";
		 
		complaint.setUserId(userId);
		complaint.setEmployeeId(0);
		complaint.setComplaintDate(today);
		complaint.setUserComplaintStatus("Pending");
		complaint.setComplaintStatus("In Active");

		
		return userServiceInmple.addComplaint(complaint);
	}
	
	@CrossOrigin
	@GetMapping("/getOnCID/{cId}")
	public Complaint getComplaintOnCID(@PathVariable int cId){
			
		Complaint complaint= userServiceInmple.findComplaintOnCID(cId);
		
		System.out.println(complaint.getComplaintId());
		System.out.println(complaint.getComplaintTitle());
		return complaint;
	}


	@CrossOrigin
	@GetMapping("/complaintList/{userId}")
	public List<Complaint> getComplaints(@PathVariable int userId){
		
		return userServiceInmple.findComplaint(userId);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/changeUserPass/{id}")
	public User updateUserPassword(@PathVariable int id,@RequestBody ChangePassword changePassword) {
		
		System.out.println(id+" --");
		User userObj = userServiceInmple.fetchByUserId(id);
	
		if(userObj.getUserPassword().equals(changePassword.getOldPassword())) {
			
			userObj.setUserPassword(changePassword.getNewPassword());
		}
		
		else {
			throw new ComplaintNotFoundException("Old Password Not Correct!!");
		}
		
		userServiceInmple.changePassword(userObj);
		return userObj;
	}
	
	@CrossOrigin
	@PostMapping("/send-mail")
	public void sendEmailForgotPass(@RequestBody User user) {
		
		User userObj = authService.fetchByUserMail(user.getUserMail());
		
		String name=userObj.getUserName();
		
		this.mail = user.getUserMail();
		
		sendEmailService.sendEmail(this.mail,"Hello "+name+"\n\nPlease click below to reset your password for PGRAMS"  +"\n\nhttp://pgrams-frontend.s3-website-us-east-1.amazonaws.com/forgot-password-form"+"\n\nThank You", "PGRAMS - Reset Forgotten Password" + 
				"");
		
	}

    @CrossOrigin
	@PostMapping("/change-frogot-pass")
	public User changeForgotPass(@RequestBody User user) {
		
		User userObj = authService.fetchByUserMail(this.mail);
		
		userObj.setUserPassword(user.getUserPassword());
		
		userServiceInmple.changePassword(userObj);
		
		this.mail="";
		
		return userObj;
		
	}


	@CrossOrigin
	@PostMapping("/contact-us")
	public void userContactUs(@RequestBody ContactUs contactUs){
		
		userServiceInmple.userContactUs(contactUs);
		System.out.println((contactUs));
		sendEmailService.sendEmail(contactUs.geteMailId(),"Hello "+contactUs.getFirstName()+" "+contactUs.getLastName()+"\n\n"+contactUs.getMessageBody(), contactUs.getSubject());
		//sendEmailService.sendEmail(contactUs.geteMailId(),"hiii","hyy");

		
			 
	}
	
	
}
