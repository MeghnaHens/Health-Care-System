package com.cg.hcs.exception;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DiagnosticCenterIdException extends Exception{
	
	static Logger logger=LogManager.getLogger(DiagnosticCenterIdException.class);
	public DiagnosticCenterIdException() {
		
		logger.error("Incorrect Diagnostic center Id..!");
	}
}
