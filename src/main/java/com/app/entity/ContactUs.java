package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table
@ToString
public class ContactUs {
	
	@Id
	@GeneratedValue
	@Column(name = "contact_us_id")
	private int contactUsId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String eMailId;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "message_body")
	private String messageBody;

	public ContactUs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactUs(int contactUsId, String firstName, String lastName, String eMailId, String subject,
			String messageBody) {
		super();
		this.contactUsId = contactUsId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMailId = eMailId;
		this.subject = subject;
		this.messageBody = messageBody;
	}

	public int getContactUsId() {
		return contactUsId;
	}

	public void setContactUsId(int contactUsId) {
		this.contactUsId = contactUsId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMailId() {
		return eMailId;
	}

	public void seteMailId(String eMailId) {
		this.eMailId = eMailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	@Override
	public String toString() {
		return "ContactUs [contactUsId=" + contactUsId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", eMailId=" + eMailId + ", subject=" + subject + ", messageBody=" + messageBody + "]";
	}
	
	
}
