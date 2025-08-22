package com.bossien.sampleweb;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
//	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Object validationBodyException(MethodArgumentNotValidException exception) {
		return null;
	}
}
