package br.com.fernandes.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.fernandes.controller.StandardError;
import br.com.fernandes.service.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ValidationExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> erros = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->
		erros.put(error.getField(), error.getDefaultMessage())
		);
		
		return new ResponseEntity<>(erros,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> UerNotFound(ResourceNotFoundException ex) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError erro = new StandardError(ex.getMessage(), Instant.now());
		
		return ResponseEntity.status(status).body(erro);				
	}

}
