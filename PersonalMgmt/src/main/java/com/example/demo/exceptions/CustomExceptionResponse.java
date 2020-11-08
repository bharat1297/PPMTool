package com.example.demo.exceptions;


public class CustomExceptionResponse {
	
	private String customException;

	

	public CustomExceptionResponse(String customException) {
		this.customException = customException;
	}

	public String getCustomException() {
		return customException;
	}

	public void setCustomException(String customException) {
		this.customException = customException;
	}
	
	
}
