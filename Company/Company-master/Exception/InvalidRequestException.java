package com.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidRequestException extends Exception {

	private static final long serialVersionUID = 1L;

	@ExceptionHandler(InvalidRequestException.class)
	@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
	public ResponseEntity<Object> exception(InvalidRequestException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
