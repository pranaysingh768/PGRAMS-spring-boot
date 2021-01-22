package com.app.dto;



public class ComplaintReport {
	
	
	private String complaintType;
	
	private String complaintTitle;
	
	private String complaintDetail;
	
	private String complaintAddress;
	
	private String complaintCity;
	
	private String complaintDate;
	
	private String complaintStatus;
	
	
	private String userName;
	
	private String userMail;
	
	private String userPhoneNo;

	public ComplaintReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComplaintReport(String complaintType, String complaintTitle, String complaintDetail, String complaintAddress,
			String complaintCity, String complaintDate, String complaintStatus, String userName, String userMail,
			String userPhoneNo) {
		super();
		this.complaintType = complaintType;
		this.complaintTitle = complaintTitle;
		this.complaintDetail = complaintDetail;
		this.complaintAddress = complaintAddress;
		this.complaintCity = complaintCity;
		this.complaintDate = complaintDate;
		this.complaintStatus = complaintStatus;
		this.userName = userName;
		this.userMail = userMail;
		this.userPhoneNo = userPhoneNo;
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

	public String getComplaintCity() {
		return complaintCity;
	}

	public void setComplaintCity(String complaintCity) {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	
	
	
}
