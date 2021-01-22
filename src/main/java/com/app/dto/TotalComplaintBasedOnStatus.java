package com.app.dto;

public class TotalComplaintBasedOnStatus {
	
	private String complaintStatus;
	
	private int complaintCount;

	public TotalComplaintBasedOnStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TotalComplaintBasedOnStatus(String complaintStatus, int complaintCount) {
		super();
		this.complaintStatus = complaintStatus;
		this.complaintCount = complaintCount;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public int getComplaintCount() {
		return complaintCount;
	}

	public void setComplaintCount(int complaintCount) {
		this.complaintCount = complaintCount;
	}
	
	

}
