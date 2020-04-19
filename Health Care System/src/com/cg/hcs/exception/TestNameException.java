package com.cg.hcs.exception;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TestNameException extends Exception{
	
	static Logger logger=LogManager.getLogger(TestNameException.class);
		public TestNameException() {
			
			logger.error("Test name must be in characters..!");
			//System.out.println("Test name must be in characters..!");
		}
}
