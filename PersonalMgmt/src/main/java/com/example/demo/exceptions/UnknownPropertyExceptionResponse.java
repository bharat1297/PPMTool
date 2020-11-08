package com.example.demo.exceptions;

public class UnknownPropertyExceptionResponse {

	private String unknownProperty;

	public UnknownPropertyExceptionResponse(String unknownProperty) {
			this.unknownProperty= unknownProperty;
	}

	public String getUnknownProperty() {
		return unknownProperty;
	}

	public void setUnknownProperty(String unknownProperty) {
		this.unknownProperty = unknownProperty;
	}
	
}
