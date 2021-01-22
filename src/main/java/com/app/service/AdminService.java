package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ComplaintDaoImple;
import com.app.dto.ComplaintReport;
import com.app.dto.TotalComplaintBasedOnDate;
import com.app.dto.TotalComplaintBasedOnStatus;
import com.app.entity.Complaint;
import com.app.entity.User;
import com.app.exception.ComplaintNotFoundException;
import com.app.repo.ComplaintRepository;
import com.app.repo.UserRepository;

@Service
public class AdminService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ComplaintRepository complaintRepository;
	
	@Autowired
	private ComplaintDaoImple complaintDaoImple; 
	
	
	public Complaint saveUserComplaintStatus(Complaint complaint) {
		
		return complaintRepository.save(complaint);
	}
	
	public Complaint fetchById(int cId) {
		
		Complaint complaint = complaintRepository.findByComplaintId(cId);
		
		Optional<Complaint> comOptional = Optional.ofNullable(complaint);
		
		if(!comOptional.isPresent()) {
			
			throw new ComplaintNotFoundException("Complaint id : "+cId+" is not exist");
		}
		
		return complaint;
	}
	
	public List<Complaint> findAllApprovedComplaint(){
		
		List<Complaint> comList = complaintRepository.findByUserComplaintStatus("Approved");
	
		if(comList.isEmpty()) {
			
			throw new ComplaintNotFoundException("Approved list is empty!!");
		}
		
		return comList;
	}
	
	public List<Complaint> findAllComplaint(){
		
		List<Complaint> comList = complaintRepository.findAll();
		
		if(comList.isEmpty()) {
			
			throw new ComplaintNotFoundException("Complaint list is empty!!");
		}
		
		return comList;
		
	}
	
	

	public List<TotalComplaintBasedOnDate> findComplaintCountBasedOnDate(){
		
		List<TotalComplaintBasedOnDate> totalList = complaintDaoImple.complaintCountBasedOnDate();
		
		if(totalList.isEmpty()) {
			throw new ComplaintNotFoundException("Total Complaint Based On Date is Empty");
		}
		
		return totalList;
	}
	
	public List<TotalComplaintBasedOnStatus> findComplaintCountBasedOnStatus(){
		
		List<TotalComplaintBasedOnStatus> totalList  = complaintDaoImple.complaintCountBasedOnStatus();
		
		if(totalList.isEmpty()) {
			throw new ComplaintNotFoundException("Total Complaint Based On Status is Empty");
		}
		
		return totalList; 
	}
	
	
	public List<Complaint> findAllComplaintBasedOnStatus(String status){
		
		List<Complaint> allComp = complaintRepository.findByComplaintStatus(status);
		
		if(allComp.isEmpty()) {
			throw new ComplaintNotFoundException("All Complaint Based On Status is Empty");
		}
		
		return allComp;
	}
	
	

	public List<User> findAllEmp(String tempType){
		
		List<User> usList = userRepository.findByUserTypeAndUserAction(tempType,"Active");
		
//		if(usList.isEmpty()) {
//			
//			throw new ComplaintNotFoundException("Employee list is empty!!");
//		}
		
		return usList;
	}
	
	
	public User fetchByUserId(int eid) {
		
		User user = userRepository.findByUserId(eid);
		
		Optional<User> userOptional = Optional.ofNullable(user);
		
		if(!userOptional.isPresent()) {
			
			throw new ComplaintNotFoundException("Employee id : "+eid+" is not exist");

		}
		
		return user;
		 
	}
	
	public void deleteEmp(User user) {
		
		user.setUserAction("In Active");
		
		userRepository.save(user);
	}
	
	public User updateEmp(User user) {
		
		return userRepository.save(user);
	}
	
	
	public List<ComplaintReport> findAllComplaintReport(){
		
		List<ComplaintReport> compReportList = complaintDaoImple.allComplaintReport();
		
		if(compReportList.isEmpty()) {
			
			throw new ComplaintNotFoundException("Employee list is empty!!");
		}
		return compReportList;
	}
	
}
