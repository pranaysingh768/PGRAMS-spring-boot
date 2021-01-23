package com.app.dto;


public class EmployeeDailyStatus {
	
	
	private int userId;
	
	private String statusDescription;
	
	private String statusType;

	public EmployeeDailyStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDailyStatus(int userId, String statusDescription, String statusType) {
		super();
		this.userId = userId;
		this.statusDescription = statusDescription;
		this.statusType = statusType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getComplaintStatus() {
		return statusType;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.statusType = complaintStatus;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	@Override
	public String toString() {
		return "EmployeeDailyStatus [userId=" + userId + ", statusDescription=" + statusDescription + ", statusType="
				+ statusType + "]";
	}
	
	
	
	
}
