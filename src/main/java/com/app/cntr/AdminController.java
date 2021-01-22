package com.app.cntr;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ComplaintReport;
import com.app.dto.TotalComplaintBasedOnDate;
import com.app.dto.TotalComplaintBasedOnStatus;
import com.app.entity.Complaint;
import com.app.entity.Notification;
import com.app.entity.User;
import com.app.exception.ComplaintNotFoundException;
import com.app.service.AdminService;
import com.app.service.AuthService;
import com.app.service.NotificationService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private NotificationService notificationService;
	
	
	@CrossOrigin
	@GetMapping("/complaintApproved/{cId}")
	public Complaint approvedUserComplaint(@PathVariable int cId)  {
		
		Complaint complaint = adminService.fetchById(cId);
				
		complaint.setUserComplaintStatus("Approved");
		complaint.setComplaintStatus("Not yet proceed");
		//complaint.setComplaintStatus("Not yet proced");
		
		adminService.saveUserComplaintStatus(complaint);
		
		notificationService.saveNotification(complaint);
		
		return complaint;
	}
	
	@CrossOrigin
	@GetMapping("/complaintRejected/{cId}")
	public Complaint rejectedUserComplaint(@PathVariable int cId){
		
		Complaint complaint = adminService.fetchById(cId);
			
		complaint.setUserComplaintStatus("Rejected");
		complaint.setComplaintStatus("Invalid complaint");
		adminService.saveUserComplaintStatus(complaint);
		
		return complaint;
	}
	
	
	@CrossOrigin
	@GetMapping("/approvedComplaintDetail")
	public List<Complaint> getAllApprovedComplaints(){
		
		return adminService.findAllApprovedComplaint();
	
	}
	
	@CrossOrigin
	@GetMapping("/allComplaintDetail")
	public List<Complaint> getAllComplaints(){
		
		return adminService.findAllComplaint();
	
	}
	
	
	@CrossOrigin
	@GetMapping("/allEmp")
	public List<User> getAllEmp(){
		
		return adminService.findAllEmp("emp");
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteEmp/{eid}")
	public User deleteEmployee(@PathVariable int eid) {
		
		User user = adminService.fetchByUserId(eid);
		
		adminService.deleteEmp(user);
		
		return user;
	}
	
	@CrossOrigin
	@GetMapping("/getEmp/{eid}")
	public User getEmployee(@PathVariable int eid) {
		
		return adminService.fetchByUserId(eid);
		
	}
	
	@CrossOrigin
	@GetMapping("/getEmpOnMail")
	public User getEmployeeOnMail(@RequestBody User user) {
		
		String tempMail = user.getUserMail();
		Optional<String> mailOptional = Optional.ofNullable(tempMail);
		User userObj =new User();
		
		if(mailOptional.isPresent() && !"".equals(tempMail)) {
			
			 userObj = authService.fetchByUserMail(tempMail);
		}
	
		return userObj;
	}
	
	
	@CrossOrigin
	@PutMapping("/updateEmp/{eid}")
	public User updateEmployee(@PathVariable int eid,@RequestBody User user) {
		
		User userObj = adminService.fetchByUserId(eid);
		
		userObj.setUserName(user.getUserName());
		userObj.setUserMail(user.getUserMail());
		userObj.setUserPhoneNo(user.getUserPhoneNo());
		if(userObj.getUserType().equalsIgnoreCase("emp")) {
			userObj.setUserDepartment(user.getUserDepartment());
		}
		else {
			userObj.setUserCity(user.getUserCity());	
		}
		
		adminService.updateEmp(userObj);
		
		return userObj;
	}
	
	
	@CrossOrigin
	@GetMapping("/complaintCountDate")
	public List<TotalComplaintBasedOnDate> getComplaintsCountOnDate(){
		
		return adminService.findComplaintCountBasedOnDate();
	}
	
	@CrossOrigin
	@GetMapping("/complaintCountStatus")
	public List<TotalComplaintBasedOnStatus> getComplaintsCountOnStatus(){
		
		
		return adminService.findComplaintCountBasedOnStatus();
	}
	
	
	@CrossOrigin
	@GetMapping("/notProceedComplaint")
	public List<Complaint> getNotProceedComplaints(){
		
		return adminService.findAllComplaintBasedOnStatus("Not yet proceed");
	
	}
	
	@CrossOrigin
	@GetMapping("/InProceedComplaint")
	public List<Complaint> getInProcessComplaints(){
		
		return adminService.findAllComplaintBasedOnStatus("In Process");
	
	}
	
	@CrossOrigin
	@GetMapping("/closedComplaint")
	public List<Complaint> getClosedComplaints(){
		
		return adminService.findAllComplaintBasedOnStatus("Closed");
	
	}
	
	
	@CrossOrigin
	@PutMapping("/assignComplaint/{cId}")
	public Complaint assignToEmployee(@PathVariable int cId, @RequestBody User user) {
		
		String tempMail = user.getUserMail();
		
		Optional<String> mailOptional = Optional.ofNullable(tempMail);
		
		if(mailOptional.isPresent() && !"".equals(tempMail)) {
			
			User userObj = authService.fetchByUserMail(tempMail);
			
			int employeeId = userObj.getUserId();
			
			Complaint complaint = adminService.fetchById(cId);
			
			complaint.setEmployeeId(employeeId);
			complaint.setComplaintStatus("In Process");
			adminService.saveUserComplaintStatus(complaint);
			
			return complaint;
		}
		else {

			throw new ComplaintNotFoundException("Invalid Mail Id for work assignment");
		}
		
	}
	
	@CrossOrigin
	@GetMapping("/getEmpDetail/{tempMail}")
	public User getEmpDetailOnMail(@PathVariable String tempMail) {
		
		Optional<String> mailOptional = Optional.ofNullable(tempMail);
		
		User userObj = new User();
		
		if(mailOptional.isPresent() && !"".equals(tempMail)) {
			
			userObj = authService.fetchByUserMail(tempMail);
		}
		else {

			throw new ComplaintNotFoundException("Invalid Mail Id to get Emp detail");
		}
		
		return userObj;
	}
	
	
	
	
	
	@CrossOrigin
	@GetMapping("/allComplaintReport")
	public List<ComplaintReport> getAllComplaintsReport(){
		
		return adminService.findAllComplaintReport();
	
	}
	
	
}
