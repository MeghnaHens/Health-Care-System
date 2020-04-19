package com.cg.hcs.exception;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DiagnosticCenterNameException extends Exception{
	
	static Logger logger=LogManager.getLogger(DiagnosticCenterNameException.class);
	public DiagnosticCenterNameException() {
		
		logger.error("Diagnostic center name must be in characters only..!");
	}
}
