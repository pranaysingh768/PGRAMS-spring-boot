package com.app.cntr;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmployeeDailyStatus;
import com.app.entity.Complaint;
import com.app.entity.EveryDayStatus;
import com.app.exception.ComplaintNotFoundException;
import com.app.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@CrossOrigin
	@PostMapping("/postStatus/{cId}")
	public EveryDayStatus addDailyEmpStatus(@RequestBody EmployeeDailyStatus employeeDailyStatus,@PathVariable int cId){
		 
		employeeService.checkeveryDayStatus(employeeDailyStatus);
		
		String statusDetail = employeeDailyStatus.getStatusDescription();
		
		Optional<String> detailOptional = Optional.ofNullable(statusDetail);
		
		if(!detailOptional.isPresent() || statusDetail.length() < 10) {
			
			throw new ComplaintNotFoundException("please provide status description more than 10 char");
		}
		
		 Complaint complaint = employeeService.fetchById(cId);
		 
		 EveryDayStatus everyDayStatus = new EveryDayStatus();
		 
		 String today = new Date().getDate()+"-"+(new Date().getMonth() +1)+"-"+"2021";
		 everyDayStatus.setStatusDate(today);
		 everyDayStatus.setComplaintId(cId);
		 everyDayStatus.setStatusDescription(employeeDailyStatus.getStatusDescription());
		 everyDayStatus.setUserId(employeeDailyStatus.getUserId());
		 
		 
		 if(employeeDailyStatus.getComplaintStatus().equalsIgnoreCase("Yes! closed")) {
			 complaint.setComplaintStatus("Closed");
			 everyDayStatus.setStatusType("Closed");
		 }else {
			 everyDayStatus.setStatusType(complaint.getComplaintStatus());
		 }
		 return employeeService.addDailyStatus(everyDayStatus);
		 
	}
}    