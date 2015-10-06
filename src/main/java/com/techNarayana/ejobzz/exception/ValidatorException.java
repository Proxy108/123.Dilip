package com.techNarayana.ejobzz.exception;

import org.apache.log4j.Logger;

public class ValidatorException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8246001808906782379L;
	private static final Logger logger = Logger.getLogger(ValidatorException.class);
	public ValidatorException(String message) {
		
		super(message);
		logger.debug("Validation exception"+message);
	}
}
