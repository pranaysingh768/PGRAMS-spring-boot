package com.app.entity;

import javax.persistence.*;


@Entity
@Table(name="every_day_status")
public class EveryDayStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="status_id")
	private int statusId;
	
	@Column(name="complaint_id")
	private int complaintId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="status_description")
	private String statusDescription;
	
	@Column(name="status_type")
	private String statusType;
	
	@Column(name="status_date")
	private String statusDate;

	public EveryDayStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EveryDayStatus(int statusId, int complaintId, int userId, String statusDescription, String statusDate) {
		super();
		this.statusId = statusId;
		this.complaintId = complaintId;
		this.userId = userId;
		this.statusDescription = statusDescription;
		this.statusDate = statusDate;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
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

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	@Override
	public String toString() {
		return "EveryDayStatus [statusId=" + statusId + ", complaintId=" + complaintId + ", userId=" + userId
				+ ", statusDescription=" + statusDescription + ", statusType=" + statusType + ", statusDate="
				+ statusDate + "]";
	}
	
	 
}
