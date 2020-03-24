package com.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RecordNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(CompanyNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> exception(CompanyNotFoundException exception) {
		return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
	}

}
