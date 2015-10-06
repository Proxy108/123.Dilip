/*package com.techNarayana.ejobzz.util;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger=Logger.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(NullPointerException.class)
	public String handleNullException(HttpServletRequest request,Exception e){
		logger.info("NullPointer Occured:: URL="+request.getRequestURL());
		return "genericError";
	}
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundException(HttpServletRequest request,Exception e){
		logger.info("Request URI NOt Found "+request.getRequestURL());
		return "genericError";
	}
	@ExceptionHandler(SQLException.class)
	public String handleSQlException(HttpServletRequest request,Exception e){
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
		return "genericError";
	}
	
	
	
	@ExceptionHandler(IOException.class)
	public String handleIOExceptionHandle(HttpServletRequest request){
		logger.info("IOEException Occured:: URL="+request.getRequestURL());

		return "genericError";
	}
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request,Exception e){
		logger.info("Exception Occured:: URL="+request.getRequestURL());
		return "genericError";
	}
	

}
*/