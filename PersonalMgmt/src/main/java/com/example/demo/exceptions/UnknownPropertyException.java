package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UnknownPropertyException extends RuntimeException{

	public UnknownPropertyException(String message) {
		super(message);
	}
	
}
