package com.app.entity;

import javax.persistence.*;

import lombok.ToString;

@Entity
@Table(name="complaint")
@ToString
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="complaint_id")
	private int complaintId;
	
	@Column(name="complaint_type")
	private String complaintType;
	
	@Column(name="complaint_title")
	private String complaintTitle;
	
	@Column(name="complaint_detail")
	private String complaintDetail;
	
	@Column(name="complaint_address")
	private String complaintAddress;
	
	@Column(name="complaint_city")
	private String complaintCity;
	
	@Column(name="complaint_date")
	private String complaintDate;
	
	@Column(name="complaint_status")
	private String complaintStatus;
	
	@Column(name="user_complaint_status")
	private String userComplaintStatus;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="employee_id")
	private int employeeId;

	
	
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
	
	public Complaint(int complaintId, String complaintType, String complaintTitle, String complaintDetail,
			String complaintAddress, String complaintCity, String complaintDate, String complaintStatus,
			String userComplaintStatus, int userId, int employeeId) {
		super();
		this.complaintId = complaintId;
		this.complaintType = complaintType;
		this.complaintTitle = complaintTitle;
		this.complaintDetail = complaintDetail;
		this.complaintAddress = complaintAddress;
		this.complaintCity = complaintCity;
		this.complaintDate = complaintDate;
		this.complaintStatus = complaintStatus;
		this.userComplaintStatus = userComplaintStatus;
		this.userId = userId;
		this.employeeId = employeeId;
	}
	
	






	public String getUserComplaintStatus() {
		return userComplaintStatus;
	}






	public void setUserComplaintStatus(String userComplaintStatus) {
		this.userComplaintStatus = userComplaintStatus;
	}






	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getComplaintTitle() {
		return complaintTitle;
	}

	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}

	public String getComplaintDetail() {
		return complaintDetail;
	}

	public void setComplaintDetail(String complaintDetail) {
		this.complaintDetail = complaintDetail;
	}

	public String getComplaintAddress() {
		return complaintAddress;
	}

	public void setComplaintAddress(String complaintAddress) {
		this.complaintAddress = complaintAddress;
	}

	public String getComplaintcity() {
		return complaintCity;
	}

	public void setComplaintcity(String complaintCity) {
		this.complaintCity = complaintCity;
	}

	public String getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getComplaintCity() {
		return complaintCity;
	}


	public void setComplaintCity(String complaintCity) {
		this.complaintCity = complaintCity;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
}
