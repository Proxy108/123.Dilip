package com.techNarayana.ejobzz.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.techNarayana.ejobzz.util.DatabaseCommUtils;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	DatabaseCommUtils databaseCommUtils;
	private static final Logger logger=Logger.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(NullPointerException.class)
	public String handleNullException(HttpServletRequest request,Exception e){
		logger.info("NullPointer Occured:: URL="+request.getRequestURL());
		e.printStackTrace();
		return "genericError";
	}
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundException(HttpServletRequest request,Exception e){
		e.printStackTrace();
		logger.info("Request URI NOt Found "+request.getRequestURL());
		return "404";
	}
	@ExceptionHandler(SQLException.class)
	public String handleSQlException(HttpServletRequest request,Exception e){
		e.printStackTrace();
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
		
		return "genericError";
	}
	
	
	@ExceptionHandler(IOException.class)
	public String handleIOExceptionHandle(HttpServletRequest request,Exception e){
		e.printStackTrace();
		logger.info("IOEException Occured:: URL="+request.getRequestURL());

		return "genericError";
	}
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request,Exception e){
		e.printStackTrace();
		logger.info("Exception Occured:: URL="+request.getRequestURL());
		return "genericError";
	}
	@ExceptionHandler(HttpSessionRequiredException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason="The session has expired")	
	public String handleSessionExpired(HttpServletRequest request,Exception e,Model model){	
		e.printStackTrace();
		model.addAttribute("location", databaseCommUtils.getAllLocations());
	  return "home";
	}
	

}
