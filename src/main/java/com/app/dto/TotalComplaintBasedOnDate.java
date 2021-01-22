package com.app.dto;

public class TotalComplaintBasedOnDate {
	
	private String complaintDate;
	
	private int complaintCount;
	
	public TotalComplaintBasedOnDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TotalComplaintBasedOnDate(String complaintDate, int complaintCount) {
		super();
		this.complaintDate = complaintDate;
		this.complaintCount = complaintCount;
	}
	public String getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}
	public int getComplaintCount() {
		return complaintCount;
	}
	public void setComplaintCount(int complaintCount) {
		this.complaintCount = complaintCount;
	}
	
}
