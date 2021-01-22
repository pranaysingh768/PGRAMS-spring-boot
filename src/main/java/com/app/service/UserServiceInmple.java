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
}
