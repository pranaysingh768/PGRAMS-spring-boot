package com.app.entity;

import javax.persistence.*;

import lombok.ToString;

@Entity
@Table(name="user")
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_mail")
	private String userMail;
	
	@Column(name="user_phone_no")
	private String userPhoneNo;
	
	@Column(name="user_address")
	private String userAddress;
	
	@Column(name="user_city")
	private String userCity;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="user_department")
	private String userDepartment;
	
	@Column(name="user_reg_date")
	private String userRegDate;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="user_action")
	private String userAction;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	


	public User(int userId, String userName, String userMail, String userPhoneNo, String userAddress, String userCity,
			String userPassword, String userDepartment, String userRegDate, String userType, String userAction) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userMail = userMail;
		this.userPhoneNo = userPhoneNo;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.userPassword = userPassword;
		this.userDepartment = userDepartment;
		this.userRegDate = userRegDate;
		this.userType = userType;
		this.userAction = userAction;
	}





	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getUserRegDate() {
		return userRegDate;
	}


	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}


	public String getUserAction() {
		return userAction;
	}





	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}





	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userMail=" + userMail + ", userPhoneNo="
				+ userPhoneNo + ", userAddress=" + userAddress + ", userCity=" + userCity + ", userPassword="
				+ userPassword + ", userDepartment=" + userDepartment + ", userRegDate=" + userRegDate + ", userType="
				+ userType + "]";
	}
	
	
	
	
	
	
}
