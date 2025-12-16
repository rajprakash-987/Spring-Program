package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class PlayerControllerAdvice {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handlelAE(IllegalArgumentException iae){
		log.info("handling playersnot found exception");
		return new ResponseEntity<String>(iae.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handlelAE(Exception e){
		log.info("handling all unknown exception");
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
