package com.ibm.controller;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ibm.exception.ErrorDetails;
import com.ibm.exception.ValueMismatchException;

@RestControllerAdvice
public class CurrencyControllerAdvice {

	@ExceptionHandler(ValueMismatchException.class)
	public ResponseEntity<ErrorDetails> handleValueNotFound(ValueMismatchException e)
	{
		ErrorDetails ed = new ErrorDetails("value-400", "Value is not Present !", LocalDateTime.now());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ed);
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handleInvalidCurrency(MethodArgumentNotValidException e)
	{
		e.printStackTrace();
		ErrorDetails ed = new ErrorDetails("Currency-404", "Data not found !", LocalDateTime.now());
		ed.setErrorFields(e.getFieldErrors());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDetails> handleDuplicateData(DataIntegrityViolationException e)
	{
		e.printStackTrace();
		ErrorDetails ed = new ErrorDetails("Duplicate Country code", "Country code already exist", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);	
	}
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorDetails> handleEmptyData(NullPointerException e)
	{
		e.printStackTrace();
		ErrorDetails ed = new ErrorDetails("Empty Table", "Data does not exist !", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);	
	}
	
}
