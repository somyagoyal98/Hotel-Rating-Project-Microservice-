package com.microservice.rating.service.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {

		String message = ex.getMessage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", HttpStatus.NOT_FOUND);
		map.put("message", message);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);

	}
}
