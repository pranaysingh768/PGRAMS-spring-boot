package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.entity.ComplaintErrorResponse;

@ControllerAdvice
public class ComplaintControllerAdvice {
	
	@ExceptionHandler
	public ResponseEntity<ComplaintErrorResponse> handleCustomException(ComplaintNotFoundException cnf) {
		
		ComplaintErrorResponse complaintErrorResponse = new ComplaintErrorResponse();
		
		complaintErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		complaintErrorResponse.setMessage(cnf.getMessage());
		complaintErrorResponse.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<ComplaintErrorResponse>  (complaintErrorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ComplaintErrorResponse> handleCustomException(Exception ex) {
		
		ComplaintErrorResponse complaintErrorResponse = new ComplaintErrorResponse();
		
		complaintErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		complaintErrorResponse.setMessage(ex.getMessage());
		complaintErrorResponse.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<ComplaintErrorResponse>  (complaintErrorResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	
}
