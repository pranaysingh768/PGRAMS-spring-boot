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
}    