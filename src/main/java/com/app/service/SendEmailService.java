package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String to,String body,String topic) {
		
		System.out.println("sending mail...");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("pranays297@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(topic);
		simpleMailMessage.setText(body);
		javaMailSender.send(simpleMailMessage);
		System.out.println("send mail...");
		
	}

}
