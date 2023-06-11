package com.example.data.jpa.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleRsourceNotFoundException(ResourceNotFoundException exception,
																		WebRequest request){
		
		ErrorDetails error = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				request.getDescription(false),
				"USER_NOT_FOUND"
		);
		
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception,
																		WebRequest request){
		
		ErrorDetails error = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				request.getDescription(false),
				"USER_EMAIL_ALREADY_EXISTS"
		);
		
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception,
																		WebRequest request){
		
		ErrorDetails error = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				request.getDescription(false),
				"INTERNAL_SERVER_ERROR"
		);
		
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		
		Map<String, String> errors = new HashMap<>();
		List<ObjectError> erroList = ex.getBindingResult().getAllErrors();
		
		erroList.forEach((error) -> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
}
