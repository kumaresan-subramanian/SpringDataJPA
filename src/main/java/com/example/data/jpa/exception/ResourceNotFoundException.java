package com.example.data.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldname;
	private Long fieldvalue;
	
	public ResourceNotFoundException(String resourceName, String fieldname, Long fieldvalue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fieldname, fieldvalue));
		this.resourceName = resourceName;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}

}
