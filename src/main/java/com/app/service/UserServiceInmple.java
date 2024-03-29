package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.entity.Complaint;
import com.app.entity.ContactUs;
import com.app.entity.User;
import com.app.exception.ComplaintNotFoundException;
import com.app.repo.ComplaintRepository;
import com.app.repo.ContactUsRepository;
import com.app.repo.UserRepository;

@Service
public class UserServiceInmple {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ComplaintRepository complaintRepository;
	
	@Autowired
	private ContactUsRepository contactUsRepository;
	
	public void checkComplaint(Complaint complaint) {
		
		Optional<Complaint> comOptional = Optional.ofNullable(complaint);
		
		if(!comOptional.isPresent()) {
			
			throw new ComplaintNotFoundException("Not allowed to access Complaint object, it contains null");
		}
	}

    	public Complaint addComplaint(Complaint complaint) {
		
		return complaintRepository.save(complaint);
	}
	
	public Complaint findComplaintOnCID(int Id){
		
		Complaint complaint = complaintRepository.findByComplaintId(Id);
		
		Optional<Complaint> com = Optional.ofNullable(complaint);
		
		if(!com.isPresent()) {
			
			throw new ComplaintNotFoundException("Complaint id : "+Id+" is not exist");
		}
		
		return complaint;
	}
	
	public List<Complaint> findComplaint(int userId){
		
		List<Complaint> complaintList = complaintRepository.findByUserId(userId);
		
		if(complaintList.isEmpty()) {
			
			throw new ComplaintNotFoundException("User id : "+userId+" is not exist");
		}
		
		return complaintList;
	}
			
	
	public User fetchByUserId(int userId) {
		
		User user = userRepository.findByUserId(userId);
		
		Optional<User> userOpt = Optional.ofNullable(user);
		
		if(!userOpt.isPresent()) {
			
			throw new ComplaintNotFoundException("User id : "+userId+" is not exist");

		}
		
		return user;
		 
	}
	
	public User changePassword(User user) {
		
		return userRepository.save(user);
	}
	
	
	public ContactUs userContactUs(ContactUs contactUs) {
		
		Optional<ContactUs> contactOptional = Optional.ofNullable(contactUs);
		
		if(!contactOptional.isPresent()) {
			
			throw new ComplaintNotFoundException("contact us Object May empty!!");
		}
		
		return contactUsRepository.save(contactUs);
	}
	
	
	
		

}
