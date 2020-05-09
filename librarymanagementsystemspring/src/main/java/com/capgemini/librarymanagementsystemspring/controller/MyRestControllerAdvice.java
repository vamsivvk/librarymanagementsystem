package com.capgemini.librarymanagementsystemspring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.librarymanagementsystemspring.dto.lmsResponse;
import com.capgemini.librarymanagementsystemspring.exceptions.LMSException;

@RestControllerAdvice
public class MyRestControllerAdvice {
	@ExceptionHandler
	public lmsResponse myExceptionHandler(LMSException lmsException) {
		lmsResponse response = new lmsResponse();
		response.setError(true);
		response.setMessage(lmsException.getMessage());
		return response;
	}

}
