package com.app.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.EmployeeDailyStatus;
import com.app.entity.Complaint;
import com.app.entity.EveryDayStatus;
import com.app.exception.ComplaintNotFoundException;
import com.app.repo.ComplaintRepository;
import com.app.repo.EveryDayStatusRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EveryDayStatusRepository everyDayStatusRepository;
	
	@Autowired
	private ComplaintRepository complaintRepository;
		
	
	public void checkeveryDayStatus(EmployeeDailyStatus everyDayStatus) {
		
		Optional<EmployeeDailyStatus> everydayOptional = Optional.ofNullable(everyDayStatus);
		
		if(!everydayOptional.isPresent()) {
			
			throw new ComplaintNotFoundException("Not allowed to access EmployeeDailyStatus object, it contains null");
		}
	}
	
	public EveryDayStatus addDailyStatus(EveryDayStatus everyDayStatus) {
		
		return everyDayStatusRepository.save(everyDayStatus);
	}
	
	
	public List<EveryDayStatus> findAllStatusOnCid(int cId){
		
		List<EveryDayStatus> everyDayStatusList = everyDayStatusRepository.findBycomplaintId(cId);
		
		if(everyDayStatusList.isEmpty()) {
			
			throw new ComplaintNotFoundException("Complaint id : "+cId+" is not exist");
		}
		
//		Optional<Complaint>  com = Optional.of(complaint);
//		
//		if(!com.isPresent()) {
//			throw new ComplaintNotFoundException("Complaint id : "+cId+" is not exist");
//		}
		return everyDayStatusList;
	
	}
	
	public Complaint fetchById(int cId) {
		
		Complaint complaintObj = complaintRepository.findByComplaintId(cId);
		Optional<Complaint>  complaintOpt = Optional.ofNullable(complaintObj);
		
		if(!complaintOpt.isPresent()) {
			throw new ComplaintNotFoundException("Complaint id : "+cId+" is not exist");
		}
		
		return complaintObj;
	}
	
	public List<Complaint> findComplaintByEmpId(int empId,String str) {
		
		List<Complaint> complaintList = complaintRepository.findByEmployeeIdAndUserComplaintStatus(empId,str);

		if(complaintList.isEmpty()) {
			throw new ComplaintNotFoundException("Employee id : "+empId+" is not exist");
		}
		
		return complaintList;
	}
}
