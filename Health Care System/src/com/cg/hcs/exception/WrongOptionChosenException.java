package com.cg.hcs.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongOptionChosenException extends Exception{
	
	static Logger logger=LogManager.getLogger(WrongOptionChosenException.class);
	
	public WrongOptionChosenException() {
		
		logger.error("Choose Valid option..! ");
	}
}
