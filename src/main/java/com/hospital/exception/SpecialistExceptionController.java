package com.hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SpecialistExceptionController {

	@ExceptionHandler(value = SpecialistNotFoundException.class)
	public ResponseEntity<Object> specialistNotFoundException(SpecialistNotFoundException specialistNotFoundException) {
		return new ResponseEntity<>("Specialist Details not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = HospitalNotFoundException.class)
	public ResponseEntity<Object> hospitalNotFoundException(HospitalNotFoundException hospitalNotFoundException) {
		return new ResponseEntity<>("Hopital not found", HttpStatus.NOT_FOUND);
	}
}
